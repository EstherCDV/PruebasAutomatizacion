package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.WebDriverManager;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertEquals;

public class AbrirNavegadorSteps {
    WebDriver driver;
    private HomePage homePage;
    String url = "https://candymapper.com/";
    String title = "CandyMapper: \nThe Website That Goes Wrong!";

//    @Before
//    public void imprimirsaludo() {
//        try {
//            Thread.sleep(5000);
//        } catch (Exception e) {
//
//        }
//        System.out.println("Comenzando before....");
//    }

    @Given("Tengo una pagina web")
    public void abrirPaginaWeb() {
        driver = WebDriverManager.getDriver();
    }

    @When("Abro pagina web")
    public void abrorPaginaWeb() {
        driver.get(url);
        homePage = new HomePage(driver);
    }

    @Then("La pagina web se ha abierto")
    public void laWebSeHaAbierto() {
        assertEquals(homePage.getTitle(), title);
    }

//    @After
//    public void closeBrowser() {
//        System.out.println("Cerrando Browser after");
//        try {
//            Thread.sleep(5000);
//        } catch (Exception e) {
//
//        }
//        WebDriverManager.closeDriver();
//    }
}
