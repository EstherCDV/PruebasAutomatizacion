package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.WebDriverManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepsDefinitions {
    WebDriver driver;
    HomePage homePage = new HomePage(driver);
    String url ="https://candymapper.com/";
    String title = "CandyMapper: \nThe Website That Goes Wrong!";

    @Given("I open the browser")
    public void i_open_the_browser() {
        driver = WebDriverManager.getDriver();
    }

    @When("I navigate to CandyMapper")
    public void i_navigate_to() {
        driver.get(url);
    }

    @Then("I should see the CandyMapper homepage")
    public void i_should_see_the_candymapper_homepage() {
        assertEquals(homePage.getTitle(),title);
    }
}
