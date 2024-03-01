package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#email")
    WebElement email;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-block']")
    WebElement loginButton;
    @FindBy(className = "menu-item-sales")
    WebElement salesButton;
    @FindBy(className = "sub-menu-item-proposals")
    WebElement proposalsButton;

    @FindBy(className = "sub-menu-item-estimates")
    WebElement estimatesButton;

    @FindBy(className = "sub-menu-item-invoices")
    WebElement invoicesButton;

    @FindBy(className = "sub-menu-item-payments")
    WebElement paymentsButton;

    @FindBy(className = "sub-menu-item-credit_notes")
    WebElement creditNotesButton;

    @FindBy(className = "sub-menu-item-items")
    WebElement itemsButton;

    public void validateSubmodules(String Proposals, String Estimates, String
            Invoices, String Payments, String CreditNotes, String Items) {


    }

        public  void login(String email, String password) {
            this.email.sendKeys(email);
            this.password.sendKeys(password);
            loginButton.click();
        }
        public void validateSalesButton(String Sales){
            salesButton.click();


    }

}
