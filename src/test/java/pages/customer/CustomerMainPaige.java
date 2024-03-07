package pages.customer;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerMainPaige {
    public CustomerMainPaige(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(partialLinkText ="Proposals")
    WebElement proposalsMenu;
    public void titleValidation(WebDriver driver, String title){

        Assert.assertEquals(title,driver.getTitle());
    }
    public void clickProposals(){
        proposalsMenu.click();
    }
}
