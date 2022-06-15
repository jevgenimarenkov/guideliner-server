package ee.ttu.usability.guideliner.service.impl;

import java.util.Arrays;
import java.util.Optional;

import ee.ttu.usability.guideliner.domain.attribute.*;
import ee.ttu.usability.guideliner.domain.dataproperty.DistanceType;
import ee.ttu.usability.guideliner.domain.dataproperty.UnitAction;
import ee.ttu.usability.guideliner.domain.element.link.Object;
import ee.ttu.usability.guideliner.repository.OntologyRepository;
import ee.ttu.usability.guideliner.domain.dataproperty.Unit;
import ee.ttu.usability.guideliner.domain.element.form.*;
import ee.ttu.usability.guideliner.domain.element.link.*;
import ee.ttu.usability.guideliner.domain.element.navigation.ID;
import ee.ttu.usability.guideliner.domain.element.navigation.Navigation;
import ee.ttu.usability.guideliner.domain.element.navigation.ProhibitedWords;
import ee.ttu.usability.guideliner.domain.page.Layout;
import ee.ttu.usability.guideliner.domain.page.UIPage;
import ee.ttu.usability.guideliner.domain.pageattributes.Height;
import ee.ttu.usability.guideliner.domain.pageattributes.HorizontalScroll;
import ee.ttu.usability.guideliner.domain.pageattributes.Scroll;
import ee.ttu.usability.guideliner.domain.pageattributes.VerticalScroll;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLIndividualAxiom;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.ttu.usability.guideliner.domain.element.UsabilityGuideline;
import ee.ttu.usability.guideliner.domain.page.LayoutType;
import ee.ttu.usability.guideliner.domain.page.LoadTime;
import ee.ttu.usability.guideliner.domain.page.Text;
import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;
import uk.ac.manchester.cs.owl.owlapi.OWLDataPropertyAssertionAxiomImpl;
import uk.ac.manchester.cs.owl.owlapi.OWLNamedIndividualImpl;
import uk.ac.manchester.cs.owl.owlapi.OWLObjectPropertyAssertionAxiomImpl;
import ee.ttu.usability.guideliner.domain.dataproperty.Case;

@Service
public class GuildelineBuilderService {
	
	private OntologyRepository ontologyRepository;
	
	@Autowired
	public GuildelineBuilderService(OntologyRepository ontologyRepository) {
		this.ontologyRepository = ontologyRepository;
	}
	
	// TODO somehow combine fillGuideline and transformToObject together
	@SuppressWarnings("static-access")
	public void fillGuideline(NodeSet<OWLNamedIndividual> instances, UsabilityGuideline guidelineElement) {
		 instances.forEach(f -> {
			 f.forEach(individual -> {
				 ontologyRepository.ontology.axioms(individual).forEach(axiom -> {
					 if (axiom instanceof OWLDataPropertyAssertionAxiomImpl) {
						 OWLDataPropertyAssertionAxiomImpl dataProperty = (OWLDataPropertyAssertionAxiomImpl) axiom;
						 printOwlDataProperty(dataProperty);
					 }
					 if (axiom instanceof OWLObjectPropertyAssertionAxiomImpl) {
						 OWLObjectPropertyAssertionAxiomImpl objectProperty = (OWLObjectPropertyAssertionAxiomImpl) axiom;				 
					     transformToObject(((OWLNamedIndividualImpl) objectProperty.getObject()), guidelineElement, null);
					 }
				 });
			 });
		 });
	}

	public void transformToObject(OWLNamedIndividual individual, UsabilityGuideline element, AbstractAttribute attribute) {
		ontologyRepository.ontology.axioms(individual).forEach(axiom -> {
			 this.fillWithProperties(axiom, element, attribute);
		 });
	}
	
	private void printOwlDataProperty(OWLDataPropertyAssertionAxiomImpl dataProperty) {
		 System.out.println(dataProperty.getProperty().asOWLDataProperty().getIRI());
		 System.out.println(dataProperty.getObject().getDatatype());
		 System.out.println(dataProperty.getObject().getLiteral());
	}
	
