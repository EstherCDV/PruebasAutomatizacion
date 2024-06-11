package Prueba3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//Prueba para la comprobacion de que las imagenes esten correctas
public class Prueba3 {

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "src/test/resources/edgedriver_win64/msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        try {
            driver.get("https://www.saucedemo.com/");

            WebElement userText = driver.findElement(By.id("user-name"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement boton = driver.findElement(By.id("login-button"));

            userText.sendKeys("problem_user");
            password.sendKeys("secret_sauce");
            boton.click();

            Map<String, String> correctImageUrls = new HashMap<>();
            correctImageUrls.put("Sauce Labs Backpack", "/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg");
            correctImageUrls.put("Sauce Labs Bike Light", "/static/media/bike-light-1200x1500.37c843b0.jpg");
            correctImageUrls.put("Sauce Labs Bolt T-Shirt", "/static/media/bolt-shirt-1200x1500.c2599ac5.jpg");
            correctImageUrls.put("Sauce Labs Fleece Jacket", "/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg");
            correctImageUrls.put("Sauce Labs Onesie", "/static/media/red-onesie-1200x1500.2ec615b2.jpg");
            correctImageUrls.put("Test.allTheThings() T-Shirt (Red)", "/static/media/red-tatt-1200x1500.30dadef4.jpg");

            List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item"));

            for (WebElement item : items) {
                String itemName = item.findElement(By.cssSelector(".inventory_item_name")).getText();
                String itemImageUrl = item.findElement(By.cssSelector(".inventory_item_img img")).getAttribute("src");

                String expectedImageUrl = correctImageUrls.get(itemName);

                if (expectedImageUrl != null && !itemImageUrl.endsWith(expectedImageUrl)) {
                    System.out.println("Incorrect image for item: " + itemName + ". Expected: " + expectedImageUrl + ", but found: " + itemImageUrl);
                } else {
                    System.out.println("Correct image for item: " + itemName);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }



    }

}
