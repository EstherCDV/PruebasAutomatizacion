package pages;

import locators.PaymentPageLocator;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    private WebDriver driver;

    PaymentPageLocator locator;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        locator = new PaymentPageLocator(driver);
    }

    public String getTitle() {
        return locator.getPaymentPageTitle().getText();
    }
    public void clickPaymentButton() {
        locator.getFinishButton().click();
    }
}
