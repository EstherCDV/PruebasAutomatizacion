package pages;

import locators.FormPageLocator;
import org.openqa.selenium.WebDriver;

public class FormPage {
    private WebDriver driver;

    FormPageLocator locator;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        locator = new FormPageLocator(driver);
    }

    public String getFormPageTitle() {
        return locator.getTitle().getText();
    }
    public void inserFirstName(String firstName) {
        locator.getFirstName().sendKeys(firstName);
    }
    public void inserLastName(String lastName) {
        locator.getLastName().sendKeys(lastName);
    }
    public void insertCip(String cip) {
        locator.getPostalCode().sendKeys(cip);
    }
    public void clickContinueButton() {
        locator.getContinueButton().click();
    }
    public String getContinueError(){
        return locator.getCheckoutError().getText();
    }
}
