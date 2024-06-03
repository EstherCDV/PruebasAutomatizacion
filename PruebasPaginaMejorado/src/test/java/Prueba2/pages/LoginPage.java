package Prueba2.pages;

import Prueba2.Locarors.PageLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoginPage {
    private WebDriver driver;
    private PageLocator locator;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.locator = new PageLocator(driver);
    }

    public void login(String username, String password) {
        locator.getUserText().sendKeys(username);
        locator.getPassword().sendKeys(password);
        locator.getLoginButton().click();
    }

    public boolean isLoginSuccessful() {
        try {
            return locator.getInventoryContainer().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}