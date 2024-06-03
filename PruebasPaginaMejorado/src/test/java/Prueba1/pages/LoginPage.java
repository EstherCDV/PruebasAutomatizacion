package Prueba1.pages;

import Prueba1.Locarors.PageLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage {
    private WebDriver driver;

    private By userText= By.id("user-name");
    private By password= By.id("password");
    private By boton= By.id("login-button");

    private By messageError= By.className("error-message-container");

    PageLocator locator;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.locator = new PageLocator(driver);
    }

    public void enterText(String text) {
        locator.getUserText().sendKeys(text);
    }

    public void enterpass(String text) {
        locator.getPassword().sendKeys(text);
    }

    public void clickSubmitButton() {
        locator.getBotton().click();
    }

    public String getMessage() {
        return locator.getMessageError().getText();
    }
}
