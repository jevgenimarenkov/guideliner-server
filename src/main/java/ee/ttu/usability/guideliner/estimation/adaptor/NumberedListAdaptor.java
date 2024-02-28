package ee.ttu.usability.guideliner.estimation.adaptor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.domain.element.link.NumberedList;

@Slf4j
public class NumberedListAdaptor extends AbstractAdaptor {

	public EvaluationResult execute(NumberedList element) throws IOException {
		if (element.getContentLength()!= null) {
			return evaluateContentLenght(element);
		} 
		return null;
	}

	private EvaluationResult evaluateContentLenght(NumberedList element) throws IOException {
		log.debug("Estimation evaluateContentLenght");
		screenshot = screenshoter.makeScreenshot(driver);
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.NUMBERED_LIST);

		List<WebElement> imgs = driver.findElements(By.tagName("ul"));
		for (WebElement el : imgs) {
			List<WebElement> lis = el.findElements(By.tagName("li"));
			if (lis.size() <= element.getContentLength()) {
				File file = screenshoter.takeScreenshot(screenshot.get(), el, driver);
				 result.getFailedElements().add(prepareFailedElement("List", "List", "List contains " + lis.size() + " elements" , file));
				 result.setElementType(ElementType.NUMBERED_LIST);
			}
		}
		return setSuccessFlag(result);
	}

}
