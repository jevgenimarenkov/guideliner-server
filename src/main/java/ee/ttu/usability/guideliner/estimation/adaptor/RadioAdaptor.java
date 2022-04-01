package ee.ttu.usability.guideliner.estimation.adaptor;


import ee.ttu.usability.guideliner.domain.element.form.Radio;
import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.ResultType;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadioAdaptor extends AbstractFormAdaptor {

    public EvaluationResult execute(Radio radio) throws IOException {
        if (radio.getLayout() != null && radio.getLayout().getLayoutType() != null) {
            return evaluateLayout(radio);
        }
        if (radio.getLabel() != null && radio.getLabel().getIsValued() != null) {
            return evaluateThatInputHasLabel("radio", "Radio element.", "Radio element should have description.");
        } else  if (radio.getLabel() != null && radio.getLabel().getHasText() != null) {
            return evaluateThatInputHasValuedLabel("radio", "Radio element.", "Radio element label should have value.");
        }
        if (radio.getPrecededElements() != null) {
            return evaluatePrecedingElements("radio", radio.getPrecededElements());
        }
        if (radio.getMinNumberOfInputs() != null) {
            return evaluateMinNumberOfInputGroups("radio", radio.getMinNumberOfInputs(), ElementType.RADIO);
        }
        if (radio.getMaxNumberOfInputs() != null) {
            return evaluateMaxNumberOfInputGroups("radio", radio.getMaxNumberOfInputs(), ElementType.RADIO);
        }
        throw new RuntimeException("Do not know what to evaluate ");
    }

    private EvaluationResult evaluateLayout(Radio radio) throws IOException {
        screenshot = screenshoter.makeScreenshot(driver);
        EvaluationResult result = new EvaluationResult();
        result.setElementType(ElementType.LINK);

        List<Integer> radiosWihtCoordinates = new ArrayList<>();

        List<WebElement> elements = driver.findElements(By.xpath("//input[@type='radio']"));

        for (WebElement radioEl : elements) {
            Point location = radioEl.getLocation();
            if (existsElementByY(location.getY(), radiosWihtCoordinates)) {
                File file = screenshoter.takeScreenshot(screenshot.get(), radioEl, driver);
                result.getFailedElements().add(prepareFailedElement("Label", radioEl.getAttribute("outerHTML"), "Radio buttons should be vertically aligned.", file));
            }
            radiosWihtCoordinates.add(location.getY());
        }

        return setSuccessFlag(result);
    }

    private boolean existsElementByY(Integer y, List<Integer> radiosWithCoordinates) {
        return radiosWithCoordinates.stream().anyMatch(radioY -> radioY.equals(y));
    }
}
