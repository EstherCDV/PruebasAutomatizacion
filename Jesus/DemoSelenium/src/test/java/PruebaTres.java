import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebaTres {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new EdgeDriver();
        System.setProperty("webdriver.edge.driver", "src/test/resources/edgedriver_win64/msedgedriver.exe");
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }
    @Test
    public void testUno() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("my-text")));
        element.sendKeys("Selenium");

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement button = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("SeleniumUno");
        button.click();

        WebElement message = driver.findElement(By.id("message"));
        assertEquals("Received!", message.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
