package locators;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

@Getter
public class HomePageLocator {

    private WebDriver driver;


    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    private WebElement title;

//    public WebElement getTitlecustom(String title) {
//        return driver.findElement(By.xpath("//*[@id='"+title+"']/div[2]/span"));
//    }

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement addToCartProducto1;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")
    private WebElement addToCartProducto2;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    private WebElement numeroArticulosCarrito;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement botonCarrito;

    public HomePageLocator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
