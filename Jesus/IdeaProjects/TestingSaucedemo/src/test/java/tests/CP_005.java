package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.OrderCompletedPage;
import pages.PaymentPage;
import utils.WebDriverManager;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CP_005 {
    private WebDriver driver;
    private PaymentPage paymentPage;
    private OrderCompletedPage orderCompletedPage;
    private CP_004 cp004;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        cp004 = new CP_004();
        cp004.setUp();
        cp004.formularioCorrecto();
        driver = WebDriverManager.getDriver();
        driver.get("https://www.saucedemo.com/checkout-step-two.html");
        paymentPage = new PaymentPage(driver);
        orderCompletedPage = new OrderCompletedPage(driver);
    }

    @Test
    public void verificarCompra() {
       String title = "Checkout: Complete!";
       paymentPage.clickPaymentButton();
       assertEquals(title, orderCompletedPage.getTitle());
    }

    @AfterEach
    public void tearDown(){
        WebDriverManager.closeDriver();
    }
}
