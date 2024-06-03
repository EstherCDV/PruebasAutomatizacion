import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebaTresChrome {

    private static final Logger logger = LogManager.getLogger(PruebaLog.class);
    WebDriver driver;

    @BeforeEach
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver-win64-actu/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("goog:loggingPrefs", Map.of(
                LogType.BROWSER, Level.ALL,
                LogType.DRIVER, Level.ALL,
                LogType.CLIENT, Level.ALL
        ));
        options.setExperimentalOption("prefs", prefs);
        try {
            driver = new ChromeDriver(options);
        }catch(Exception e) {
            logger.error("Error al cargar el driver: ",e);
        }
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @Test
    public void testUno() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("my-text")));
        element.sendKeys("Selenium");

        WebElement textBox = null;
        try {
            textBox = driver.findElement(By.name("my-text"));
        }catch (Exception e) {
            logger.error(e);
        }
        WebElement button = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("SeleniumUno");
        button.click();

        WebElement message = driver.findElement(By.id("message"));
        assertEquals("Received!", message.getText());

        try {
            WebElement elementoInexistente = driver.findElement(By.id("elemento-inexistente"));
            elementoInexistente.click();
        } catch (Exception e) {
            logger.error("Error al intentar interactuar con un elemento inexistente: ", e);
        }

        try {
            driver.switchTo().alert();
        } catch (Exception e) {
            logger.error("Error al intentar interactuar con un alert inexistente: ",e);
        }

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
    }

    @Test
    public void testDos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("my-text")));
        element.sendKeys("Selenium");

        WebElement textBox = null;
        try {
            textBox = driver.findElement(By.name("my-text"));
        }catch (Exception e) {
            logger.error(e);
        }
        WebElement button = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("SeleniumUno");
        button.click();

        WebElement message = driver.findElement(By.id("message"));
        assertEquals("Received!", message.getText());

        try {
            WebElement elementoInexistente = driver.findElement(By.id("elemento-inexistente-2"));
            elementoInexistente.click();
        } catch (Exception e) {
            logger.error("Error al intentar interactuar con un elemento inexistente 2: ", e);
        }

        try {
            driver.switchTo().alert();
        } catch (Exception e) {
            logger.error("Error al intentar interactuar con un alert inexistente 2: ",e);
        }

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
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}
