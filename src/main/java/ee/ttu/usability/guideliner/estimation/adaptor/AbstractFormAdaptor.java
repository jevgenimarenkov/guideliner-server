package ee.ttu.usability.guideliner.estimation.adaptor;

import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.estimation.result.ResultType;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractFormAdaptor extends AbstractAdaptor {

    protected EvaluationResult evaluateMinNumberOfInputGroups(String inputType, Integer numberOfInputs, ElementType elementType) {
        EvaluationResult result = new EvaluationResult();
        result.setElementType(elementType);

        Map<String, Integer> radios = getElementWithCount(inputType);

        radios.forEach((k, v) -> {
            if (v <= numberOfInputs) {
                result.getFailedElements().add(prepareFailedElement(inputType, k, inputType + " contains less options then allowed. Allowed " + numberOfInputs +
                        ". Actual : " + v, NO_IMAGE));
            }
        });

        return setSuccessFlag(result);
    }

    protected EvaluationResult evaluateMaxNumberOfInputGroups(String inputType, Integer numberOfInputs, ElementType elementType) {
        EvaluationResult result = new EvaluationResult();
        result.setElementType(elementType);

        Map<String, Integer> radios = getElementWithCount(inputType);

        radios.forEach((k, v) -> {
            if (v > numberOfInputs) {
                result.getFailedElements().add(prepareFailedElement(inputType, k, inputType + " contains more options then allowed. Allowed " + numberOfInputs +
                        ". Actual : " + v, NO_IMAGE));
            }
        });

        return setSuccessFlag(result);
    }

    private Map<String, Integer> getElementWithCount(String inputType) {
        final List<WebElement> radio = driver.findElements(By.xpath("//input[@type='" + inputType + "']"));

        Map<String, Integer> radios = new HashMap<>();

        radio.forEach(r -> {
            if (radios.containsKey(r.getAttribute("name"))) {
                Integer count = radios.get(r.getAttribute("name"));
                radios.put(r.getAttribute("name"), ++count);
            } else {
                radios.put(r.getAttribute("name"), 1);
            }
        });

        return radios;
    }


    protected EvaluationResult evaluateThatInputHasLabel(String inputType, String elementName, String errorDescription) {
        EvaluationResult result = new EvaluationResult();
        result.setElementType(ElementType.PAGE);
        result.setResult(ResultType.SUCCESS);

        driver.findElements(By.cssSelector("input[type='"+inputType+"']")).forEach(t -> {
            final List<WebElement> id = this.driver.findElements(By.cssSelector("label[for='" + t.getAttribute("id") + "']"));
            if (id.size() == 0) {
                result.getFailedElements()
                        .add(prepareFailedElement(inputType, t.getAttribute("outerHTML"), errorDescription, NO_IMAGE));
            }
        });
        return setSuccessFlag(result);
    }

    protected EvaluationResult evaluateThatInputHasValuedLabel(String inputType, String elementName, String errorDescription) {
        EvaluationResult result = new EvaluationResult();
        result.setElementType(ElementType.PAGE);
        result.setResult(ResultType.SUCCESS);

        driver.findElements(By.cssSelector("input[type='"+inputType+"']")).forEach(t -> {
            final List<WebElement> labels = this.driver.findElements(By.cssSelector("label[for='" + t.getAttribute("id") + "']"));
            if (labels.size() > 0) {
                final WebElement label = labels.get(0);
                if (StringUtils.isBlank(label.getText())) {
                    result.getFailedElements()
                            .add(prepareFailedElement(inputType, t.getAttribute("outerHTML"), errorDescription, NO_IMAGE));
                }
            }
        });
        return setSuccessFlag(result);
    }

    protected EvaluationResult evaluatePrecedingElements(String tag, List<String> tagsThatMustBeBefore) {
        EvaluationResult result = new EvaluationResult();
        result.setElementType(ElementType.PAGE);
        result.setResult(ResultType.SUCCESS);

        List<WebElement> elements = driver.findElements(By.xpath("//input[@type='"+tag+"']"));
        elements.forEach(el -> {
            // TODO search by value
            List<WebElement> elementsBefore = driver.findElements(By.xpath("//"+tagsThatMustBeBefore.get(0)+"//input[@type='"+tag+"']"));
            if (elementsBefore.size() == 0) {
                result.getFailedElements().add(prepareFailedElement(tag, el.getAttribute("outerHTML"), tag + " should be preceded by " + tagsThatMustBeBefore.get(0), NO_IMAGE));
            }
        });

        return setSuccessFlag(result);
    }

}
