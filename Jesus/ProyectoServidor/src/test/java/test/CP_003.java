package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.UploadFilePage;
import utils.WebDriverManager;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CP_003 {
    private WebDriver driver;
    private UploadFilePage uploadFilePage;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        driver = WebDriverManager.getDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        uploadFilePage = new UploadFilePage(driver);
    }

    @Test
    public void testUploadFile() {
        File file = new File("C:\\Users\\MRROPEJM\\Downloads\\datos_personas.csv");
        String path = file.getAbsolutePath();
        String tituloArchivo = file.getName();
        uploadFilePage.botonAddFile(path);
        uploadFilePage.botomUpload();
        assertEquals(tituloArchivo,uploadFilePage.tituloUpload());
    }

    @AfterEach
    public void tearDown() {
        WebDriverManager.closeDriver();
    }
}
