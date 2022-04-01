package ee.ttu.usability.guideliner.estimation.adaptor;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

import ee.ttu.usability.guideliner.domain.attribute.AlternativeText;
import ee.ttu.usability.guideliner.domain.dataproperty.Unit;
import ee.ttu.usability.guideliner.domain.dataproperty.UnitAction;
import ee.ttu.usability.guideliner.estimation.result.ResultType;
import lombok.extern.slf4j.Slf4j;


import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;

import org.springframework.stereotype.Service;
import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.util.ContrastEstimator;
import ee.ttu.usability.guideliner.domain.element.link.Link;

@Slf4j
@Service("LinkAdaptor")
public class LinkAdaptor extends AbstractAdaptor {

	public EvaluationResult execute(Link link) throws IOException {
		if (link.getContrast() != null && link.getContrast().getContrast() != null) {
			return evaluateContrast(link);
		} else if (link.getContentLength() != null) {
			return evaluateContentLength(link);
		} else if (link.getAlternativeText() != null) {
			return evaluateAlternativeText(link.getAlternativeText());
		} else if (link.getWidth() != null && link.getWidth().getContentLength() != null) {
			return evaluateWidth(link);
		}  else if (link.getHeight() != null && link.getHeight().getContentLength() != null) {
			return evaluateHeight(link);
		}  else if (link.getDistance() != null && link.getDistance().getContentLength() != null && link.getDistance().getDistanceType() != null) {
			return evaluateDistance(link);
		} else if (link.getColor() != null && link.getColor().getIsSame() != null && link.getIsVisited() != null) {
			return evaluateVisitedColorScheme(link);
		} else if (link.getColor() != null && link.getColor().getIsSame() != null) {
			return evaluateSameColor(link);
		} else if (link.getHasText() != null && link.getHasText() == true) {
			return evaluateThatInpuHasText(link);
		}
		return null;
	}

	protected EvaluationResult evaluateThatInpuHasText(Link link) {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.PAGE);
		result.setResult(ResultType.SUCCESS);
		driver.findElements(By.tagName("a")).forEach(t -> {
				if (StringUtils.isBlank(t.getText())) {
					result.getFailedElements()
							.add(prepareFailedElement("Link", t.getAttribute("outerHTML"), "Link should have text", NO_IMAGE));
				}
		});
		return setSuccessFlag(result);
	}

	private EvaluationResult evaluateAlternativeText(AlternativeText alternativeText) throws IOException {
		screenshot = screenshoter.makeScreenshot(driver);

		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.LINK);

		List<WebElement> links = driver.findElements(By.tagName("a"));

		if (alternativeText.getProhibitedWords() != null && alternativeText.getProhibitedWords().getUnit() != null) {
			links.forEach(l -> {
				String prohibitedWord = null;
				Unit unit = alternativeText.getProhibitedWords().getUnit();
				UnitAction action = alternativeText.getProhibitedWords().getUnitAction();
				if (unit == Unit.TEXT) {
					prohibitedWord =  l.getAttribute("innerHTML");
					if (action.DO_NOT_FOLLOW == action && StringUtils.isNotEmpty(prohibitedWord) && prohibitedWord.equals(l.getAttribute("alt"))) {
						File file = screenshoter.takeScreenshot(screenshot.get(), l, driver);
						result.getFailedElements().add(prepareFailedElement("UI Page", "Elements with alt attribute", "The word " + prohibitedWord + "  for alternative text is not allowed as it duplicates the link text" , file));
					}
				}
			});
		}
		return setSuccessFlag(result);
	}

	public EvaluationResult evaluateContentLength(Link page) throws IOException {
		screenshot = screenshoter.makeScreenshot(driver);
		log.debug("Evaluation evaluateContentLength for Link");
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.LINK);
		result.setResult(ResultType.SUCCESS);
		List<WebElement> findElements = driver.findElements(By.tagName("a"));
		for (WebElement el : findElements) {
			Integer amountOfUnits = getAmountOfUnit(el.getText(), page.getUnit());			
			 if (amountOfUnits > page.getContentLength()) {
				 File file = screenshoter.takeScreenshot(screenshot.get(), el, driver);
				 result.getFailedElements().add(prepareFailedElement(
				 		ElementType.LINK.name(), el.getText(),"Amount of " + page.getUnit() + " was " + amountOfUnits , file));
				 result.setResult(ResultType.FAIL);
			 }
		}
		return setSuccessFlag(result);
	}
	
	private EvaluationResult evaluateContrast(Link link) throws IOException {
		screenshot = screenshoter.makeScreenshot(driver);
		ContrastEstimator estimator = new ContrastEstimator();
		List<WebElement> allLinks = getAllLinks(driver);
		return estimator.estimate(allLinks, driver, screenshot.get());
	}

	private EvaluationResult evaluateWidth(Link link) throws IOException {
		screenshot = screenshoter.makeScreenshot(driver);
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.LINK);

		List<WebElement> webLinks = getAllLinks(driver);
		for (WebElement webLink : webLinks) {
			Dimension dimension = webLink.getSize();
			// for somef reason some links are narrow
			if (dimension.getWidth() == 0) {
				continue;
			}

			if (link.getWidth().getContentLength() > dimension.getWidth()) {
				File file = screenshoter.takeScreenshot(screenshot.get(), webLink, driver);
				result.getFailedElements().add(prepareFailedElement(
						ElementType.LINK.name(), webLink.getText(),"The width of the link is smaller then expected. Expected minimum: "
								+ link.getWidth().getContentLength() + " actual: " + dimension.getWidth() , file));
			}
		}

		return setSuccessFlag(result);
	}

	private EvaluationResult evaluateHeight(Link link) throws IOException {
		screenshot = screenshoter.makeScreenshot(driver);
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.LINK);

		List<WebElement> webLinks = getAllLinks(driver);
		for (WebElement webLink : webLinks) {
			Dimension size = webLink.getSize();
			// for some reason some links are narrow
			if (size.getHeight() == 0) {
				continue;
			}

			if (size.getHeight() > 40 && size.getWidth() > 40) {
				continue;
			}

			if (link.getHeight().getContentLength() > size.getHeight()) {
				File file = screenshoter.takeScreenshot(screenshot.get(), webLink, driver);
				result.getFailedElements().add(prepareFailedElement(
						ElementType.LINK.name(), webLink.getText(),"The height of the link is smaller then expected. Expected minimum: "
								+ link.getHeight().getContentLength() + " actual: " + size.getHeight() , file));
			}
		}

		return setSuccessFlag(result);
	}

	private EvaluationResult evaluateDistance(Link link) {
		// todo implement
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.LINK);

		List<WebElement> links = getAllLinks(driver);

		List<WebElement> linkColors = new ArrayList<>();