	public void fillWithProperties(OWLIndividualAxiom axiom, UsabilityGuideline element, AbstractAttribute attribute) {
		 if (axiom instanceof OWLDataPropertyAssertionAxiomImpl) {
			 OWLDataPropertyAssertionAxiomImpl dataProperty = (OWLDataPropertyAssertionAxiomImpl) axiom;
			 this.fillWithDataProperty(element, dataProperty, attribute);
		 }
		 if (axiom instanceof OWLObjectPropertyAssertionAxiomImpl) {
			 OWLObjectPropertyAssertionAxiomImpl objectProperty = (OWLObjectPropertyAssertionAxiomImpl) axiom;
			 this.fillWithObjectProperty(element, objectProperty, attribute);
		 }
	}
	
	public void fillWithObjectProperty(UsabilityGuideline element, OWLObjectPropertyAssertionAxiomImpl objectProperty, AbstractAttribute attribute) {
		Optional<OWLClassExpression> ent = null;

		 if (attribute != null) {
			 ent = ontologyRepository.getEntityTypeOfIndividual(objectProperty.getSubject());
			 if ("hasUnit".equals(objectProperty.getProperty().asOWLObjectProperty().getIRI().getShortForm())) {
			 	 Unit unit = getUnit(((OWLNamedIndividualImpl) objectProperty.getObject()).getIRI().getShortForm());
				 if ("ProhibitedWords".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
				 	if (attribute instanceof AlternativeText) {
						if (((AlternativeText) attribute).getProhibitedWords() == null)
							((AlternativeText) attribute).setProhibitedWords(new ProhibitedWords());
						((AlternativeText) attribute).getProhibitedWords().setUnit(unit);
					}
				 }
			 } else if ("hasUnitAction".equals(objectProperty.getProperty().asOWLObjectProperty().getIRI().getShortForm())) {
				 UnitAction unitAction = getUnitAction(((OWLNamedIndividualImpl) objectProperty.getObject()).getIRI().getShortForm());
				 if ("ProhibitedWords".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					 if (attribute instanceof AlternativeText) {
						 if (((AlternativeText) attribute).getProhibitedWords() == null)
							 ((AlternativeText) attribute).setProhibitedWords(new ProhibitedWords());
						 ((AlternativeText) attribute).getProhibitedWords().setUnitAction(unitAction);
					 }
				 }
			 }
		 }
		 if ("hasUnit".equals(objectProperty.getProperty().asOWLObjectProperty().getIRI().getShortForm())) {
			 if ("Word".equals(((OWLNamedIndividualImpl) objectProperty.getObject()).getIRI().getShortForm())) {
				 element.setUnit(Unit.WORD);
				 printOwlObjectProperty(objectProperty);
			 } else if ("Line".equals(((OWLNamedIndividualImpl) objectProperty.getObject()).getIRI().getShortForm())) {
				 element.setUnit(Unit.LINE);
				 printOwlObjectProperty(objectProperty);
			 } else if ("KByte".equals(((OWLNamedIndividualImpl) objectProperty.getObject()).getIRI().getShortForm())) {
				 element.setUnit(Unit.KBYTE);
				 printOwlObjectProperty(objectProperty);
			 } else if ("WordInSentence".equals(((OWLNamedIndividualImpl) objectProperty.getObject()).getIRI().getShortForm())) {
				 element.setUnit(Unit.WORDS_IN_SENTENCE);
				 printOwlObjectProperty(objectProperty);
			 } else if ("Pixel".equals(((OWLNamedIndividualImpl) objectProperty.getObject()).getIRI().getShortForm())) {
				 ent = ontologyRepository.getEntityTypeOfIndividual(objectProperty.getSubject());
				 if ("Height".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					 if (element instanceof UIPage || element instanceof Link || element instanceof Button || element instanceof Input) {
							if (element.getHeight() == null)
								element.setHeight(new Height());
							element.getHeight().setUnit(Unit.PIXCEL);
					 }
				 } else if ("Width".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					 if (element instanceof Link || element instanceof Button || element instanceof Input) {
						 if (element.getWidth() == null)
							 element.setWidth(new Width());
						 element.getWidth().setUnit(Unit.PIXCEL);
					 }
				 } else if ("Distance".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					 if (element instanceof Link || element instanceof Button || element instanceof Input) {
						 if (element.getDistance() == null)
							 element.setDistance(new Distance());
						 element.getDistance().setUnit(Unit.PIXCEL);
					 }
				 }
			 } else if ("MiliSecond".equals(((OWLNamedIndividualImpl) objectProperty.getObject()).getIRI().getShortForm())) {
				 ent = ontologyRepository.getEntityTypeOfIndividual(objectProperty.getSubject());	 
				 if ("LoadTime".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					 if (element instanceof UIPage) {
							if (((UIPage) element).getLoadTime() == null)
								((UIPage) element).setLoadTime(new LoadTime());
							((UIPage) element).getLoadTime().setUnit(Unit.MILI_SECOND);
					 }
				 }
			 } else if ("Element".equals(((OWLNamedIndividualImpl) objectProperty.getObject()).getIRI().getShortForm())) {
				 element.setUnit(Unit.ELEMENT);
				 printOwlObjectProperty(objectProperty);
			 } else if ("Space".equals(((OWLNamedIndividualImpl) objectProperty.getObject()).getIRI().getShortForm())) {
				 ent = ontologyRepository.getEntityTypeOfIndividual(objectProperty.getSubject());	 
				 if ("Text".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					 if (element instanceof UIPage) {
							if (((UIPage) element).getText() == null)
								((UIPage) element).setText(new Text());
							((UIPage) element).getText().setUnit(Unit.SPACE);
					 }
				 }
			 } 
		 } 
		 
		 if ("hasLayoutType".equals(objectProperty.getProperty().asOWLObjectProperty().getIRI().getShortForm())) {
			 ent = ontologyRepository.getEntityTypeOfIndividual(objectProperty.getSubject());	 
			 if ("Layout".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					Layout layout = new Layout();
					layout.setLayoutType(LayoutType.convertToLayoutType(((OWLNamedIndividualImpl) objectProperty.getObject()).getIRI().getShortForm()));
					if (element instanceof UIPage) {
						((UIPage) element).setLayout(layout);
					} else if (element instanceof Radio) {
						((Radio) element).setLayout(layout);
					} else if (element instanceof CheckBox) {
						((CheckBox) element).setLayout(layout);
					} else if (element instanceof Input) {
						((Input) element).setLayout(layout);
					}
			 }
		 }

		if ("hasDistanceType".equals(objectProperty.getProperty().asOWLObjectProperty().getIRI().getShortForm())) {
			ent = ontologyRepository.getEntityTypeOfIndividual(objectProperty.getSubject());
			if ("Distance".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
				Distance distance = new Distance();
				distance.setDistanceType(DistanceType.convertToDistanceType(((OWLNamedIndividualImpl) objectProperty.getObject()).getIRI().getShortForm()));
				if (element instanceof Link || element instanceof Button || element instanceof Input) {
					element.setDistance(distance);
				}

			}
		}

		if ("hasCase".equals(objectProperty.getProperty().asOWLObjectProperty().getIRI().getShortForm())) {
			 if ("Bold".equals(((OWLNamedIndividualImpl) objectProperty.getObject()).getIRI().getShortForm())) {
				 ent = ontologyRepository.getEntityTypeOfIndividual(objectProperty.getSubject());	 
				 if ("Text".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					 if (element instanceof UIPage) {
							if (((UIPage) element).getText() == null)
								((UIPage) element).setText(new Text());
							((UIPage) element).getText().setCaseType(Case.BOLD);
					 }
				 }
			 }
		 }

		if ("hasPositionType".equals(objectProperty.getProperty().asOWLObjectProperty().getIRI().getShortForm())) {
			System.out.println(((OWLNamedIndividualImpl) objectProperty.getObject()).getIRI().getShortForm());
			System.out.println(ontologyRepository.getEntityTypeOfIndividual(objectProperty.getSubject()));
			if ("Above".equals(((OWLNamedIndividualImpl) objectProperty.getObject()).getIRI().getShortForm())) {
				if (element instanceof FormElementLabel) {
					((FormElementLabel) element).setPositionType(PositionType.ABOVE);
				}
			}
		}
		 
		 if ("hasAttribute".equals(objectProperty.getProperty().asOWLObjectProperty().getIRI().getShortForm())) {
		     transformToObject(((OWLNamedIndividualImpl) objectProperty.getObject()), element, null);
		 }


		 if ("hasTagAttribute".equals(objectProperty.getProperty().asOWLObjectProperty().getIRI().getShortForm())) {
			 ent = ontologyRepository.getEntityTypeOfIndividual(objectProperty.getSubject());	 
			 System.out.println(((OWLClassImpl) ent.get()).getIRI().getShortForm());
			 if ("Html".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
				 if (element instanceof UIPage) {
					 Html html = new Html();
					 ((UIPage) element).setHtml(html); 
				     transformToObject(((OWLNamedIndividualImpl) objectProperty.getObject()), element, html);
				 }
			 } else if ("AlternativeText".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
				 if (attribute != null) {
					 if (attribute instanceof Html) {
						 AlternativeText alText = new AlternativeText();
						 ((Html) attribute).setAlternativeText(alText);
					     transformToObject(((OWLNamedIndividualImpl) objectProperty.getObject()), element, alText);
					 }
				 } else {
				 	if (element instanceof Link) {
						AlternativeText alText = new AlternativeText();
						((Link) element).setAlternativeText(alText);
						transformToObject(((OWLNamedIndividualImpl) objectProperty.getObject()), element, alText);
					} else if (element instanceof Graphic) {
						AlternativeText alText = new AlternativeText();
						((Graphic) element).setAlternativeText(alText);
						transformToObject(((OWLNamedIndividualImpl) objectProperty.getObject()), element, alText);
					}
				 }
			 } else if ("Bold".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
				 if (attribute != null) {
					 if (attribute instanceof Html) {
						 AlternativeText alText = new AlternativeText();
						 ((Html) attribute).setAlternativeText(alText);
						 transformToObject(((OWLNamedIndividualImpl) objectProperty.getObject()), element, alText);
					 }
				 } else {
					 if (element instanceof Link) {
						 AlternativeText alText = new AlternativeText();
						 ((Link) element).setAlternativeText(alText);
						 transformToObject(((OWLNamedIndividualImpl) objectProperty.getObject()), element, alText);
					 } else if (element instanceof Graphic) {
						 AlternativeText alText = new AlternativeText();
						 ((Graphic) element).setAlternativeText(alText);
						 transformToObject(((OWLNamedIndividualImpl) objectProperty.getObject()), element, alText);
					 }
				 }
			 } else {
				 throw new IllegalArgumentException(((OWLClassImpl) ent.get()).getIRI().getShortForm());
			 }
		 }
	}

