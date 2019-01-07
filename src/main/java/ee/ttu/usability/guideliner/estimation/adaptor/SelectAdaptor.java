package ee.ttu.usability.guideliner.estimation.adaptor;

import ee.ttu.usability.guideliner.domain.element.form.Select;
import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectAdaptor extends AbstractFormAdaptor {
    public EvaluationResult execute(Select element) {
        if (element.getLabel() != null && element.getLabel().getIsValued() != null) {
            return evaluateThatInputHasLabel("select", "Select element.", "Select element should have label.");
        } else if (element.getLabel() != null && element.getLabel().getHasText() != null) {
            return evaluateThatInputHasValuedLabel("select", "Select element.", "Select element label should have value.");
        }
        if (element.getMinNumberOfInputs() != null) {
            return evaluateMinNumberOfInputsInSelect("select", element.getMinNumberOfInputs(), ElementType.SELECT_INPUT);
        }
        throw new RuntimeException("Do not know what to evaluate ");
    }

    protected EvaluationResult evaluateMinNumberOfInputsInSelect(String inputType, Integer numberOfInputs, ElementType elementType) {
        EvaluationResult result = new EvaluationResult();
        result.setElementType(elementType);

        final List<WebElement> selects = driver.findElements(By.tagName("select"));

        selects.forEach(select -> {
            final List<WebElement> options = select.findElements(By.tagName("option"));
            if (options.size() < numberOfInputs) {
                result.getFailedElements().add(prepareFailedElement(inputType, select.getAttribute("outerHTML"), inputType + " contains less options then allowed. Allowed " + numberOfInputs +
                        ". Actual : " + options.size(), NO_IMAGE));
            }
        });
        return setSuccessFlag(result);
    }
}
