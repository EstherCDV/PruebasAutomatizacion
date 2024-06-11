import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class PruebaLog {

    private static final Logger logger = LogManager.getLogger(PruebaLog.class);

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver-win64-actu/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("goog:loggingPrefs", Map.of(
                LogType.BROWSER, Level.ALL,
                LogType.DRIVER, Level.ALL,
                LogType.CLIENT, Level.ALL
        ));
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

            WebElement titulo = driver.findElement(By.className("display-6"));
            System.out.println(titulo.getText());

            LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
            for (LogEntry entry : browserLogs) {
                logger.info(String.format("Browser log: %s - %s - %d", entry.getLevel(), entry.getMessage(), entry.getTimestamp()));
            }

            LogEntries driverLogs = driver.manage().logs().get(LogType.DRIVER);
            for (LogEntry entry : driverLogs) {
                logger.info(String.format("Driver log: %s - %s - %d", entry.getLevel(), entry.getMessage(), entry.getTimestamp()));
            }

            LogEntries clientLogs = driver.manage().logs().get(LogType.CLIENT);
            for (LogEntry entry : clientLogs) {
                logger.info(String.format("Client log: %s - %s - %d", entry.getLevel(), entry.getMessage(), entry.getTimestamp()));
            }
        } finally {
            driver.quit();
        }
    }
}
