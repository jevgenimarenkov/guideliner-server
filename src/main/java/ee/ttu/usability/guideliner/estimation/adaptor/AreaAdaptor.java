package ee.ttu.usability.guideliner.estimation.adaptor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ee.ttu.usability.guideliner.domain.element.link.Area;
import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;

public class AreaAdaptor extends AbstractAdaptor {

	public EvaluationResult execute(Area area) throws IOException {
		if (area.getAlternativeText() != null) {
			return evaluateAlternativeText(area);
		} 
		return null;
	}
	
	private EvaluationResult evaluateAlternativeText(Area area) throws IOException {
		screenshot = screenshoter.makeScreenshot(driver);
		
		List<WebElement> areas = driver.findElements(By.tagName("area"));
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.AREA);
		
		areas.forEach(a -> {
			String attribute = a.getAttribute("alt");
			if (StringUtils.isBlank(attribute)) {
				File file = screenshoter.takeScreenshot(screenshot.get(), a, driver);
				result.getFailedElements().add(prepareFailedElement(ElementType.AREA.name(), "Area", "Area does not have alternative text", file));
			}
		});
				
		return setSuccessFlag(result);
	}

	
}
