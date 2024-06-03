package pages;

import locators.YourCardPageLocator;
import org.openqa.selenium.WebDriver;

public class YourCardPage {
    private WebDriver driver;

    YourCardPageLocator locator;

    public YourCardPage(WebDriver driver) {
        this.driver = driver;
        locator = new YourCardPageLocator(driver);
    }

    public String getYourCardTitle() {
        return locator.getTitle().getText();
    }

    public void clickYourCardButton() {
        locator.getCheckout().click();
    }
}
