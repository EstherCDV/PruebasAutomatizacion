package Prueba2.tests;

import Prueba2.pages.HomePage;
import Prueba2.utils.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LoginTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        driver = WebDriverManager.getDriver();
        driver.get("https://www.saucedemo.com/");
        homePage = new HomePage(driver);
    }

    @Test
    public void testLoginCorrecto() {
        homePage.login("problem_user", "secret_sauce");
        assertTrue(homePage.isLoginSuccessful(), "El login no fue exitoso");
    }

    @Test
    public void testDuplicateImages() {
        homePage.login("problem_user", "secret_sauce");
        assertTrue(homePage.isLoginSuccessful(), "El login no fue exitoso");
        assertFalse(homePage.areThereDuplicateImages(), "Hay imágenes duplicadas");
    }

    @AfterEach
    public void tearDown() {
        WebDriverManager.closeDriver();
    }
}
