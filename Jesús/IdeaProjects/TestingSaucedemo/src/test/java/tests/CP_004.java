package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.FormPage;
import pages.PaymentPage;
import utils.WebDriverManager;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CP_004 {

    private WebDriver driver;
    private FormPage formPage;
    private PaymentPage paymentPage;
    private CP_003 cp003;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        cp003 = new CP_003();
        cp003.setUp();
        cp003.testMostrarCarritoAndToPageForm();
        driver = WebDriverManager.getDriver();
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        formPage = new FormPage(driver);
        paymentPage = new PaymentPage(driver);
    }

    @Test
    public void formularioCorrecto(){
        String title = "Checkout: Overview";
        formPage.inserFirstName("Nombre");
        formPage.inserLastName("Apellido");
        formPage.insertCip("12345");
        formPage.clickContinueButton();
        assertEquals(title, paymentPage.getTitle());
    }

    @Test
    public void formularioVacio(){
        String error = "Error: First Name is required";
        formPage.inserFirstName("");
        formPage.inserLastName("");
        formPage.insertCip("");
        formPage.clickContinueButton();
        assertEquals(error,formPage.getContinueError());
    }

    @AfterEach
    public void tearDown(){
        WebDriverManager.closeDriver();
    }
}