//		System.out.println("Size" + links.size());

		Map<String, TopButton> topButtomCoordinates = new HashMap<>();

		for (WebElement existingElement : links) {
			if (StringUtils.isEmpty(existingElement.getText())) {
				continue;
			}
			TopButton topButton = new TopButton();
			Point location = existingElement.getLocation();
			Dimension size = existingElement.getSize();
			topButton.top = location.getY();
			topButton.buttom = location.getY() +  size.getHeight();
			topButton.left = location.getX();
			topButton.right = location.getX() + size.getWidth();
			topButton.webElement = existingElement;
			topButtomCoordinates.put(existingElement.getText(), topButton);
		}

		for (Map.Entry<String, TopButton> el : topButtomCoordinates.entrySet()) {
//			System.out.println(element.getText());
			String errorMessage = isLinkWithBadLocation(el.getKey(), el.getValue(), topButtomCoordinates, link.getDistance().getContentLength());
			if (errorMessage != null) {
//				System.out.println("---------------------------------");
//				System.out.println(element.getText());
//				System.out.println("---------------------------------");
				File file = screenshoter.takeScreenshot(screenshot.get(), el.getValue().webElement, driver);
				result.getFailedElements().add(prepareFailedElement(
						ElementType.LINK.name(), el.getKey(),errorMessage, NO_IMAGE));
			}
		}
