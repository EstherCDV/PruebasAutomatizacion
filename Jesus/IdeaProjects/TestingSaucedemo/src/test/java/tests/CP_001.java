package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CP_001 {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        Logger logger = Logger.getLogger("org.openqa.selenium.test");
        logger.setLevel(Level.ALL);
        Arrays.stream(logger.getHandlers()).forEach(handler -> {handler.setLevel(Level.ALL);});
        driver = WebDriverManager.getDriver();
        System.out.println("setUp");
//        URL homePageURL = new URL("https://www.saucedemo.com/");
//        driver.get(homePageURL.toString());
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void testLoginCorrect(){
        System.out.println("testLoginCorrect");
        loginPage.username("standard_user");
        loginPage.password("secret_sauce");
        loginPage.clickLoginButton();
        assertEquals("Products", homePage.getTitle());
    }

    @Test
    public void testLoginIncorrect(){
        System.out.println("testLoginIncorrect");
        String mensaje = "Epic sadface: Username and password do not match any user in this service";
        loginPage.username("standard_user1234");
        loginPage.password("secret_sauce1234");
        loginPage.clickLoginButton();
        assertEquals(mensaje, loginPage.messageError());
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        System.out.println("tearDowm");
        WebDriverManager.closeDriver();
    }
}
