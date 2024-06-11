package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLocator {
    private WebDriver driver;

    @FindBy(id="dynamic-tagline-111326")
    private WebElement title;

    public HomePageLocator(WebDriver Driver) {
        this.driver = Driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getTitle() {
        return title;
    }

}
