package pages;

import locators.UploadFilePageLocator;
import org.openqa.selenium.WebDriver;

public class UploadFilePage {
    private WebDriver driver;

    UploadFilePageLocator locator;

    public UploadFilePage(WebDriver driver) {
        this.driver = driver;
        locator = new UploadFilePageLocator(driver);
    }

    public void botonAddFile(String path) {
        locator.getBotonAddFile().sendKeys(path);
    }

    public void botomUpload(){
        locator.getBotonSubmit().click();
    }

    public String tituloUpload(){
        return locator.getTituloUpload().getText();
    }
}