//		for (WebElement element : links) {
//			if (StringUtils.isEmpty(element.getText())) {
//				continue;
//			}
////			System.out.println(element.getText());
//			String errorMessage = isLinkWithBadLocation(element, topButtomCoordinates, link.getDistance().getContentLength());
//			if (errorMessage != null) {
////				System.out.println("---------------------------------");
////				System.out.println(element.getText());
////				System.out.println("---------------------------------");
//				//File file = screenshoter.takeScreenshot(screenshot, element, driver);
//				result.getFailedElements().add(prepareFailedElement(
//						ElementType.LINK.name(), element.getText(),errorMessage, NO_IMAGE));
//			}
//		}

		// find all links
		// iterate over all links and finf if there are another link close to it

		return setSuccessFlag(result);
	}

	private String isLinkWithBadLocation(String text, TopButton element, Map<String, TopButton> elements, Integer distanceBetween) {
		Integer top = element.top;
		Integer button = element.buttom;

		Integer left = element.left;
		Integer right = element.right;

		for (Map.Entry<String, TopButton> entry : elements.entrySet()) {
			// top
			Integer distanceY;

			if (entry.getValue().top > top) {
				distanceY = entry.getValue().top - button;
			} else if (entry.getValue().top.equals(top)) {
				distanceY = 0;
			} else {
				continue;
			}


			Integer distanceX;

			if (entry.getValue().left > left) {
				distanceX = entry.getValue().left - right;
			} else if (entry.getValue().left.equals(left)) {
				distanceX = 0;
			} else {
				continue;
			}

			if (distanceX.equals(0) && distanceY.equals(0)) {
				continue;
			}

			if (distanceY < 0) distanceY = distanceY * (-1);

			if ((distanceY == 0 || distanceY < distanceBetween) && (distanceX == 0 || distanceX < distanceBetween)) {
				System.out.println("--------" + entry.getValue().top);
				System.out.println("DistanceY " + distanceY);
//				System.out.println(element.getText() + "-->" + entry.getKey());
//				System.out.println("--------" + element.getLocation().getY());
				System.out.println("DistanceX " + distanceX);
				return "Link: with text " + text + " is very close to " + entry.getKey();
			}
		}
		return null;
	}

	private EvaluationResult evaluateSameColor(Link link) throws IOException {
		System.out.println(LocalDateTime.now());
		screenshot = screenshoter.makeScreenshot(driver);
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.LINK);

		List<WebElement> webLinks = getAllLinks(driver);

		String linkColor = null;

		Map<String, LinkColor> linkColors = new HashMap();
		System.out.println(LocalDateTime.now());
		for (WebElement webLink : webLinks) {
			if (webLink.getText() == null || webLink.getText().length() == 0) {
				continue;
			}
			String color = webLink.getCssValue("color");
			LinkColor countOfElements = linkColors.get(color);
			if (countOfElements == null) {
				LinkColor linkColour = new LinkColor();
				linkColour.element = webLink;
				linkColors.put(color, linkColour);
			} else {
				countOfElements.count += 1;
			}
		}
		System.out.println(LocalDateTime.now());
//		Map<String, Integer> results = linkColors.entrySet().stream()
//				.sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
//				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//						(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		for (Map.Entry<String, LinkColor> entry : linkColors.entrySet()) {
			if (entry.getValue().count > 3) {
				File file = screenshoter.takeScreenshot(screenshot.get(), entry.getValue().element, driver);
				result.getFailedElements().add(prepareFailedElement(
						ElementType.LINK.name(), entry.getValue().element.getText(), "The link has different color then other links", file));
			}
		}
		System.out.println(LocalDateTime.now());
		return setSuccessFlag(result);
	}

	// TODO remove
	private EvaluationResult evaluateVisitedColorScheme(Link link) {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.LINK);

		if (true) {
			return setSuccessFlag(result);
		}

		List<WebElement> webLinks = getAllLinks(driver);

		Map<String, Integer> linkColors = new HashMap();

		for (WebElement webLink : webLinks) {
			if (webLink.getText() == null || webLink.getText().length() == 0) {
				continue;
			}
			String color = webLink.getCssValue("color");

			Integer countOfElements = linkColors.get(color);
			if (countOfElements == null) {
				countOfElements = 1;
			}
			linkColors.put(color, ++countOfElements);
		}

		driver.navigate().refresh();

		String mostlyUsedColor = linkColors.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
//		System.out.println("Mostly used colot");
//		System.out.println(mostlyUsedColor);
//		System.out.println(linkColors.get(mostlyUsedColor));

		int numberOfTrials = 0;
		int processed = 0;

		List<String> allVisitedLinkTexts = new ArrayList<>();
		while (numberOfTrials < 2) {
			webLinks = getAllLinks(driver);
			int numberOfProcessed = 0;
			for (WebElement webLink : webLinks) {
				if (webLink.getText() == null || webLink.getText().length() == 0) {
					continue;
				}
				String color = webLink.getCssValue("color");
				if (color.equals(mostlyUsedColor)) {
					System.out.println("---------------------");
					System.out.println(webLink.getText());
					System.out.println(numberOfProcessed);
					System.out.println(numberOfTrials);
					numberOfProcessed++;
					if (numberOfProcessed < numberOfTrials) {
						continue;
					}
					try {
						allVisitedLinkTexts.add(webLink.getText());
						webLink.click();
						driver.navigate().back();
						numberOfTrials++;
						break;
					} catch (Exception ex) {
						ex.printStackTrace();
						numberOfTrials++;
					}
				}
			}

			for (String visitedLink : allVisitedLinkTexts) {
				String color = driver.findElement(By.linkText(visitedLink)).getCssValue("color");
//				System.out.println(visitedLink);
//				System.out.println(color);

			}
		}



		return setSuccessFlag(result);
	}

	public List<WebElement> getAllLinks(WebDriver driver) {
		return driver.findElements(By.tagName("a"));
	}


}
