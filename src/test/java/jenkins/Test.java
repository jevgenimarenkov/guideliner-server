package jenkins;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class Test {

    public static void main (String[] ff) {
        LocalDateTime begin = LocalDateTime.now();
        HtmlUnitDriver driver = new HtmlUnitDriver();
        System.out.println("dddddddddd");

        LocalDateTime now = LocalDateTime.now();
        driver.get("http://www.eesti.ee");
        LocalDateTime after = LocalDateTime.now();
        System.out.println(now.until(after, ChronoUnit.MILLIS));

        LocalDateTime now2 = LocalDateTime.now();
        driver.get("http://www.eesti.ee");
        LocalDateTime after2 = LocalDateTime.now();
        System.out.println(now.until(after, ChronoUnit.MILLIS));
        System.out.println(now2.until(after2, ChronoUnit.MILLIS));
        System.out.println(begin.until(LocalDateTime.now(), ChronoUnit.MILLIS));
    }
}
