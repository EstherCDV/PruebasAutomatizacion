package pages;

import locators.HomePageLocator;
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
}
