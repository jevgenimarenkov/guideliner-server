package ee.ttu.usability.guideliner.estimation.adaptor;


import ee.ttu.usability.guideliner.domain.element.form.FormElementLabel;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FormElementLabelAdaptor extends AbstractAdaptor {

    public EvaluationResult execute(FormElementLabel label) throws IOException {
        if (label.getPositionType() != null) {
            return evaluatePositionType(label);
        }
        throw new RuntimeException("Cannot process element");
    }

    private EvaluationResult evaluatePositionType(FormElementLabel elementLabel) throws IOException {
        screenshot = screenshoter.makeScreenshot(driver);

        EvaluationResult result = new EvaluationResult();
        result.setElementType(ElementType.FORMELEMENTLABEL);

        Map<Integer, WebElement> labelsWithCoordinates = new HashedMap();

        for (WebElement label : driver.findElements(By.tagName("label"))) {
                labelsWithCoordinates.put(label.getLocation().getY(), label);
        }

        for (WebElement input : driver.findElements(By.tagName("input"))) {
            if ("input".equals(input.getTagName()) && (input.getAttribute("type") == null
                    || !input.getAttribute("type").equals("hidden"))) {
                Point location = input.getLocation();
                WebElement labelWithSameCoordinate = getElementByY(location.getY(), labelsWithCoordinates);
                System.out.println("input" + " -- " + input.getAttribute("name") + " -- " + location.getY() + " label with coord" + (labelWithSameCoordinate != null ? labelWithSameCoordinate.getText() : null));
                if (labelWithSameCoordinate != null && StringUtils.isNotEmpty(labelWithSameCoordinate.getText())) {
                    File file = screenshoter.takeScreenshot(screenshot.get(), labelWithSameCoordinate, driver);
                    result.getFailedElements().add(prepareFailedElement("Label", labelWithSameCoordinate.getText(), "Label should be above input.", file));
                }
            }
        }

        return setSuccessFlag(result);
    }

    private WebElement getElementByY(Integer y, Map<Integer, WebElement> labelsWithCoordinates) {

        for (Map.Entry<Integer, WebElement> entry : labelsWithCoordinates.entrySet()) {
            if (entry.getKey().equals(y)) {
                return entry.getValue();
            }
        }

        return null;
    }

    public List<WebElement> getLabels(WebDriver driver) {
        return driver.findElements(By.tagName("label"));
    }

}
