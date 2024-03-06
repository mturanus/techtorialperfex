package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

        @FindBy(css = "button[type='submit']")
        WebElement loginButton;

    @FindBy(xpath = "//h1")
    WebElement loginHeader;

        @FindBy(xpath = "//p[@class='text-danger alert-validation']")
        WebElement errorMessage;


    public void login(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        loginButton.click();
        System.out.println("login method"); 
    }


    public boolean isLoginVisible(){
        return loginHeader.isDisplayed();
    }

        public void errorMessageAndColor (String expectedMessage, String expectedColor){
            Assert.assertEquals(expectedMessage, BrowserUtils.getText(this.errorMessage));
            Assert.assertEquals(expectedColor, this.errorMessage.getCssValue("color"));
        }
}