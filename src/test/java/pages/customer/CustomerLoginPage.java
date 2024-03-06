package pages.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage {
    public CustomerLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    public void customerLogin(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        loginButton.click();

    }
}
