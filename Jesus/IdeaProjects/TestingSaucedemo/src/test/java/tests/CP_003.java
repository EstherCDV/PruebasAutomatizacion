package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.FormPage;
import pages.HomePage;
import pages.YourCardPage;
import utils.WebDriverManager;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CP_003 {

    private WebDriver driver;
    private HomePage homepage;
    private YourCardPage cardPage;
    private FormPage formPage;
    private CP_002 cp002;

    @BeforeEach
    public void setUp() throws MalformedURLException {
      cp002 = new CP_002();
      cp002.setUp();
      cp002.testAddProduct();
      driver = WebDriverManager.getDriver();
      driver.get("https://www.saucedemo.com/inventory.html");
      homepage = new HomePage(driver);
      cardPage = new YourCardPage(driver);
      formPage = new FormPage(driver);
    }

    @Test
    public void testMostrarCarritoAndToPageForm() {
        String title = "Your Cart";
        String titleForm = "Checkout: Your Information";
        homepage.clickToCard();
        assertEquals(title,cardPage.getYourCardTitle());
        cardPage.clickYourCardButton();
        assertEquals(titleForm, formPage.getFormPageTitle());
    }

    @AfterEach
    public void tearDown(){
        WebDriverManager.closeDriver();
    }
}
