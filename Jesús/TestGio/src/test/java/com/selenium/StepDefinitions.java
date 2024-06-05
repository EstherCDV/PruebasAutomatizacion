package com.selenium;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.After;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    private WebDriver driver;

    @Given("I open the browser")
    public void iOpenTheBrowser() {
        System.setProperty("webdrive.chrome.driver", "src/test/resources/chromedriver_win64/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @When("I navigate to google")
    public void iNavigateToGoogle() {
        driver.get("https://www.google.com");
    }

    @Then("the title should be {string}")
    public void theTitleShouldBe(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @After
    public void cleanUp() {
        if(driver != null) {
            driver.quit();
        }
    }

}