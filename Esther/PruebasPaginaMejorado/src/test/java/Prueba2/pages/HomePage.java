package Prueba2.pages;

import Prueba2.Locarors.PageLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomePage {
    private WebDriver driver;
    private PageLocator locator;

    public HomePage(WebDriver Driver) {
        this.driver = Driver;
        this.locator = new PageLocator(driver);
    }

    public void login(String username, String password) {
        locator.getUserText().sendKeys(username);
        locator.getPassword().sendKeys(password);
        locator.getLoginButton().click();
    }

    public boolean isLoginSuccessful() {
        try {
            return locator.getInventoryContainer().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean areThereDuplicateImages() {
        List<WebElement> images = locator.getImages();
        Set<String> imageUrls = new HashSet<>();
        boolean duplicatesFound = false;

        System.out.println("Total de imágenes encontradas: " + images.size());

        for (WebElement img : images) {
            String src = img.getAttribute("src");
            System.out.println("URL de la imagen: " + src);
            if (!imageUrls.add(src)) {
                System.out.println("Duplicate image found with URL: " + src);
                duplicatesFound = true;
            }
        }
        return duplicatesFound;
    }
}