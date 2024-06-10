package locators;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class UploadFilePageLocator {
    private WebDriver driver;

    @FindBy(id = "file-upload")
    private WebElement botonAddFile;

    @FindBy(id = "file-submit")
    private WebElement botonSubmit;

    @FindBy(xpath = "//*[@id=\"uploaded-files\"]")
    private WebElement tituloUpload;


    public UploadFilePageLocator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
