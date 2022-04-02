package ee.ttu.usability.guideliner.estimation.adaptor;

import ee.ttu.usability.guideliner.domain.element.form.Input;
import ee.ttu.usability.guideliner.domain.element.form.Radio;
import ee.ttu.usability.guideliner.domain.element.link.Link;
import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.ResultType;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jevge on 21/07/2017.
 */
public class InputAdaptor extends AbstractAdaptor {

    public EvaluationResult execute(Input input) throws IOException {
        if (input.getColor() != null && input.getColor().getIsSame() != null && input.getIsSelected()) {
            return evaluateSelectedInput(input);
        }
        if (input.getLayout() != null && input.getLayout().getLayoutType() != null) {
            return evaluateLayout(input);
        }
        if (input.getDistance() != null && input.getDistance().getContentLength() != null && input.getDistance().getDistanceType() != null) {
            return evaluateDistance(input);
        }
        if (input.getHeight() != null && input.getHeight().getContentLength() != null) {
            return evaluateHeight(input);
        }
        if (input.getWidth() != null && input.getWidth().getContentLength() != null) {
            return evaluateWidth(input);
        }
            throw new RuntimeException("Cannot evaluate");
    }

    private EvaluationResult evaluateWidth(Input input) throws IOException {
        screenshot = screenshoter.makeScreenshot(driver);
        EvaluationResult result = new EvaluationResult();
        result.setElementType(ElementType.INPUT);

        List<WebElement> webLinks = driver.findElements(By.xpath("//input[@type='text']"));
        for (WebElement webLink : webLinks) {
            // for some reason some links are narrow
            Dimension dimension = webLink.getSize();
            if (dimension.getWidth() == 0) {
                continue;
            }

            if (input.getWidth().getContentLength() > dimension.getWidth()) {
                File file = screenshoter.takeScreenshot(screenshot.get(), webLink, driver);
                result.getFailedElements().add(prepareFailedElement(
                        ElementType.INPUT.name(), webLink.getText(),"The width of the input is smaller then expected. Expected minimum: "
                                + input.getWidth().getContentLength() + " actual: " + dimension.getWidth() , file));
            }
        }

        return setSuccessFlag(result);
    }

    private EvaluationResult evaluateHeight(Input input) throws IOException {
        screenshot = screenshoter.makeScreenshot(driver);
        EvaluationResult result = new EvaluationResult();
        result.setElementType(ElementType.INPUT);

        List<WebElement> webLinks = driver.findElements(By.xpath("//input[@type='text']"));

        for (WebElement webLink : webLinks) {
            Dimension dimension = webLink.getSize();
            // for some reason some links are narrow
            if (dimension.getHeight() == 0) {
                continue;
            }

            if (dimension.getHeight() > 40 && dimension.getWidth() > 40) {
                continue;
            }

            if (input.getHeight().getContentLength() > dimension.getHeight()) {
                File file = screenshoter.takeScreenshot(screenshot.get(), webLink, driver);
                result.getFailedElements().add(prepareFailedElement(
                        ElementType.LINK.name(), webLink.getText(),"The height of the input is smaller then expected. Expected minimum: "
                                + input.getHeight().getContentLength() + " actual: " + dimension.getHeight() , file));
            }
        }
        return setSuccessFlag(result);
    }

    private EvaluationResult evaluateDistance(Input link) {
        // todo implement
        EvaluationResult result = new EvaluationResult();
        result.setElementType(ElementType.INPUT);

        List<WebElement> links = driver.findElements(By.xpath("//input[@type='text']"));

        List<WebElement> linkColors = new ArrayList<>();

//		System.out.println("Size" + links.size());

        Map<String, TopButton> topButtomCoordinates = new HashMap<>();

        for (WebElement existingElement : links) {
            Point point = existingElement.getLocation();
            Dimension size = existingElement.getSize();
            TopButton topButton = new TopButton();
            topButton.top = point.getY();
            topButton.buttom = point.getY() + size.getHeight();
            topButton.left = point.getX();
            topButton.right = point.getX() + size.getWidth();
            topButton.webElement = existingElement;
            topButtomCoordinates.put(existingElement.getAttribute("name"), topButton);
        }

        for (Map.Entry<String, TopButton> el : topButtomCoordinates.entrySet()) {
//			System.out.println(element.getText());
            String errorMessage = isLinkWithBadLocation(el, topButtomCoordinates, link.getDistance().getContentLength());
            if (errorMessage != null) {
//				System.out.println("---------------------------------");
//				System.out.println(element.getText());
//				System.out.println("---------------------------------");
                File file = screenshoter.takeScreenshot(screenshot.get(), el.getValue().webElement, driver);
                result.getFailedElements().add(prepareFailedElement(
                        ElementType.INPUT.name(), el.getKey(),errorMessage, file));
            }
        }

//        for (WebElement element : links) {
////			System.out.println(element.getText());
//            String errorMessage = isLinkWithBadLocation(element, topButtomCoordinates, link.getDistance().getContentLength());
//            if (errorMessage != null) {
////				System.out.println("---------------------------------");
////				System.out.println(element.getText());
////				System.out.println("---------------------------------");
//                File file = screenshoter.takeScreenshot(screenshot, element, driver);
//                result.getFailedElements().add(prepareFailedElement(
//                        ElementType.INPUT.name(), element.getText(),errorMessage, file));
//            }
//        }

        // find all links
        // iterate over all links and finf if there are another link close to it

        return setSuccessFlag(result);
    }

