package ee.ttu.usability.guideliner.estimation.adaptor;


import ee.ttu.usability.guideliner.domain.element.form.CheckBox;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CheckButtonAdaptor extends AbstractFormAdaptor {

    public EvaluationResult execute(CheckBox checkBox) throws IOException {
        if (checkBox.getLayout() != null && checkBox.getLayout().getLayoutType() != null) {
            return evaluateLayout(checkBox);
        }
        if (checkBox.getLabel() != null && checkBox.getLabel().getIsValued()!= null) {
            return evaluateThatInputHasLabel("checkbox", "Checkbox element.", "Checkbox element should have label.");
        } else  if (checkBox.getLabel() != null && checkBox.getLabel().getHasText() != null) {
            return evaluateThatInputHasValuedLabel("checkbox", "Checkbox element.", "Checkbox element label should have value.");
        }
        if (checkBox.getPrecededElements() != null) {
            return evaluatePrecedingElements("checkbox", checkBox.getPrecededElements());
        }
        if (checkBox.getMinNumberOfInputs() != null) {
            return evaluateMinNumberOfInputGroups("checkbox", checkBox.getMinNumberOfInputs(), ElementType.CHECKBOX);
        }
        if (checkBox.getMaxNumberOfInputs() != null) {
            return evaluateMaxNumberOfInputGroups("checkbox", checkBox.getMaxNumberOfInputs(), ElementType.CHECKBOX);
        }
        throw new RuntimeException("Do not know what to evaluate ");
    }

    private EvaluationResult evaluateLayout(CheckBox checkBox) throws IOException {
        screenshot = screenshoter.makeScreenshot(driver);
        EvaluationResult result = new EvaluationResult();
        result.setElementType(ElementType.LINK);

        List<Integer> radiosWihtCoordinates = new ArrayList<>();

        List<WebElement> elements = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement radioEl : elements) {
            Point point = radioEl.getLocation();
            if (existsElementByY(point.getY(), radiosWihtCoordinates)) {
                screenshot.ifPresent(val -> {
                    File file = screenshoter.takeScreenshot(val, radioEl, driver);
                    result.getFailedElements().add(prepareFailedElement(ElementType.CHECKBOX.name(), radioEl.getAttribute("outerHTML"), "Checkbox should be vertically aligned.", file));
                });
            }
            radiosWihtCoordinates.add(point.getY());
        }

        return setSuccessFlag(result);
    }

    private boolean existsElementByY(Integer y, List<Integer> radiosWihtCoordinates) {
        for (Integer radioY : radiosWihtCoordinates) {
            if (radioY.equals(y)) {
                return true;
            }
        }
        return false;
    }

}
