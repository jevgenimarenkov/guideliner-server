package ee.ttu.usability.guideliner.estimation.adaptor;

import ee.ttu.usability.guideliner.domain.attribute.AlternativeText;
import ee.ttu.usability.guideliner.domain.element.link.Applet;
import ee.ttu.usability.guideliner.domain.element.link.Link;
import ee.ttu.usability.guideliner.domain.element.link.TableHeader;
import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.estimation.result.ResultType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service("TableHeaderAdaptor")
public class TableHeaderAdaptor extends AbstractAdaptor {

	public EvaluationResult execute(TableHeader applet) throws IOException {
		if (BooleanUtils.isTrue(applet.getHasText())) {
			return evaluateThatInpuHasText(applet);
		}
		return EvaluationResult.EMPTY_RESULT;
	}

	protected EvaluationResult evaluateThatInpuHasText(TableHeader link) {
		EvaluationResult result = new EvaluationResult();
		result.setElementType(ElementType.HEADER);
		result.setResult(ResultType.SUCCESS);
		driver.findElements(By.tagName("th")).forEach(t -> {
			if (StringUtils.isBlank(t.getText())) {
				result.getFailedElements()
						.add(prepareFailedElement(ElementType.HEADER.name(), t.getAttribute("outerHTML"), "Th should have text", NO_IMAGE));
			}
		});
		return setSuccessFlag(result);
	}
}
