package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.WebDriverManager;

public class Hook {

    @Before
    public void imprimirsaludo() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
        System.out.println("Comenzando before....");
    }

    @After
    public void closeBrowser() {
        System.out.println("Cerrando Browser after");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
        WebDriverManager.closeDriver();
    }
}
