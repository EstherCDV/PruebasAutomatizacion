package locators;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class PaymentPageLocator {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    private WebElement paymentPageTitle;

    @FindBy(xpath = "//*[@id=\"finish\"]")
    private WebElement finishButton;

    public PaymentPageLocator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
