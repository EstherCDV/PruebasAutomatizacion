package locators;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class FormPageLocator {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    private WebElement title;

    @FindBy(xpath = "//*[@id=\"first-name\"]")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id=\"last-name\"]")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id=\"postal-code\"]")
    private WebElement postalCode;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3")
    private WebElement checkoutError;

    public FormPageLocator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
