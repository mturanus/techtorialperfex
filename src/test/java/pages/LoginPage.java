package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#email")
    WebElement emailAddress;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(xpath = "//h1")
    WebElement loginHeader;
    @FindBy(css = ".btn-block")
    WebElement loginButton;

    public boolean isLoginVisible(){
        return loginButton.isDisplayed();
    }
    public void login(String emailAddress,String password){
        this.emailAddress.sendKeys(emailAddress);
        this.password.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void t(){

    }


}
