package locators;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class HomePageLocator {

    private WebDriver driver;

    @FindBy(id = "dynamic-tagline-111326")
    private WebElement title;

    @FindBy(xpath = "//*[@id=\"popup-widget111379\"]/div/div/div[2]/div[2]/h3")
    private WebElement titleMsjEMergente;

    @FindBy(id = "popup-widget111379-close-icon")
    private WebElement closeButton;

    public HomePageLocator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
