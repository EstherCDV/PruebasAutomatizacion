package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_win64/chromedriver.exe");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
