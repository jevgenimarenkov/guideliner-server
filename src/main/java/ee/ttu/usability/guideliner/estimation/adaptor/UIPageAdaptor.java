package ee.ttu.usability.guideliner.estimation.adaptor;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ee.ttu.usability.guideliner.domain.attribute.*;
import ee.ttu.usability.guideliner.domain.dataproperty.Unit;
import ee.ttu.usability.guideliner.domain.page.UIPage;
import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.estimation.result.FailedElement;
import ee.ttu.usability.guideliner.estimation.result.ResultType;
import ee.ttu.usability.guideliner.util.HtmlValidator;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;

import static ee.ttu.usability.guideliner.service.impl.OntologyEvaluatorService.DEFAULT_HEIGHT;
import static ee.ttu.usability.guideliner.service.impl.OntologyEvaluatorService.DEFAULT_WIDTH;

@Slf4j
public class UIPageAdaptor extends AbstractAdaptor {

	public EvaluationResult execute(UIPage page) throws IOException {
		LocalDateTime startTime2 = LocalDateTime.now();
        screenshot = screenshoter.makeScreenshot(driver);
		if (page.getContentLength() != null) {
			return evaluateContentLength(page);
		}
		if (page.getHorizontalScroll() != null) {
			return evaluateHorizontalScroll(page);
		}
		if (page.getVerticalScroll() != null) {
			return evaluateVerticalScrolling(page);
		}
		if (page.getHeight() != null) {
			return evaluateHeight(page);
		}
		if (page.getLayout() != null) {
			return evaluateLayout(page);
		}
		if (page.getLoadTime() != null) {
			return evaluateLoadTime(page);
		}
		if (page.getProhibitedWords() != null) {
			return evaluateProhibitedWords(page);
		}
		if (page.getText() != null) {
			return evaluateText(page);
		}
		LocalDateTime startTime = LocalDateTime.now();
		if (page.getHtml() != null) {
			EvaluationResult res =  evaluateHtml(page);
			System.out.println("Took1 " + startTime.until(LocalDateTime.now(), ChronoUnit.SECONDS));
			System.out.println("Took3 " + startTime2.until(LocalDateTime.now(), ChronoUnit.SECONDS));
			return res;
		}
		if (page.getHref() != null) {
			return evaluateHref(page);
		}
		if (page.getTitle() != null) {
			return evaluateTitle(page);
		}
		if (page.getScroll() != null && page.getScroll().getIsOneDirectional() != null) {
			return evaluateScroll(page);
		}
		if (page.getMaxNumberOfInputs() != null) {
			return evaluateMaximumNumberOfInputs(page);
		}
		if (page.getOnMouseOver() != null && page.getOnFocus() != null) {
			return checkThatAttributesAreUsedTogether("onmouseover", "onfocus");
		}
		if (page.getOnMouseOut() != null && page.getOnblur() != null) {
			return checkThatAttributesAreUsedTogether("onmouseout", "onblur");
		}
		if (page.getOnMouseDown() != null && page.getOnKeyDown() != null) {
			return checkThatAttributesAreUsedTogether("onmousedown", "onkeydown");
		}
		if (page.getOnMouseDown() != null && page.getOnKeyDown() != null) {
			return checkThatAttributesAreUsedTogether("onmousedown", "onkeydown");
		}
		if (page.getOnKeyPress() != null && page.getOnClick() != null) {
			return checkThatAttributesAreUsedTogether("onkeypress", "onclick");
		}
		if (page.getOnKey() != null && page.getOnDbClick() != null) {
			return checkThatAttributesAreUsedTogether("onkey", "ondbclick");
		}


		return null;
	}


	private EvaluationResult checkThatAttributesAreUsedTogether(String attribute1, String attribute2) {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);
		result.setResult(ResultType.SUCCESS);

		performeEvaluation(result, attribute1, attribute2);
		performeEvaluation(result, attribute2, attribute1);

