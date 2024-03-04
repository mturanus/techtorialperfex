package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
    public LoginPage2(WebDriver driver){
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


    public void login(String emailAddress,String password){
        this.emailAddress.sendKeys(emailAddress);
        this.password.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public boolean isLoginVisible(){
        return loginHeader.isDisplayed();
    }



}
