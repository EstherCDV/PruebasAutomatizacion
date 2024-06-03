package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.WebDriverManager;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CP_002 {
    private WebDriver driver;
    private HomePage homePage;
    private CP_001 cp001;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        cp001 = new CP_001();
        cp001.setUp();
        cp001.testLoginCorrect();
        driver = WebDriverManager.getDriver();
        driver.get("https://www.saucedemo.com/inventory.html");
        homePage = new HomePage(driver);

    }

    @Test
    public void testAddProduct() {
        String numAdd = "2";
        homePage.addProductosCarrito();
        assertEquals(numAdd,homePage.numProductosEnCarrito());
    }

    @AfterEach
    public void tearDown(){
        WebDriverManager.closeDriver();
    }
}