		return setSuccessFlag(result);
	}

	private void performeEvaluation(EvaluationResult result, String attribute1, String attribute2) {
		driver.findElements(By.xpath("//*[@"+attribute1+"]")).forEach(t -> {
			if (!t.getAttribute(attribute1).equalsIgnoreCase(t.getAttribute(attribute2))) {
				result.getFailedElements().add(prepareFailedElement(attribute1, t.getAttribute("outerHTML"), attribute1 + "should always be used with " + attribute2, NO_IMAGE));
			}
		});
	}


	public List<WebElement> getBoldText(WebDriver driver) {
		List<WebElement> bolds = driver.findElements(By.tagName("b"));
		List<WebElement> strongs = driver.findElements(By.tagName("strong"));
		bolds.addAll(strongs);
		return bolds;
	}
	
	private EvaluationResult evaluateLoadTime(UIPage page) {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);
		result.setResult(ResultType.SUCCESS);
		
		long start = System.currentTimeMillis();
	
		driver.get(page.getUrl());
	
		WebElement ele = driver.findElement(By.tagName("body"));
		long finish = System.currentTimeMillis();
		long totalTime = finish - start; 
		System.out.println("Total Time for page load - "+totalTime); 
		 
		if (totalTime > page.getLoadTime().getContentLength()) {
			 result.setResult(ResultType.FAIL);
			 result.setDescription("Load time exceeded the expected. Load time : " + totalTime);
		}
		return setSuccessFlag(result);
	}

	public EvaluationResult evaluateContentLength(UIPage page) {
		log.debug("Evaluation evaluateContentLength for UIPage");
		EvaluationResult result = new EvaluationResult();
		List<WebElement> findElements = driver.findElements(By.tagName("body"));
		for (WebElement el : findElements) {
			Integer amountOfUnits = getAmountOfUnit(el.getText(), page.getUnit());			
			 if (amountOfUnits > page.getContentLength()) {
				 String description = "Amount of " + page.getUnit() + " was " + amountOfUnits;
				 result.getFailedElements().add(prepareFailedElement("UI Page", "Home page", description, NO_IMAGE));
					
				 result.setElementType(ElementType.PAGE);
				 result.setResult(ResultType.FAIL);
				 result.setDescription(description);
			 }
		}
		return setSuccessFlag(result);
	}


	private EvaluationResult evaluateScroll(UIPage page) {
		System.out.println("evaluateScroll TODO Remove");
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("scroll(10000, 10000);");

		Long scrollY = (Long) executor.executeScript("return window.scrollY;");

		Long scrollX = (Long) executor.executeScript("return window.scrollX;");

		if (!scrollY.equals(new Long(0)) && !scrollX.equals(new Long(0))) {
			String description = "Both vertical and horizontal scroll exist on the page. Only one should exist.";
			result.getFailedElements().add(prepareFailedElement("UI Page", "Web Page", description, NO_IMAGE));
			result.setElementType(ElementType.PAGE);
			result.setResult(ResultType.FAIL);
			result.setDescription(description);
		}

		return setSuccessFlag(result);
	}


	private EvaluationResult evaluateHorizontalScroll(UIPage page) {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("scroll(0, 10000);");
		
		Long value = (Long) executor.executeScript("return window.scrollY;");

		if (value > page.getHorizontalScroll().getValue()) {
			 result.setElementType(ElementType.PAGE);
			 result.setResult(ResultType.FAIL);
			 result.setDescription("Horizontal scrol value is bigger then defined. Real value is : " + value);
		}
		return setSuccessFlag(result);
	}
	

	private EvaluationResult evaluateHeight(UIPage page) throws IOException {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);

		var screenshot = screenshoter.makeScreenshot(driver).get();
		
		if (screenshot.getHeight() > page.getHeight().getContentLength()) {
			FailedElement failed = new FailedElement();
			failed.setType(ElementType.PAGE.name());
			failed.setText("Page");
			failed.setDescription("Page horizontal length value is bigger then defined. Expected value is " + page.getHeight().getContentLength() + 
					 "Actual value is : " + screenshot.getHeight());		
			failed.setPathToElement(NO_IMAGE);
			result.getFailedElements().add(failed);
		}
		
		if (result.getFailedElements().size() == 0)
			result.setResult(ResultType.SUCCESS);
		else 
			result.setResult(ResultType.FAIL);
		return setSuccessFlag(result);
	}

	private EvaluationResult evaluateVerticalScrolling(UIPage page) {
		System.out.println("vertical scrolling");
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("scroll(10000, 0);");
		
		Long value = (Long) executor.executeScript("return window.scrollX;");

		if (value > page.getVerticalScroll().getValue()) {
			FailedElement failed = new FailedElement();
			failed.setType(ElementType.PAGE.name());
			failed.setText("Page");
			failed.setDescription("Horizontal scrol value is bigger then defined. Real value is : " + value);		
			failed.setPathToElement(NO_IMAGE);
			result.getFailedElements().add(failed);
		}
		
		if (result.getFailedElements().size() == 0)
			result.setResult(ResultType.SUCCESS);
		else 
			result.setResult(ResultType.FAIL);
		return setSuccessFlag(result);
	}

	private EvaluationResult evaluateLayout(UIPage page) {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);
		
		driver.manage().window().setSize(new Dimension(1100, 768));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("scroll(1000, 0);");
		Long value = (Long) executor.executeScript("return window.scrollX;");
		System.out.println(value);
		if (value != 0) {
			FailedElement failed = new FailedElement();
			failed.setType(ElementType.PAGE.name());
			failed.setText("Page");
			failed.setDescription("Layout is not compatible with changing the size of brawser.");		
			failed.setPathToElement(NO_IMAGE);
			result.getFailedElements().add(failed);
		}
		
		if (result.getFailedElements().size() == 0)
			result.setResult(ResultType.SUCCESS);
		else 
			result.setResult(ResultType.FAIL);

		driver.manage().window().setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
		return result;
	}
	
	private EvaluationResult evaluateProhibitedWords(UIPage page) {
		log.debug("Evaluation evaluateProhibitedWords for UIPage");
		EvaluationResult result = new EvaluationResult();
		List<WebElement> findElements = driver.findElements(By.tagName("body"));
		for (WebElement el : findElements) {
			String entireText = el.getText();
			for (String element : page.getProhibitedWords().getValue().split(",")) {
				if (entireText.contains(element)) {
					 result.getFailedElements().add(prepareFailedElement("UI Page", "Whole page", "The word " + element + "is not allowed" , NO_IMAGE));
					 result.setElementType(ElementType.PAGE);
				}
			}
		}
		return setSuccessFlag(result);
	}
	
	private EvaluationResult evaluateText(UIPage page) throws IOException {
		log.debug("Evaluating evaluateText");
		var screenshot = screenshoter.makeScreenshot(driver).get();
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);
		result.setResult(ResultType.SUCCESS);
		
		if (page.getText().getCaseType() != null) {
			List<WebElement> texts = getBoldText(driver);
			for(WebElement ele : texts)
			{
				if (StringUtils.isEmpty(ele.getText())) {
					continue;
				}
				if (ele.getText().length() > page.getText().getContentLength()) {
					 File file = screenshoter.takeScreenshot(screenshot, ele, driver);
					 String description = "Amount of Bold text was " + ele.getText().length();
					 result.getFailedElements().add(prepareFailedElement("UI Page", "UI Page", description, file));
				}
				

			}
			return setSuccessFlag(result);
		}
		
		if (page.getText().getUnit() == Unit.SPACE) {
			List<WebElement> texts = driver.findElements(By.tagName("body"));
			texts.forEach(c -> {
				String text = c.getText();
				if (StringUtils.length(text) < 100) {
					return;
				}

				String space = "";
				for (int i = 0; i < page.getText().getContentLength(); i++) {
					space += " ";
				}
				Pattern compile = Pattern.compile(space + "+");
				Matcher matcher = compile.matcher(text);				
				while (matcher.find()) {
					int start = matcher.start();
					int finish = matcher.end();
					if (matcher.start() - 15 > 0) {
						start = matcher.start() - 15;
					}
					if (matcher.end() + 15 < text.length()) {
						finish = matcher.end() + 15;
					}
					String textWithMultipleSpaces = text.substring(start, finish);
					result.getFailedElements().add(prepareFailedElement("UI Page text", textWithMultipleSpaces, "Text contains multiple spaces" , NO_IMAGE));
				}
			});
			return setSuccessFlag(result);
		}
		
		throw new IllegalArgumentException();
	}

	private EvaluationResult evaluateHtml(UIPage page) {
		if (page.getHtml().getLang() != null) {
			return evaluateLang(page.getHtml().getLang());
		}
		if (page.getHtml().getAlternativeText() != null && page.getHtml().getAlternativeText().getIsValued() != null &&
				page.getHtml().getAlternativeText().getIsValued() == true) {
			return evaluateAtlernativeText(page.getHtml().getAlternativeText());
		}
		if (page.getHtml().getAlternativeText() != null && page.getHtml().getAlternativeText().getIsUnique() != null) {
			return evaluateAtlernativeTextIsUnique(page.getHtml().getAlternativeText());
		}
		if (page.getHtml().getViewport() != null) {
			return evaluateViewport(page.getHtml().getViewport());
		}

		if (page.getHtml().getFlash() != null) {
			return evaluateFlash(page.getHtml().getFlash());
		}

		if (page.getHtml().getBolt() != null) {
			return evaluateBolt(page.getHtml().getBolt());
		}

		if (page.getHtml().getItalics() != null) {
			return evaluateItalics(page.getHtml().getItalics());
		}

		if (page.getHtml().getFont() != null) {
			return evaluateFont(page.getHtml().getFont());
		}

		if (page.getHtml().getBaseFont() != null) {
			return evaluateBaseFont(page.getHtml().getBaseFont());
		}

		if (page.getHtml().getH1() != null) {
			return evaluateTagAndItsFollowingTags("h1", page.getHtml().getH1().getFollowedByElements());
		}

		if (page.getHtml().getH2() != null) {
			return evaluateTagAndItsFollowingTags("h2", page.getHtml().getH2().getFollowedByElements());
		}

		if (page.getHtml().getH3() != null) {
			return evaluateTagAndItsFollowingTags("h3", page.getHtml().getH3().getFollowedByElements());
		}

		if (page.getHtml().getH4() != null) {
			return evaluateTagAndItsFollowingTags("h4", page.getHtml().getH4().getFollowedByElements());
		}

		if (page.getHtml().getH5() != null) {
			return evaluateTagAndItsFollowingTags("h5", page.getHtml().getH5().getFollowedByElements());
		}

		if (page.getHtml().getBlink() != null) {
			return evaluateBlink(page.getHtml().getBlink());
		}

		if (page.getHtml().getMarquee() != null) {
			return evaluateMarquee(page.getHtml().getMarquee());
		}

		if (page.getHtml().getId() != null) {
			return evaluateId(page.getHtml().getId());
		}

		if (page.getHtml().getP() != null) {
			return evaluateP(page.getHtml().getP());
		}

		if (page.getHtml().getTd() != null) {
			return evaluateTd(page.getHtml().getTd());
		}

		if (page.getHtml().getDiv() != null) {
			return evaluateDiv(page.getHtml().getDiv());
		}


		HtmlValidator validator = new HtmlValidator();
		return validator.test(driver.getPageSource());
	}

	private EvaluationResult evaluateDiv(Div div) {
		if (div.getContentLength() != null) {
			return evaluateTest("div", div.getContentLength());
		}
		return null;
	}

	private EvaluationResult evaluateP(P div) {
		if (div.getContentLength() != null) {
			return evaluateTest("p", div.getContentLength());
		}
		return null;
	}

	private EvaluationResult evaluateTd(Td div) {
		if (div.getContentLength() != null) {
			return evaluateTest("td", div.getContentLength());
		}
		return null;
	}

	private EvaluationResult evaluateTest(String tag, Integer allowedSize) {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);
		result.setResult(ResultType.SUCCESS);

		driver.findElements(By.tagName(tag)).forEach(el -> {
			if (el.getText().length() > allowedSize) {
				result.getFailedElements().add(prepareFailedElement(tag, el.getAttribute("outerHTML"), tag + "length should be longer then"  + allowedSize, NO_IMAGE));
			}
		});

		return setSuccessFlag(result);
	}

	private EvaluationResult evaluateId(Id id) {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);
		result.setResult(ResultType.SUCCESS);

		if (id.getIsUnique() != null && id.getIsUnique() == true) {
			List<String> exiustingIds = new ArrayList<>();
			driver.findElements(By.xpath("//*[@id]")).forEach(t -> {
				String attrId = t.getAttribute("id");
				if (exiustingIds.contains(attrId)) {
					result.getFailedElements().add(prepareFailedElement("id", t.getAttribute("outerHTML"), "Id should be unique", NO_IMAGE));
				} else {
					exiustingIds.add(attrId);
				}

			});
		}

		return setSuccessFlag(result);
	}

	private EvaluationResult evaluateItalics(Italics italics) {
		if (!italics.getIsValued()) {
			return  evaluateTagDoesNotExist("i", "Italics tag", "Italics tag <i> is not allowed");
		}
		return null;
	}

	private EvaluationResult evaluateBolt(Bolt bolt) {
		if (!bolt.getIsValued()) {
			return  evaluateTagDoesNotExist("b", "Bolt tag", "Bolt tag <b> is not allowed");
		}
		return null;
	}

	private EvaluationResult evaluateBaseFont(BaseFont baseFont) {
		if (!baseFont.getIsValued()) {
			return  evaluateTagDoesNotExist("basefont", "Basefont tag", "Basefont tag <basefont> is not allowed");
		}
		return null;
	}

	private EvaluationResult evaluateFont(Font font) {
		if (!font.getIsValued()) {
			return  evaluateTagDoesNotExist("font", "Font tag", "Font tag <font> is not allowed");
		}
		return null;
	}

	private EvaluationResult evaluateBlink(Blink blink) {
		if (blink.getIsValued() != null && !blink.getIsValued()) {
			return  evaluateTagDoesNotExist("blink", "Blink tag", "Blink tag <blink> is not allowed");
		}
		return EvaluationResult.EMPTY_RESULT;
	}

	private EvaluationResult evaluateMarquee(Marquee marquee) {
		if (marquee.getIsValued() != null && !marquee.getIsValued()) {
			return  evaluateTagDoesNotExist("marquee", "Marquee tag", "Marquee tag <marquee> is not allowed");
		}
		return EvaluationResult.EMPTY_RESULT;
	}

	private EvaluationResult evaluateTagAndItsFollowingTags(String firstTag, List<String> nextTags) {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);
		result.setResult(ResultType.SUCCESS);

		boolean shouldCheckFollowing = false;
		for (WebElement element : driver.findElements(By.xpath("//*[contains(local-name(), 'h')]"))) {
			if (!StringUtils.containsAny(element.getTagName(), "h1", "h2", "h3", "h4", "h5", "h6", "h7")) {
				continue;
			}
			System.out.println(element.getTagName());
			if (element.getTagName().equalsIgnoreCase(firstTag)) {
				shouldCheckFollowing = true;
				continue;
			}
			if (shouldCheckFollowing == true) {
				if (!nextTags.contains(element.getTagName().toLowerCase())) {
					result.getFailedElements().add(prepareFailedElement(firstTag, element.getAttribute("outerHTML"), firstTag + " cannot be followed by " + element.getTagName(), NO_IMAGE));
				}
 			}
			shouldCheckFollowing = false;
		}

		return setSuccessFlag(result);
	}

	private EvaluationResult evaluateTagDoesNotExist(String tag, String elementName, String errorDescription) {
		LocalDateTime startTime = LocalDateTime.now();
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);
		result.setResult(ResultType.SUCCESS);
		driver.findElements(By.tagName(tag)).forEach(t -> {
			//File file = screenshoter.takeScreenshot(screenshot, t, driver);
			result.getFailedElements().add(prepareFailedElement(tag, t.getText(), errorDescription, NO_IMAGE));
			});
		System.out.println("Took " + startTime.until(LocalDateTime.now(), ChronoUnit.SECONDS));
		return setSuccessFlag(result);
	}

	private EvaluationResult evaluateAtlernativeText(AlternativeText alternativeText) {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);
				
		if (alternativeText.getProhibitedWords() != null) {
			List<WebElement> imgs = driver.findElements(By.tagName("img"));
			imgs.addAll(driver.findElements(By.xpath("//input[@type='image']")));
			List<String> prohibitedWords = Arrays.asList(alternativeText.getProhibitedWords().getValue().split(","));
			imgs.forEach(e -> {
				String alt = e.getAttribute("alt");
				if (StringUtils.isNotBlank(alt) && prohibitedWords.contains(alt.trim())) {
					 File file = screenshoter.takeScreenshot(screenshot.get(), e, driver);
					 result.getFailedElements().add(prepareFailedElement("UI Page", "Elements with alt attribute", "The word " + alt.trim() + " for alternative text is not allowed" , file));
				}
			});
		}
		return setSuccessFlag(result);
	}

	private EvaluationResult evaluateAtlernativeTextIsUnique(AlternativeText alternativeText) {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);

		if (alternativeText.getIsUnique() == true) {
			List<WebElement> imgs = driver.findElements(By.tagName("img"));
			imgs.addAll(driver.findElements(By.xpath("//input[@type='image']")));
			List<String> exiustingIds = new ArrayList<>();
			imgs.forEach(t -> {
				String altText = t.getAttribute("alt");
				if (exiustingIds.contains(altText)) {
					result.getFailedElements().add(prepareFailedElement("Alternative text",
							t.getAttribute("outerHTML"), "Alternative text should be unique", NO_IMAGE));
				} else {
					exiustingIds.add(altText);
				}
			});
		}
		return setSuccessFlag(result);
	}

	private EvaluationResult evaluateLang(Lang lang) {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);
		result.setResult(ResultType.SUCCESS);

		if (lang.getIsValued()) {
			List<WebElement> findElements = driver.findElements(By.tagName("html"));

			if (findElements.size() == 0) {
				result.getFailedElements()
						.add(prepareFailedElement("Html tag", "", "Html tag does not exist.", NO_IMAGE));
				return setSuccessFlag(result);
			}

			Optional<WebElement> langElement = findElements.stream()
					.filter(el -> StringUtils.isNotBlank(el.getAttribute("lang"))).findFirst();

			if (!langElement.isPresent()) {
				result.getFailedElements()
						.add(prepareFailedElement("Lang attribute of HTML tag", "", "Lang is not defined", NO_IMAGE));
			}
			return setSuccessFlag(result);

		}

		return null;
	}

	private EvaluationResult evaluateHref(UIPage page) {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);
		result.setResult(ResultType.SUCCESS);

		List<WebElement> list=driver.findElements(By.tagName("a"));

		for (WebElement e : list) {
			String link = e.getAttribute("href");
			if (null == link)
				link = e.getAttribute("src");
			if (driver.getCurrentUrl().equals(link.equals(page.getHref().getValue()))) {
				result.getFailedElements().add(prepareFailedElement("UI Page", "",
						"Page contains link to itself.", NO_IMAGE));
			}
		}
		return setSuccessFlag(result);
	}

	private EvaluationResult evaluateViewport(Viewport viewport) {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);
		result.setResult(ResultType.SUCCESS);
		if (viewport.getIsValued()) {
			try {
				WebElement viewportElement = driver.findElement(By.xpath("//meta[@name='viewport']"));
				if (StringUtils.isNotEmpty(viewportElement.getText())) {
					result.getFailedElements()
							.add(prepareFailedElement(ElementType.PAGE.name(), "", "Viewport is empty.", NO_IMAGE));
				}
			} catch (NoSuchElementException ex) {
				result.getFailedElements()
						.add(prepareFailedElement(ElementType.PAGE.name(), "", "Viewport is not defined.", NO_IMAGE));
			}
		}
		return setSuccessFlag(result);
	}

	private EvaluationResult evaluateFlash(Flash flash) {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);
		result.setResult(ResultType.SUCCESS);

		if (driver.getPageSource().contains("embedSWF")) {
			result.getFailedElements()
					.add(prepareFailedElement(ElementType.PAGE.name(), "", "Flash is not allowed for mobile device..", NO_IMAGE));
		}

		return setSuccessFlag(result);
	}

	private EvaluationResult evaluateTitle(UIPage page) {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);
		result.setResult(ResultType.SUCCESS);
		
		List<WebElement> findElements = driver.findElements(By.tagName("title"));
		
		if (findElements.size() == 0) {
			result.getFailedElements().add(prepareFailedElement("Title tag", "", "Title tag does not exist.", NO_IMAGE));
			return setSuccessFlag(result);
		}
		
		Optional<WebElement> definedText = findElements
			.stream()
			.filter(el -> StringUtils.isNotBlank(el.getAttribute("innerHTML")))
			.findFirst();
		
		if (!definedText.isPresent()) {
			result.getFailedElements().add(prepareFailedElement("Title tag", "", "Title tag does not have value.", NO_IMAGE));
			return setSuccessFlag(result);
		}
		
		return setSuccessFlag(result);
	}

	private EvaluationResult evaluateMaximumNumberOfInputs(UIPage page) {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);
		result.setResult(ResultType.SUCCESS);

		List<WebElement> input = getInputs(driver);
		if (input.size() > page.getMaxNumberOfInputs()) {
			result.getFailedElements().add(prepareFailedElement("UI Page", "", "The expected amount of inputs exceeded. Actual number: " + input.size() + " Expected number:" + page.getMaxNumberOfInputs(), NO_IMAGE));
		}

		return setSuccessFlag(result);
	}

	public List<WebElement> getInputs(WebDriver driver) {
		List<WebElement> elements = new ArrayList<>();
		elements.addAll(driver.findElements(By.xpath("//input[@type='text']")));
		return elements;
	}



}
