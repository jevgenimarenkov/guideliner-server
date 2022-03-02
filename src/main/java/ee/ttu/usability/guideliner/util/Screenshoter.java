package ee.ttu.usability.guideliner.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicLong;

import javax.imageio.ImageIO;

import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Screenshoter {

	protected AtomicLong screenshotCounter = new AtomicLong();

	private static BufferedImage screenshot2 = null;
	public BufferedImage makeScreenshot(WebDriver driver)
			throws IOException {
		return makeScreenshot(driver, false);
	}

	public static BufferedImage makeScreenshot(WebDriver driver, boolean makeAnyWay)
			throws IOException {
		if (screenshot2 != null && !makeAnyWay) {
			return screenshot2;
		}
		try {
			File screenshot = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			BufferedImage image = ImageIO.read(screenshot);
			screenshot2 = image;
			return image;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	public File takeScreenshot(BufferedImage screenshot, WebElement element, WebDriver driver) {
		try {
			LocalDateTime startTime = LocalDateTime.now();
			BufferedImage dest = takeScreenshotAsImage(screenshot, element, driver);
			File screenshotOfElement = new File(Configuration.reportsFolder,
					generateScreenshotFileName() + ".png");
			ensureFolderExists(screenshotOfElement);
			ImageIO.write(dest, "png", screenshotOfElement);
			Logger.Info("SCREEN TOOK " + startTime.until(LocalDateTime.now(), ChronoUnit.MILLIS));
			return screenshotOfElement;
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}

	public File convertImageToFile(BufferedImage dest) {
		try {
			File screenshotOfElement = new File(Configuration.reportsFolder,
					generateScreenshotFileName() + ".png");
			ensureFolderExists(screenshotOfElement);
			ImageIO.write(dest, "png", screenshotOfElement);
			return screenshotOfElement;
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}


	public File save2(WebElement element) {
		try {
			BufferedImage dest = ImageIO.read(element.getScreenshotAs(OutputType.FILE));
			File screenshotOfElement = new File(Configuration.reportsFolder,
					generateScreenshotFileName() + ".png");
			ensureFolderExists(screenshotOfElement);
			ImageIO.write(dest, "png", screenshotOfElement);
			return screenshotOfElement;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public BufferedImage takeScreenshotAsImage(BufferedImage screenshot, WebElement element,
			WebDriver driver) {
		Point p = element.getLocation();
		Dimension elementSize = element.getSize();

		BufferedImage dest = screenshot.getSubimage(p.getX(), p.getY(),
				elementSize.getWidth(), elementSize.getHeight());
		return dest;
	}

	protected File ensureFolderExists(File targetFile) {
		File folder = targetFile.getParentFile();
		if (!folder.exists()) {
			log.info("Creating folder: " + folder);
			if (!folder.mkdirs()) {
				log.error("Failed to create " + folder);
			}
		}
		return targetFile;
	}

	protected String generateScreenshotFileName() {
		return "screen" + timestamp() + "."
				+ screenshotCounter.getAndIncrement();
	}

	protected long timestamp() {
		return System.currentTimeMillis();
	}
}
