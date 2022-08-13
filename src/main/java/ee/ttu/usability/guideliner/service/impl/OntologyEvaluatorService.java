package ee.ttu.usability.guideliner.service.impl;

import ee.ttu.usability.guideliner.domain.element.form.*;
import ee.ttu.usability.guideliner.domain.element.form.TextArea;
import ee.ttu.usability.guideliner.domain.element.link.*;
import ee.ttu.usability.guideliner.domain.element.link.Button;
import ee.ttu.usability.guideliner.domain.element.link.Frame;
import ee.ttu.usability.guideliner.domain.element.link.Object;
import ee.ttu.usability.guideliner.domain.guideline.Category;
import ee.ttu.usability.guideliner.estimation.adaptor.*;
import ee.ttu.usability.guideliner.estimation.result.Guideline;
import ee.ttu.usability.guideliner.estimation.result.ResultType;
import ee.ttu.usability.guideliner.repository.OntologyRepository;
import ee.ttu.usability.guideliner.domain.element.UsabilityGuideline;
import ee.ttu.usability.guideliner.domain.element.content.Paragraph;
import ee.ttu.usability.guideliner.domain.element.navigation.Navigation;
import ee.ttu.usability.guideliner.domain.page.UIPage;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.util.Screenshoter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAxiom;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.ac.manchester.cs.owl.owlapi.OWLSubClassOfAxiomImpl;

