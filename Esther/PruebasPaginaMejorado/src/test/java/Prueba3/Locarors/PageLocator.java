package Prueba3.Locarors;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageLocator {
    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement userText;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "inventory_container")
    private WebElement inventoryContainer;

    @FindBy(css = ".inventory_item_img img")
    private List<WebElement> images;

    public PageLocator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getUserText() {
        return userText;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getInventoryContainer() {
        return inventoryContainer;
    }

    public List<WebElement> getImages() {
        return images;
    }
}