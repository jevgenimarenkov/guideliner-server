package ee.ttu.usability.guideliner.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import ee.ttu.usability.guideliner.estimation.result.ElementType;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;
import ee.ttu.usability.guideliner.estimation.result.FailedElement;
import ee.ttu.usability.guideliner.estimation.result.ResultType;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Slf4j
public class ContrastEstimator {

	private BufferedImage processedSubimage = null;
	// TODO should use data from variable
	public EvaluationResult estimate(List<WebElement> allLinks, WebDriver driver, BufferedImage screenshot) throws IOException {
		Screenshoter screenshoter = new Screenshoter();

		EvaluationResult result = new EvaluationResult();
		result.setResult(ResultType.SUCCESS);

		int amountOfIncorrectLinks = 0;
		int amountOfProcessesLinks = 0;

		for (WebElement ele : allLinks) {
			try {
				if (StringUtils.isEmpty(ele.getText())) {
					continue;
				}
				amountOfProcessesLinks++;

//				System.out.println("linktext " + ele.getText());
				String color = ele.getCssValue("color");
//				System.out.println("color: " + color);
//				String hexaColor = ContrastUtils
//						.convertCssColorToHexadecimalFormat(color);

				color = color.substring(5);
				StringTokenizer st = new StringTokenizer(color);

				int r = Integer.parseInt(st.nextToken(",").trim());
				int g = Integer.parseInt(st.nextToken(",").trim());
				int b = Integer.parseInt(st.nextToken(",").trim());
				double foregraund = ContrastUtils.calculateLuminance(r, g, b);
				
				double background = getBackGroundColor(screenshot, ele);

				double contrastRatio = ContrastUtils.calculateContrastRatio(
						foregraund, background);

				float textSize = new Float(ele.getCssValue("font-size")
						.replace("px", ""));
				double requiredContrast = isLargeText(textSize, isTextBold(ele)) ? ContrastUtils.CONTRAST_RATIO_WCAG_LARGE_TEXT
						: ContrastUtils.CONTRAST_RATIO_WCAG_NORMAL_TEXT;

				if (contrastRatio < requiredContrast) {
					amountOfIncorrectLinks++;
					String message = String.format(
							"Element with text %s does not have required contrast of "
									+ "%.2f. Actual contrast is %.2f",
									ele.getText(), requiredContrast, contrastRatio);
					File file = screenshoter.convertImageToFile(processedSubimage);
					result.getFailedElements().add(prepareFailedElement("LINK", ele.getText(), message, file.getName()));
				}

			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}

		result.setDescription(String.format("Amount of processed links was %d.", amountOfProcessesLinks));
		if (amountOfIncorrectLinks != 0) {
			result.setResult(ResultType.FAIL);
			result.setDescription(String.format("Amount of processed links was %d. Failed %d of them ", amountOfProcessesLinks, amountOfIncorrectLinks));
			result.setElementType(ElementType.LINK);
		}
		return result;
	}

	private double getBackGroundColor(BufferedImage screenshot, WebElement ele)
			throws IOException {

		Point point = ele.getLocation();

		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();

		processedSubimage = screenshot.getSubimage(point.getX(),
				point.getY(), eleWidth, eleHeight);

		// String hex = "#"+Integer.toHexString(eleScreenshot.getRGB(0,
		// 0)).substring(2);

		Color color = new Color(processedSubimage.getRGB(0, 0), true);
		return ContrastUtils.calculateLuminance(color.getRed(),
				color.getGreen(), color.getBlue());
	}

	private boolean isTextBold(WebElement element) {
		String fontWeight = element.getCssValue("font-weight");
		return fontWeight.equals("bold") || fontWeight.equals("700")
				|| fontWeight.equals("strong");
	}

	private static boolean isLargeText(float textSize, boolean isBold) {
		return textSize >= ContrastUtils.WCAG_LARGE_TEXT_MIN_SIZE
				|| (textSize >= ContrastUtils.WCAG_LARGE_BOLD_TEXT_MIN_SIZE && isBold);
	}

	FailedElement prepareFailedElement(String type, String text, String description, String path) {
		FailedElement element = new FailedElement();
		element.setType(type);
		element.setText(text);
		element.setDescription(description);
		element.setPathToElement(path);
		return element;
	}

}
