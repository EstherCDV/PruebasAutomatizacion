package pages;


import locators.LoginPageLocator;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    LoginPageLocator locator;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        locator = new LoginPageLocator(driver);
    }

    public void username(String text){
        locator.getUsername().sendKeys(text);
    }

    public void password(String text){
        locator.getPassword().sendKeys(text);
    }

    public void clickLoginButton(){
        locator.getLoginButton().click();
    }

    public String messageError(){
        return locator.getMessage().getText();
    }
}
