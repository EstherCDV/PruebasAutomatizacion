import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EjercicioPropuesto {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new EdgeDriver();
        System.setProperty("webdriver.edge.driver", "src/test/resources/edgedriver_win64/msedgedriver.exe");
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void test() {
        WebElement userText = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement boton = driver.findElement(By.id("login-button"));

        userText.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        boton.click();

        WebElement product = driver.findElement(By.xpath("//*[@id=\"item_5_title_link\"]/div"));
        product.click();

        WebElement addCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart\"]"));
        WebElement carrito = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        addCart.click();
        carrito.click();

        WebElement comprar = driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
        comprar.click();

        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
        WebElement zip = driver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
        WebElement botonContinuar = driver.findElement(By.xpath("//*[@id=\"continue\"]"));

        firstName.sendKeys("Jesus");
        lastName.sendKeys("Rodriguez");
        zip.sendKeys("12345");
        botonContinuar.click();

        WebElement precioTotal = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]"));
        WebElement finalizarCompra = driver.findElement(By.xpath("//*[@id=\"finish\"]"));
        finalizarCompra.click();

        WebElement compraRealizada = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
        assertEquals(compraRealizada.getText(), "Thank you for your order!");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