	private Unit getUnit(String unit) {
		switch (unit) {
			case "Text" :
				return Unit.TEXT;
			case "FileName" :
				return Unit.FILE_NAME;
			default : throw new IllegalArgumentException();
		}
	}

	private UnitAction getUnitAction(String unit) {
		switch (unit) {
			case "DoNotFollow" :
				return UnitAction.DO_NOT_FOLLOW;
			default : throw new IllegalArgumentException();
		}
	}

	public void fillWithDataProperty(UsabilityGuideline element, OWLDataPropertyAssertionAxiomImpl dataProperty, AbstractAttribute attribute) {
		Optional<OWLClassExpression> ent = ontologyRepository.getEntityTypeOfIndividual(dataProperty.getSubject());
		if (attribute != null) {
			switch (dataProperty.getProperty().asOWLDataProperty().getIRI().getShortForm()) {
				case "isValued":
					if ("Lang".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						Lang lang = new Lang();
						lang.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
						if (attribute instanceof Html) {
							((Html) attribute).setLang(lang);
						}
					} else if ("Viewport".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						Viewport viewport = new Viewport();
						viewport.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
						if (attribute instanceof Html) {
							((Html) attribute).setViewport(viewport);
						}
					} else if ("Flash".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						Flash flash = new Flash();
						flash.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
						if (attribute instanceof Html) {
							((Html) attribute).setFlash(flash);
						}
					} else if ("Viewport".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						Viewport viewport = new Viewport();
						viewport.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
						if (attribute instanceof Html) {
							((Html) attribute).setViewport(viewport);
						}
					} else if ("Bolt".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						Bolt bolt = new Bolt();
						bolt.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
						if (attribute instanceof Html) {
							((Html) attribute).setBolt(bolt);
						}
					} else if ("Font".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						Font font = new Font();
						font.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
						if (attribute instanceof Html) {
							((Html) attribute).setFont(font);
						}
					} else if ("Italics".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						Italics italics = new Italics();
						italics.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
						if (attribute instanceof Html) {
							((Html) attribute).setItalics(italics);
						}
					} else if ("Basefont".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						BaseFont baseFont = new BaseFont();
						baseFont.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
						if (attribute instanceof Html) {
							((Html) attribute).setBaseFont(baseFont);
						}
					} else if ("Marquee".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						Marquee amrquee = new Marquee();
						amrquee.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
						if (attribute instanceof Html) {
							((Html) attribute).setMarquee(amrquee);
						}
					} else if ("Blink".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						Blink blink = new Blink();
						blink.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
						if (attribute instanceof Html) {
							((Html) attribute).setBlink(blink);
						}
					}
					break;
				case "hasValue":
					if ("ProhibitedWords".equalsIgnoreCase(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						ProhibitedWords words = new ProhibitedWords();
						words.setValue(dataProperty.getObject().getLiteral());
						if (attribute instanceof AlternativeText) {
							((AlternativeText) attribute).setProhibitedWords(words);
						}
					}
				case "isFollowedBy":
					if ("H1".equalsIgnoreCase(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						H1 h1 = new H1();
						if (attribute instanceof Html) {
							h1.setFollowedByElements(Arrays.asList(dataProperty.getObject().getLiteral().split(",")));
							((Html) attribute).setH1(h1);
						}
					} else if ("H2".equalsIgnoreCase(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						H2 h1 = new H2();
						if (attribute instanceof Html) {
							h1.setFollowedByElements(Arrays.asList(dataProperty.getObject().getLiteral().split(",")));
							((Html) attribute).setH2(h1);
						}
					} else if ("H3".equalsIgnoreCase(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						H3 h1 = new H3();
						if (attribute instanceof Html) {
							h1.setFollowedByElements(Arrays.asList(dataProperty.getObject().getLiteral().split(",")));
							((Html) attribute).setH3(h1);
						}
					} else if ("H4".equalsIgnoreCase(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						H4 h1 = new H4();
						if (attribute instanceof Html) {
							h1.setFollowedByElements(Arrays.asList(dataProperty.getObject().getLiteral().split(",")));
							((Html) attribute).setH4(h1);
						}
					} else if ("H5".equalsIgnoreCase(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						H5 h1 = new H5();
						if (attribute instanceof Html) {
							h1.setFollowedByElements(Arrays.asList(dataProperty.getObject().getLiteral().split(",")));
							((Html) attribute).setH5(h1);
						}
					}
				case "isUnique" :
					if ("Id".equalsIgnoreCase(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						Id id = new Id();
						id.setIsUnique(Boolean.valueOf(dataProperty.getObject().getLiteral()));
						if (attribute instanceof Html) {
							((Html) attribute).setId(id);
						}
					} else if ("AlternativeText".equalsIgnoreCase(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						AlternativeText alt = new AlternativeText();
						alt.setIsUnique(Boolean.valueOf(dataProperty.getObject().getLiteral()));
						if (attribute instanceof Html) {
							((Html) attribute).setAlternativeText(alt);
						}
					}
				case "hasContentLength":
					if ("P".equalsIgnoreCase(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						P words = new P();
						words.setContentLength(new Integer(dataProperty.getObject().getLiteral()));
						if (attribute instanceof Html) {
							((Html) attribute).setP(words);
						}
					} else 	if ("Div".equalsIgnoreCase(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						Div words = new Div();
						words.setContentLength(new Integer(dataProperty.getObject().getLiteral()));
						if (attribute instanceof Html) {
							((Html) attribute).setDiv(words);
						}
					} else 	if ("Td".equalsIgnoreCase(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						Td words = new Td();
						words.setContentLength(new Integer(dataProperty.getObject().getLiteral()));
						if (attribute instanceof Html) {
							((Html) attribute).setTd(words);
						}
					}
			}
			return;
		}
		switch (dataProperty.getProperty().asOWLDataProperty().getIRI().getShortForm()) {
			case "hasMinNumberOfInput" :
				if ("CheckBox".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					((CheckBox) element).setMinNumberOfInputs(new Integer(dataProperty.getObject().getLiteral()));
				} else if ("Radio".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					((Radio) element).setMinNumberOfInputs(new Integer(dataProperty.getObject().getLiteral()));
				} else if ("Select".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					((Select) element).setMinNumberOfInputs(new Integer(dataProperty.getObject().getLiteral()));
				}
				break;
			case "hasContentLength" :
				 ent = ontologyRepository.getEntityTypeOfIndividual(dataProperty.getSubject());
				 System.out.println(((OWLClassImpl) ent.get()).getIRI().getShortForm());
				 if ("Height".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					if (element instanceof UIPage || element instanceof Link || element instanceof Button || element instanceof Input) {
						if (element.getHeight() == null)
							element.setHeight(new Height());
						element.getHeight().setContentLength(new Integer(dataProperty.getObject().getLiteral()));
					}
					
				 } else if ("LoadTime".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						if (((UIPage) element).getLoadTime() == null)
							((UIPage) element).setLoadTime(new LoadTime());
						((UIPage) element).getLoadTime().setTimeInSeconds(new Integer(dataProperty.getObject().getLiteral()));
				 } else if ("Text".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
						if (((UIPage) element).getText() == null)
							((UIPage) element).setText(new Text());
						((UIPage) element).getText().setContentLength(new Integer(dataProperty.getObject().getLiteral()));
				 } else if ("Width".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					 if (element instanceof Link || element instanceof Button || element instanceof Input) {
						 if (element.getWidth() == null)
							 element.setWidth(new Width());
						 element.getWidth().setContentLength(new Integer(dataProperty.getObject().getLiteral()));
					 }
				 } else if ("Distance".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					 if (element instanceof Link || element instanceof Button || element instanceof Input) {
						 if (element.getDistance() == null)
							 element.setDistance(new Distance());
						 element.getDistance().setContentLength(new Integer(dataProperty.getObject().getLiteral()));
					 }
				 } else if ("integer".equals(dataProperty.getObject().getDatatype().getIRI().getShortForm())) {
					 element.setContentLength(new Integer(dataProperty.getObject().getLiteral()));
				 }

				break;
			case "hasContrast" :
				Contrast contrast = new Contrast();
				contrast.setContrast(new Integer(dataProperty.getObject().getLiteral()));
				element.setContrast(contrast);
				break;		
			case "hasScroll" :
				System.out.println(((OWLClassImpl) ent.get()).getIRI().getShortForm());
				if ("HScroll".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					HorizontalScroll scroll = new HorizontalScroll();
					scroll.setValue(new Integer(dataProperty.getObject().getLiteral()));
					if (element instanceof UIPage) {
						((UIPage) element).setHorizontalScroll(scroll);
					} else if (element instanceof Navigation) {
						((Navigation) element).setHorizontalScroll(scroll);
					}
					
				}
				if ("VScroll".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					VerticalScroll scroll = new VerticalScroll();
					scroll.setValue(new Integer(dataProperty.getObject().getLiteral()));
					if (element instanceof UIPage) {
						((UIPage) element).setVerticalScroll(scroll);
					}
				}
				break;
			case "hasValue" :
				if ("Id".equalsIgnoreCase(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					ID id = new ID();
					id.setValue(dataProperty.getObject().getLiteral());
					if (element instanceof Navigation) {
						((Navigation) element).setId(id);
					}
				} else if ("ProhibitedWords".equalsIgnoreCase(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					ProhibitedWords words = new ProhibitedWords();
					words.setValue(dataProperty.getObject().getLiteral());
					if (element instanceof UIPage) {
						((UIPage) element).setProhibitedWords(words);
					}
				} else if ("Href".equalsIgnoreCase(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					Href href = new Href();
					href.setValue(dataProperty.getObject().getLiteral());
					if (element instanceof UIPage) {
						((UIPage) element).setHref(href);
					}
				}
				break;
			case "isValued" :
				if ("AlternativeText".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					AlternativeText text = new AlternativeText();
					text.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof Form) {
						((Form) element).setAlternativeText(text);
					} else if (element instanceof Multimedia) {
						((Multimedia) element).setAlternativeText(text);
					} else if (element instanceof Button) {
						((Button) element).setAlternativeText(text);
					} else if (element instanceof Area) {
						((Area) element).setAlternativeText(text);
					} else if (element instanceof Graphic) {
						((Graphic) element).setAlternativeText(text);
					} else if (element instanceof Object) {
						((Object) element).setAlternativeText(text);
					} else if (element instanceof Applet) {
						((Applet) element).setAlternativeText(text);
					} else if (element instanceof Embed) {
						((Embed) element).setAlternativeText(text);
					}
				}
				if ("Label".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					Label label = new Label();
					label.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof Form) {
						((Form) element).setLabel(label);
					}
					if (element instanceof AbstractForm) {
						((AbstractForm) element).setLabel(label);
					}
				}
				if ("OnKeyPress".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					OnKeyPress onKey = new OnKeyPress();
					onKey.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof Button) {
						((Button) element).setOnKeyPress(onKey);
					}
				}
				if ("OnClick".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					OnClick onClick = new OnClick();
					onClick.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof Button) {
						((Button) element).setOnClick(onClick);
					}
				}
				if ("Title".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					Title title = new Title();
					title.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof UIPage) {
						((UIPage) element).setTitle(title);
					} else if (element instanceof Frame) {
						((Frame) element).setTitle(title);
					}
				}
				if ("Lang".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					Lang title = new Lang();
					title.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					System.out.println("ddddddddddddddddddddddddddddddddddddddd");
					System.out.println(((OWLClassImpl) ent.get()).getIRI().getShortForm());
				}
				if ("OnFocus".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					OnFocus title = new OnFocus();
					title.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof UIPage) {
						((UIPage) element).setOnFocus(title);
					}
				}
				if ("OnMouseOver".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					OnMouseOver title = new OnMouseOver();
					title.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof UIPage) {
						((UIPage) element).setOnMouseOver(title);
					}
				}
				if ("Onblur".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					Onblur title = new Onblur();
					title.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof UIPage) {
						((UIPage) element).setOnblur(title);
					}
				}
				if ("OnKeyDown".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					OnKeyDown title = new OnKeyDown();
					title.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof UIPage) {
						((UIPage) element).setOnKeyDown(title);
					}
				}
				if ("OnMouseDown".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					OnMouseDown title = new OnMouseDown();
					title.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof UIPage) {
						((UIPage) element).setOnMouseDown(title);
					}
				}
				if ("OnMouseOut".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					OnMouseOut title = new OnMouseOut();
					title.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof UIPage) {
						((UIPage) element).setOnMouseOut(title);
					}
				}
				if ("OnMouseOver".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					OnMouseOver title = new OnMouseOver();
					title.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof UIPage) {
						((UIPage) element).setOnMouseOver(title);
					}
				}
				if ("OnKeyPress".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					OnKeyPress title = new OnKeyPress();
					title.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof UIPage) {
						((UIPage) element).setOnKeyPress(title);
					}
				}
				if ("OnClick".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					OnClick title = new OnClick();
					title.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof UIPage) {
						((UIPage) element).setOnClick(title);
					}
				}
				if ("OnDbClick".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					OnDbClick title = new OnDbClick();
					title.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof UIPage) {
						((UIPage) element).setOnDbClick(title);
					}
				}
				if ("OnKey".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					OnKey title = new OnKey();
					title.setIsValued(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof UIPage) {
						((UIPage) element).setOnKey(title);
					}
				}
				break;
			case "isValid" :
				if ("Html".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					Html html = new Html();
					html.setValid(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof UIPage) {
						((UIPage) element).setHtml(html);
					}
				}
				break;
			case "isOneDirectional" :
				if ("Scroll".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					Scroll scroll = new Scroll();
					scroll.setIsOneDirectional(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof UIPage) {
						((UIPage) element).setScroll(scroll);
					}
				}
				break;
			case "isSame" :
				if ("Color".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					Color color = new Color();
					color.setIsSame(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof Link || element instanceof Input || element instanceof Button) {
						element.setColor(color);
					}
				}
				break;
			case "isVisited" :
				if ("Link".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					if (element instanceof Link) {
						((Link) element).setIsVisited(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					}
				}
				break;
			case "isSelected" :
				if ("Input".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					if (element instanceof Input) {
						((Input) element).setIsSelected(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					}
				}
				break;
			case "hasMaxNumberOfInput" :
				if ("UIPage".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					if (element instanceof UIPage) {
						((UIPage) element).setMaxNumberOfInputs(new Integer(dataProperty.getObject().getLiteral()));
					}
				} else if ("CheckBox".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					((CheckBox) element).setMaxNumberOfInputs(new Integer(dataProperty.getObject().getLiteral()));
				} else if ("Radio".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					((Radio) element).setMaxNumberOfInputs(new Integer(dataProperty.getObject().getLiteral()));
				}
				break;
			case "hasText" :
				if ("Label".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					Label label = new Label();
					label.setHasText(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof AbstractForm) {
						((AbstractForm) element).setLabel(label);
					}
				} else if ("Title".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					Title title = new Title();
					title.setHasText(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof UIPage) {
						((UIPage) element).setTitle(title);
					}
				} else if ("Link".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					Link link = new Link();
					link.setHasText(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof Link) {
						((Link) element).setHasText(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					}
				} else if ("Header".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					TableHeader link = new TableHeader();
					link.setHasText(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					if (element instanceof TableHeader) {
						((TableHeader) element).setHasText(Boolean.valueOf(dataProperty.getObject().getLiteral()));
					}
				}
			case "isPrecededBy" :
				if ("Radio".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					((Radio) element).setPrecededElements(Arrays.asList(dataProperty.getObject().getLiteral().split(",")));
				} else if ("CheckBox".equals(((OWLClassImpl) ent.get()).getIRI().getShortForm())) {
					((CheckBox) element).setPrecededElements(Arrays.asList(dataProperty.getObject().getLiteral().split(",")));
				}
		}
	}

	public static void printOwlObjectProperty(OWLObjectPropertyAssertionAxiomImpl objectProperty) {
		 System.out.println(objectProperty.getProperty().asOWLObjectProperty().getIRI().getShortForm());
		 System.out.println(((OWLNamedIndividualImpl) objectProperty.getObject()).getIRI().getShortForm());
		 System.out.println(((OWLNamedIndividualImpl) objectProperty.getObject()));
	}

}
