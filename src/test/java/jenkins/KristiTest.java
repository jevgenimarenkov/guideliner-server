package jenkins;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.test.context.TestContextManager;
import ee.ttu.usability.guideliner.estimation.result.EvaluationResult;

public class KristiTest extends AbstractUsabilityTest {

    WebDriver driver;
    @Before
    public void configureDriver() throws Exception {
        if (this.testContextManager == null) {
            this.testContextManager = new TestContextManager(getClass());
            this.testContextManager.prepareTestInstance(this);
        }
        driver = ontologyEvaluatorService.initialiseDriverIfNotInitialised(URL);
    }

    @Test
    public void testUsabilityGuidelines() throws InterruptedException {
        driver.get("https://achecker.ca/checker/index.php");
        Thread.sleep(1000);
        driver.findElement(By.id("checkuri")).sendKeys("http://www.etis.ee");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Options")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("option_rpt_line")).click();
        driver.findElement(By.id("checkbox_gid_2")).click();
        driver.findElement(By.id("checkbox_gid_7")).click();
        driver.findElement(By.id("enable_css_validation")).click();
        driver.findElement(By.id("enable_html_validation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("validate_uri")).click();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AC_menu_errors")));

        System.out.println("Analysis of results");
        System.out.println("Known problems" + driver.findElement(By.id("AC_num_of_errors")).getText());
        System.out.println("Likely problems" + driver.findElement(By.id("AC_num_of_likely")).getText());
        System.out.println("HTML" + driver.findElement(By.id("AC_num_of_html_errors")).getText());
        System.out.println("Validation" + driver.findElement(By.id("AC_num_of_css_errors")).getText());
    }
}
