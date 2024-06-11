package pages;

import locators.HomePageLocator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    HomePageLocator homePageLocator;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        homePageLocator = new HomePageLocator(driver);
    }

    public String getTitle() {
        return homePageLocator.getTitle().getText();
    }

    public void cerrapopup() {
        homePageLocator.getClosebutton().click();
    }

    public boolean isPopupClosed() {
        try {
            return !homePageLocator.getPopup().isDisplayed();
        } catch (NoSuchElementException e) {
            return true; // Si no encuentra el elemento, significa que está cerrado
        }
    }
}
