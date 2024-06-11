package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLocator {
    private WebDriver driver;

    @FindBy(id="dynamic-tagline-111326")
    private WebElement title;

    @FindBy(id="popup-widget111379-close-icon")
    private WebElement closebutton;

    @FindBy(id="layout-76352-d-1-c-54-a-1-4246-842-d-f-836-e-821472-d") // Asegúrate de que este sea el ID correcto del popup
    private WebElement popup;

    public HomePageLocator(WebDriver Driver) {
        this.driver = Driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getClosebutton() {
        return closebutton;
    }

    public WebElement getPopup() {
        return popup;
    }
}
