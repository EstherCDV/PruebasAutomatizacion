package Prueba1.Locarors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLocator {
    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement userText;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="login-button")
    private WebElement boton;

    @FindBy(className="error-message-container")
    private WebElement messageError;

    public PageLocator(WebDriver Driver) {
        this.driver = Driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getUserText() {
        return userText;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getBotton() {
        return boton;
    }

    public WebElement getMessageError() {
        return messageError;
    }
}

