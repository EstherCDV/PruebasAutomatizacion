package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "src/test/resources/edgedriver_win64/msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        driver.get("https://www.saucedemo.com/");


        WebElement userText = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement boton = driver.findElement(By.id("login-button"));

        userText.sendKeys("locked_out_user");
        password.sendKeys("secret_sauce");
        boton.click();

        WebElement messageError = driver.findElement(By.className("error-message-container"));

        String errorMessageText = messageError.getText();
        System.out.println("Error message: " + errorMessageText);

    }


}