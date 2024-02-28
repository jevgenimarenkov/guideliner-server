package ee.ttu.usability.guideliner.estimation.adaptor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ee.ttu.usability.guideliner.domain.dataproperty.Unit;
import ee.ttu.usability.guideliner.domain.dataproperty.UnitAction;
import ee.ttu.usability.guideliner.domain.element.link.Graphic;
import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.ResultType;
import ee.ttu.usability.guideliner.util.Screenshoter;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.estimation.result.FailedElement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class GraphicAdaptor extends AbstractAdaptor {
	
	public EvaluationResult execute(Graphic graphic) throws IOException {
		if (graphic.getContentLength() != null) {
			return evaluateContentLength(graphic);
		}
		if (graphic.getAlternativeText() != null) {
			return evaluateAlternativeText(graphic);
		}
		return null;
	}

	private EvaluationResult evaluateContentLength(Graphic graphic) throws IOException {
		log.debug("Evaluating Graphic.");
		
		screenshot = screenshoter.makeScreenshot(driver);
		
		List<FailedElement> failedElements = new ArrayList<FailedElement>();
		
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.GRAPHIC);
		
		List<WebElement> inputs = driver.findElements(By.tagName("img"));

		for (WebElement element : inputs) {
			URLConnection urlConnection;
			try {
				System.out.println(element.getAttribute("src"));
				urlConnection = new URL(element.getAttribute("src")).openConnection();
				long bytes = urlConnection. getContentLengthLong(); // in bytes	
				long kBytes =  bytes / 1024;
				if (kBytes > graphic.getContentLength()) {
					FailedElement failed = new FailedElement();
					failed.setType(ElementType.GRAPHIC.name());
					failed.setText("Image");
					failed.setDescription("Expected image size is " + graphic.getContentLength() + ". Actual image has size is : " + kBytes);			
					File file = screenshoter.takeScreenshot(screenshot.get(), element, driver);
					failed.setPathToElement(file.getName());
					failedElements.add(failed);
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
		
		result.setFailedElements(failedElements);
		if (failedElements.size() == 0)
			result.setResult(ResultType.SUCCESS);
		else 
			result.setResult(ResultType.FAIL);

		return result;
	}
	
	
	private EvaluationResult evaluateAlternativeText(Graphic area) throws IOException {
		screenshot = screenshoter.makeScreenshot(driver);
		
		List<WebElement> imgs = driver.findElements(By.tagName("img"));
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.GRAPHIC);

		if (area.getAlternativeText().getProhibitedWords() != null && area.getAlternativeText().getProhibitedWords().getUnit() != null) {
			imgs.forEach(img -> {
				String prohibitedWord = null;
				Unit unit = area.getAlternativeText().getProhibitedWords().getUnit();
				UnitAction action = area.getAlternativeText().getProhibitedWords().getUnitAction();
				if (unit == Unit.FILE_NAME) {
					prohibitedWord =  getFileName(img.getAttribute("src"));
					if (UnitAction.DO_NOT_FOLLOW == action && StringUtils.isNotEmpty(prohibitedWord) && prohibitedWord.equals(img.getAttribute("alt"))) {
						File file = screenshoter.takeScreenshot(screenshot.get(), img, driver);
						result.getFailedElements().add(prepareFailedElement("UI Page", "Elements with alt attribute", "The word " + prohibitedWord + "  for alternative text is not allowed as it duplicates the file name" , file));
					}
				}
			});
			return setSuccessFlag(result);
		}

		imgs.forEach(a -> {
			String attribute = a.getAttribute("alt");
			if (StringUtils.isBlank(attribute)) {
				File file = screenshoter.takeScreenshot(screenshot.get(), a, driver);
				result.getFailedElements().add(prepareFailedElement(ElementType.GRAPHIC.name(), a.getText(), "Image does not have alternative text", file));
			}
		});
				
		return setSuccessFlag(result);
	}

	private String getFileName(String paht) {
		List<String> parts = Arrays.asList(paht.split("/"));
		return parts.get(parts.size() - 1);
	}

}
