import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prueba {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        Logger logger = Logger.getLogger("org.openqa.selenium.test");
        logger.setLevel(Level.ALL);
        Arrays.stream(logger.getHandlers()).forEach(handler -> {handler.setLevel(Level.ALL);});
        Handler handler = new FileHandler("logsSelenium.xml");
        logger.addHandler(handler);

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        driver.getTitle();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement titutlo = driver.findElement(By.className("display-6"));
//        try {
//            WebElement titutlo = driver.findElement(By.className("display-65"));
//        }catch (Exception e) {
//            driver.quit();
//        }

        driver.quit();
    }
}
