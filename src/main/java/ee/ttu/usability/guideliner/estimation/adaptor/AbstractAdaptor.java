package ee.ttu.usability.guideliner.estimation.adaptor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

import ee.ttu.usability.guideliner.domain.attribute.AlternativeText;
import ee.ttu.usability.guideliner.domain.dataproperty.Unit;
import ee.ttu.usability.guideliner.domain.element.UsabilityGuideline;
import ee.ttu.usability.guideliner.domain.element.link.TableHeader;
import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.ResultType;
import lombok.Data;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.estimation.result.FailedElement;
import ee.ttu.usability.guideliner.util.Screenshoter;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public abstract class AbstractAdaptor {

	protected Screenshoter screenshoter = new Screenshoter();

	protected static final String NO_IMAGE = "NONE";
	
	protected WebDriver driver;
	
	protected Optional<BufferedImage> screenshot = Optional.empty();

	public  abstract EvaluationResult execute(UsabilityGuideline applet);

	protected Integer getAmountOfUnit(String string, Unit unit) {
		if (string == null || unit == null) {
			return 0;
		}
		switch (unit) {
			case WORD:
				return new StringTokenizer(string).countTokens();
			case LINE:
				return (int) string.lines().count();
			default:
				return 0;
		}
	}

	FailedElement prepareFailedElement(ElementType type, String text, String description, String path) {
		FailedElement element = new FailedElement();
		element.setType(type.name());
		element.setText(text);
		element.setDescription(description);
		element.setPathToElement(path);
		return element;
	}

	FailedElement prepareFailedElement(String type, String text, String description, String path) {
		FailedElement element = new FailedElement();
		element.setType(type);
		element.setText(text);
		element.setDescription(description);
		element.setPathToElement(path);
		return element;
	}
	
	FailedElement prepareFailedElement(String type, String text, String description, File file) {
		FailedElement element = new FailedElement();
		element.setType(type);
		element.setText(text);
		element.setDescription(description);
		if (file != null) {
			element.setPathToElement(file.getName());			
		}
		return element;
	}

	protected EvaluationResult setSuccessFlag(EvaluationResult result) {
		result.setResult(result.getFailedElements().isEmpty() ? ResultType.SUCCESS : ResultType.FAIL);
		return result;
	}

	protected EvaluationResult evaluateAlternativeText(String tagName, ElementType elementType) throws IOException {
		List<WebElement> areas = driver.findElements(By.tagName(tagName));
		EvaluationResult result = new EvaluationResult();
		result.setElementType(elementType);

		areas.forEach(a -> {
			String attribute = a.getAttribute("alt");
			if (StringUtils.isBlank(attribute)) {
				result.getFailedElements().add(prepareFailedElement(elementType, a.getAttribute("outerHtml"), tagName + " does not have alternative text", NO_IMAGE));
			}
		});

		return setSuccessFlag(result);
	}
	
}
