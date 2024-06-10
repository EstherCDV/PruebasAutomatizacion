package pages;

import locators.OrderCompletedPageLocator;
import org.openqa.selenium.WebDriver;

public class OrderCompletedPage {
    private WebDriver driver;

    OrderCompletedPageLocator locator;

    public OrderCompletedPage(WebDriver driver) {
        this.driver = driver;
        locator = new OrderCompletedPageLocator(driver);
    }

    public String getTitle() {
        return locator.getTitlePage().getText();
    }
}