import java.awt.*;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.*;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class OntologyEvaluatorService {

	public static Integer DEFAULT_HEIGHT = 800;
	public static Integer DEFAULT_WIDTH = 1500;

	private OntologyRepository ontologyRepository;

	private GuildelineBuilderService builder;

	private OntologyService ontologyService;

//	private WebDriver driver;

	private List<AbstractAdaptor> adaptors;
	
	@Autowired
	public OntologyEvaluatorService(OntologyRepository ontologyRepository,
			GuildelineBuilderService builder, OntologyService ontologyService) {
		this.ontologyRepository = ontologyRepository;
		this.builder = builder;
		this.ontologyService = ontologyService;
	}

	private Screenshoter screenshoter = new Screenshoter();
	public List<EvaluationResult>  evaluate(Category category, String url) {
		List<EvaluationResult> results = new ArrayList<>();

		WebDriver driver = null;
		if (Category.MobileUsabilityGuideline.equals(category)) {
			driver = this.initializeForMobile();
		} else {
			driver = this.initialiseDriver();
		}

		log.info("Opening URL " + url);

		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, 60);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

		try {
			screenshoter.makeScreenshot(driver, true);
		} catch (IOException e) {
			throw new RuntimeException("Haha exception");
		}
		log.info("Starting evaluation: " + url);
		final AtomicInteger i = new AtomicInteger(1);
		final AtomicBoolean ffff = new AtomicBoolean(false);
		WebDriver finalDriver = driver;

		OntologyRepository.reasoner.getSubClasses(ontologyRepository.loadClass(category.name()))
				.entities()
				.filter(c -> !c.getIRI().getShortForm().equals("Nothing"))
				.forEach(c -> {
//					if (ffff.get()) {
//						return;
//					}
					i.addAndGet(1);
					LocalDateTime startTime = LocalDateTime.now();
					log.info("Starting evaluating guideline - "+i+": " + c.getIRI().getIRIString());
					EvaluationResult result = evaluate(c, url, finalDriver);
					if (result != null) {
						Guideline guideline = ontologyService.createGuideline(c);
						result.setURL(url);
						result.setGuidelineCode(guideline.getCode());
						result.setGuidelineName(guideline.getName());
						result.setGuidelineDescription(guideline.getDescription());
					//	result.setGuideline(guideline);
						result.getFailedElements().forEach(t -> {
							t.setEvaluationResult(result);
							t.setText(StringUtils.abbreviate(t.getText(), 800));
						});
						result.setEvaluationTime(startTime.until(LocalDateTime.now(), ChronoUnit.SECONDS));
						results.add(result);
//						ffff.set(true);
					}
					log.info("Finishing evaluating guideline: " + c.getIRI().getIRIString() + ". Evaluation took:" + startTime.until(LocalDateTime.now(), ChronoUnit.SECONDS));
				});
		Collections.sort(results, Comparator.comparing(o -> o.getResult().name()));
		driver.close();
		return results;
	}

	public EvaluationResult evaluateByName(String guideline, String url, WebDriver driver) {
		return evaluate(ontologyRepository.loadClass(guideline), url, true, driver);
	}

	public EvaluationResult evaluate(OWLClass guideline, String url, WebDriver driver) {
		return evaluate(guideline, url, false, driver);
	}

	public EvaluationResult evaluate(OWLClass guideline, String url, boolean openUrl, WebDriver driver) {
		if (driver == null) {
			driver = initialiseDriver();
		}

		// get guideline
		UsabilityGuideline guidelineElement = fillGuidelines(guideline);

		if (openUrl) {
			driver.get(url);
		}

		guidelineElement.setUrl(url);

		try {
			if (guidelineElement instanceof UIPage) {
				try {
					UIPageAdaptor adaptor = new UIPageAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((UIPage) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}
			if (guidelineElement instanceof Link) {
				try {
					LinkAdaptor adaptor = new LinkAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((Link) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}
			if (guidelineElement instanceof Paragraph) {
				try {
					ParagraphAdaptor adaptor = new ParagraphAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((Paragraph) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}
			if (guidelineElement instanceof Form) {
				try {
					FormAdaptor adaptor = new FormAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((Form) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}
			if (guidelineElement instanceof Graphic) {
				try {
					GraphicAdaptor adaptor = new GraphicAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((Graphic) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}
			if (guidelineElement instanceof Navigation) {
				try {
					NavigationAdaptor adaptor = new NavigationAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((Navigation) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}
			if (guidelineElement instanceof Multimedia) {
				try {
					MultimediaAdaptor adaptor = new MultimediaAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((Multimedia) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}
			if (guidelineElement instanceof Button) {
				try {
					ButtonAdaptor adaptor = new ButtonAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((Button) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}
			if (guidelineElement instanceof NumberedList) {
				try {
					NumberedListAdaptor adaptor = new NumberedListAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((NumberedList) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}
			if (guidelineElement instanceof Area) {
				try {
					AreaAdaptor adaptor = new AreaAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((Area) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}

			if (guidelineElement instanceof FormElementLabel) {
				try {
					FormElementLabelAdaptor adaptor = new FormElementLabelAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((FormElementLabel) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}

			if (guidelineElement instanceof Input) {
				try {
					InputAdaptor adaptor = new InputAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((Input) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}

			if (guidelineElement instanceof Radio) {
				try {
					RadioAdaptor adaptor = new RadioAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((Radio) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}

			if (guidelineElement instanceof CheckBox) {
				try {
					CheckButtonAdaptor adaptor = new CheckButtonAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((CheckBox) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}

			if (guidelineElement instanceof Password) {
				try {
					PasswordAdaptor adaptor = new PasswordAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((Password) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}

			if (guidelineElement instanceof File) {
				try {
					FileAdaptor adaptor = new FileAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((File) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}

			if (guidelineElement instanceof TextArea) {
				try {
					TextAreaAdaptor adaptor = new TextAreaAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((TextArea) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}

			if (guidelineElement instanceof Text) {
				try {
					TextAdaptor adaptor = new TextAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((Text) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}

			if (guidelineElement instanceof Select) {
				try {
					SelectAdaptor adaptor = new SelectAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((Select) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}

			if (guidelineElement instanceof Frame) {
				try {
					FrameAdaptor adaptor = new FrameAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((Frame) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}

			if (guidelineElement instanceof Embed) {
				try {
					EmbedAdaptor adaptor = new EmbedAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((Embed) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}

			if (guidelineElement instanceof Object) {
				try {
					ObjectAdaptor adaptor = new ObjectAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((Object) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}

			if (guidelineElement instanceof Applet) {
				try {
					AppletAdaptor adaptor = new AppletAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((Applet) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}

			if (guidelineElement instanceof TableHeader) {
				try {
					TableHeaderAdaptor adaptor = new TableHeaderAdaptor();
					adaptor.setDriver(driver);
					return adaptor.execute((TableHeader) guidelineElement);
				} catch (Exception ex) {
					throw  ex;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			EvaluationResult evaluationResult = new EvaluationResult();
			evaluationResult.setResult(ResultType.ERROR);
			return evaluationResult;
		}

		throw new RuntimeException("Cannot find adaptor for " + guidelineElement.getClass());
		//	driver.close();
	}

	public static <T> T createInstance(Class<T> clazz) {
		try {
			// Use reflection to instantiate the class represented by clazz
			return clazz.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// Handle the potential exceptions (e.g., no accessible no-argument constructor, class represents an abstract class, etc.)
			throw new RuntimeException("Could not instantiate the class", e);
		}
	}

	public WebDriver initialiseDriver() {
		// TODO add some logic
//		FirefoxProfile ffprofile = new FirefoxProfile();
//		ffprofile.setPreference("general.useragent.override", "iPhone");
//		driver = new FirefoxDriver(ffprofile);
//		driver.manage().window().setSize(new Dimension(400,800));

//				 System.setProperty("webdriver.chrome.driver",
//		 "..\\chrome\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//


		// desctop
		//if (driver == null) {
		WebDriver	driver = new FirefoxDriver();
		//}
		driver.manage().window().setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));

		return driver;
	}

	public WebDriver initializeForMobile() {
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("general.useragent.override", "iPhone");
//		new HtmlUnitDriver();
	//	if (driver == null) {
		WebDriver driver = new FirefoxDriver(ffprofile);
	//	}
		driver.manage().window().setSize(new Dimension(400,800));
		return driver;
	}

	public WebDriver initialiseDriverIfNotInitialised(String url, WebDriver driver) {
//
		if (driver != null) {
			return driver;
		}
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
		driver.get(url);
		return driver;
//		 System.setProperty("webdriver.chrome.driver",
//		 "..\\chrome\\chromedriver.exe");
//		 this.driver = new ChromeDriver();
//		driver.get(url);
//		return driver;
//		if (this.driver == null) {
//			this.driver =  new FirefoxDriver();
//			driver.get(url);
//		}
//
//		return driver;
	}


	public void closeDriver(WebDriver driver) {
		if (driver != null) {
		//	driver.close();
		}
	}



	public UsabilityGuideline fillGuidelines(OWLClass guideline) {
		UsabilityGuideline guidelineElement = this.getGuidelineElement(guideline);
		NodeSet<OWLNamedIndividual> instances = ontologyRepository.getIndividuals(guideline);
		builder.fillGuideline(instances, guidelineElement);
		return guidelineElement;
	}

	// TODO refactor
	@SuppressWarnings("deprecation")
	public UsabilityGuideline getGuidelineElement(OWLClass selectedGuideline) {
		for (OWLClassAxiom g : OntologyRepository.ontology
				.getAxioms(selectedGuideline)) {
			if (g instanceof OWLSubClassOfAxiomImpl) {
				OWLSubClassOfAxiomImpl g2 = (OWLSubClassOfAxiomImpl) g;
				if (g2.getSuperClass() instanceof OWLObjectSomeValuesFrom) {
					OWLObjectSomeValuesFrom someValueOf = (OWLObjectSomeValuesFrom) g2
							.getSuperClass();
					if ("hasGuidelineElement".equalsIgnoreCase(someValueOf
							.getProperty().asOWLObjectProperty().getIRI()
							.getShortForm())) {
						return transform(someValueOf.getFiller().asOWLClass().getIRI().getShortForm());
					}
					// System.out.println("aaaaaaaaaaa" +
					// someValueOf.getProperty().asOWLObjectProperty().getIRI().getShortForm());
					// System.out.println("aaaaaaaaaaa" +
					// someValueOf.getFiller().asOWLClass().getIRI().getShortForm()
					// + "type of fille" + someValueOf.getFiller().getClass());
				}
				if (g2.getSuperClass() instanceof OWLObjectAllValuesFrom) {

					OWLObjectAllValuesFrom valueOf = (OWLObjectAllValuesFrom) g2
							.getSuperClass();

					// TODO make more readable
					if ("hasDeviceType".equalsIgnoreCase(valueOf
							.getProperty().asOWLObjectProperty().getIRI()
							.getShortForm())) {
						continue;
					}
                    if ("hasGuidelineType".equalsIgnoreCase(valueOf
                            .getProperty().asOWLObjectProperty().getIRI()
                            .getShortForm())) {
                        continue;
                    }

					return transform(valueOf.getFiller().asOWLClass().getIRI().getShortForm());
				}
			}
		}
		return null;
	}
	
	private UsabilityGuideline transform(String ontologyElement) {
		switch (ontologyElement) {
			case "UIPage":
				return new UIPage();
			case "Link":
				return new Link();
			case "Paragraph":
				return new Paragraph();
			case "Form":
				return new Form();
			case "Graphic":
				return new Graphic();
			case "Nav":
				return new Navigation();
			case "MultimediaContent":
				return new Multimedia();
			case "Button":
				return new Button();
			case "NumberedList":
				return new NumberedList();
			case "Area":
				return new Area();
			case "FormElementLabel":
				return new FormElementLabel();
			case "Input":
				return new Input();
			case "Radio":
				return new Radio();
			case "CheckBox":
				return new CheckBox();
			case "Textarea":
				return new TextArea();
			case "Text":
				return new Text();
			case "Select":
				return new Select();
			case "Password":
				return new Password();
			case "File":
				return new File();
			case "Frame":
				return new Frame();
			case "Embed":
				return new Embed();
			case "Applet":
				return new Applet();
			case "Object":
				return new Object();
			case "Header":
				return new TableHeader();
			default:
				throw new RuntimeException("Cannot find the class for " + ontologyElement);
		}
	}

}
