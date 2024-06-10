import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PruebaDos {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "src/test/resources/edgedriver_win64/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        driver.getTitle();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement button = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
        element.getText();

        driver.quit();
    }
}
