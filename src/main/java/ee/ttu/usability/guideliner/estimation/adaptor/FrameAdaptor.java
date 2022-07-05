package ee.ttu.usability.guideliner.estimation.adaptor;

import ee.ttu.usability.guideliner.domain.element.link.Area;
import ee.ttu.usability.guideliner.domain.element.link.Frame;
import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FrameAdaptor extends AbstractAdaptor {

    public EvaluationResult execute(Frame frame) throws IOException {
        if (frame.getTitle() != null && frame.getTitle().getIsValued() != null) {
            return evaluateTitle(frame);
        }
        return null;
    }

    private EvaluationResult evaluateTitle(Frame frame) throws IOException {
        screenshot = screenshoter.makeScreenshot(driver);

        List<WebElement> areas = driver.findElements(By.tagName("frame"));
        EvaluationResult result = new EvaluationResult();
        result.setElementType(ElementType.FRAME);

        areas.forEach(a -> {
            String attribute = a.getAttribute("title");
            if (StringUtils.isBlank(attribute)) {
                result.getFailedElements().add(prepareFailedElement(ElementType.FRAME, "Frame", "Frame does not have title.", NO_IMAGE));
            }
        });

        return setSuccessFlag(result);
    }


}