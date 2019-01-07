package ee.ttu.usability.guideliner.estimation.adaptor;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.domain.element.link.Multimedia;

public class MultimediaAdaptor extends AbstractAdaptor {

	public EvaluationResult execute(Multimedia el) throws IOException {
		if (el.getAlternativeText() != null) {
			return evaluateAlternativeText(el);
		} 
		return null;
	}

	private EvaluationResult evaluateAlternativeText(Multimedia el) throws IOException {
		screenshot = screenshoter.makeScreenshot(driver);
		
		List<WebElement> imgs = driver.findElements(By.tagName("img"));
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.MULTIMEDIA);
		
		for (WebElement elem : imgs) {
			try {
				String attribute = elem.getAttribute("alt");
				if (StringUtils.isBlank(attribute)) {
					result.getFailedElements().add(prepareFailedElement(ElementType.IMAGE.name(), elem.getText(), "Image does not have alternative text" , screenshoter.takeScreenshot(screenshot, elem, driver)));
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return setSuccessFlag(result);
	}

}