    private String isLinkWithBadLocation(Map.Entry<String, TopButton> en, Map<String, TopButton> elements, Integer distanceBetween) {
        TopButton topButton = en.getValue();
        Integer top = topButton.top;
        Integer button = topButton.buttom;

        Integer left = topButton.left;
        Integer right = topButton.right;

        for (Map.Entry<String, TopButton> entry : elements.entrySet()) {
            // top
            Integer distanceY;

            if (entry.getValue().top > top) {
                distanceY = entry.getValue().top - button;
            } else if (entry.getValue().top.equals(top)) {
                distanceY = 0;
            } else {
                continue;
            }


            Integer distanceX;

            if (entry.getValue().left > left) {
                distanceX = entry.getValue().left - right;
            } else if (entry.getValue().left.equals(left)) {
                distanceX = 0;
            } else {
                continue;
            }

            if (distanceX.equals(0) && distanceY.equals(0)) {
                continue;
            }

            if (distanceY < 0) distanceY = distanceY * (-1);

            if ((distanceY == 0 || distanceY < distanceBetween) && (distanceX == 0 || distanceX < distanceBetween)) {
                System.out.println("--------" + entry.getValue().top);
                System.out.println("DistanceY " + distanceY);
//                System.out.println(element.getText() + "-->" + entry.getKey());
//                System.out.println("--------" + element.getLocation().getY());
                System.out.println("DistanceX " + distanceX);
                return "Input: with text " + en.getKey() + " is very close to " + entry.getKey();
            }
        }
        return null;
    }

    private EvaluationResult evaluateLayout(Input input) throws IOException {
        screenshot = screenshoter.makeScreenshot(driver);
        EvaluationResult result = new EvaluationResult();
        result.setElementType(ElementType.INPUT);

        List<Integer> radiosWihtCoordinates = new ArrayList<>();

        List<WebElement> elements = driver.findElements(By.xpath("//input"));

        for (WebElement radioEl : elements) {
            Point point = radioEl.getLocation();
            if (existsElementByY(point.getY(), radiosWihtCoordinates)) {
                File file = screenshoter.takeScreenshot(screenshot.get(), radioEl, driver);
                result.getFailedElements().add(prepareFailedElement("Input", radioEl.getAttribute("outerHTML"), "Input should be vertically aligned.", file));
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

    private EvaluationResult evaluateSelectedInput(Input input) throws IOException {
        screenshot = screenshoter.makeScreenshot(driver);

        EvaluationResult result = new EvaluationResult();
        result.setElementType(ElementType.LINK);

        // TODO check and implement
        if (true) {
            return setSuccessFlag(result);
        }

        List<WebElement> elements = driver.findElements(By.xpath("//input[@type='text']"));

        for (WebElement element : elements) {
            if (!element.isDisplayed()) {
                continue;
            }
            System.out.println(element.isEnabled());
            String colorBefore = element.getCssValue("border-top-color");
            element.click();
            String colorAfter = element.getCssValue("border-top-color");
            if (colorBefore.equals(colorAfter)) {
                File file = screenshoter.takeScreenshot(screenshot.get(), element, driver);
                result.getFailedElements().add(prepareFailedElement(
                        ElementType.INPUT.name(), element.getAttribute("outerHTML"), "Input should be highligted after selected" , file));
                result.setResult(ResultType.FAIL);            }
        }

        return setSuccessFlag(result);
    }
}
