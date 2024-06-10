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

    public String getTitle() {
        return locator.getTitle().getText();
    }

    public void addProductosCarrito(){
        locator.getAddToCartProducto1().click();
        locator.getAddToCartProducto2().click();
    }

    public String numProductosEnCarrito(){
        return locator.getNumeroArticulosCarrito().getText();
    }

    public void clickToCard(){
        locator.getBotonCarrito().click();
    }

}
