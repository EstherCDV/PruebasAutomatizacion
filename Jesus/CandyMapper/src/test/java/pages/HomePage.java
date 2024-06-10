package pages;

import locators.HomePageLocator;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    HomePageLocator locator;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        locator = new HomePageLocator(driver);
    }

    public String getTitle(){
        return locator.getTitle().getText();
    }

    public void clickCerrarVentanaEmergente(){
        locator.getCloseButton().click();
    }

    public String getTitleEmergente(){
        return locator.getTitleMsjEMergente().getText();
    }

}
