package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.WebDriverManager;

import static org.junit.Assert.assertEquals;

public class CerrarMensajeEmergenteSteps {
    WebDriver driver;
    private HomePage homePage;
    String url = "https://candymapper.com/";
    String title = "CandyMapper: \nThe Website That Goes Wrong!";

    @Given("Me muestra un mensaje emergente")
    public void me_muestra_un_mensaje_emergente() {
        driver = WebDriverManager.getDriver();
        driver.get(url);
        homePage = new HomePage(driver);
        String titulo = "Popup Challenge";
        assertEquals(homePage.getTitleEmergente(),titulo);
    }

    @When("Cierro el mensaje emergente")
    public void cierro_el_mensaje_emergente() {
        homePage.clickCerrarVentanaEmergente();
    }

    @Then("Muestra la pagina principal de la web")
    public void muestra_la_web() {
        assertEquals(homePage.getTitle(), title);
    }

}
