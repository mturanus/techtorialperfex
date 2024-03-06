package pages.customer;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class CustomerIndividualProposalPage {
    public CustomerIndividualProposalPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css=".proposal-html-subject")
    WebElement pageTitle;

    @FindBy(xpath="//strong")
    List <WebElement> allItems;

    @FindBy(css="#accept_action")
    WebElement acceptBtn;
    @FindBy(xpath="//button[contains(text(),'Sign')]")
    WebElement signBtn;
    @FindBy(xpath="//p[contains(text(),'Please sign')]")
    WebElement errorMsg;
    @FindBy(xpath="//canvas[@id='signature']")
    WebElement signatureCanvas;
    @FindBy(xpath="//span[contains(text(),'Accepted')]")
    WebElement acceptedMsg;



public void proposalDataValidation(String pageTitle, String item1, String item2, String acceptBtn){
    Assert.assertEquals(BrowserUtils.getText(this.pageTitle),pageTitle);
    Assert.assertEquals(BrowserUtils.getText(allItems.get(0)),item1);
    Assert.assertEquals(BrowserUtils.getText(allItems.get(1)),item2);
    Assert.assertEquals(BrowserUtils.getText(this.acceptBtn),acceptBtn);

}
public void clickAcceptSignBtn(){
    acceptBtn.click();
    signBtn.click();
}
public void errorValidation(String errorMsg){
    Assert.assertEquals(BrowserUtils.getText(this.errorMsg),errorMsg);
    Assert.assertEquals(this.errorMsg.getCssValue("color"),"rgba(239, 68, 68, 1)");

}
public void sign(WebDriver driver){
    Actions actions = new Actions(driver);
    actions.moveToElement(signatureCanvas,10,10).clickAndHold().moveByOffset(10,10).release().perform();
    signBtn.click();

}
public void acceptedMsgValidation(String msg){
    Assert.assertEquals(BrowserUtils.getText(acceptedMsg),msg);
    Assert.assertEquals(acceptedMsg.getCssValue("color"),"rgba(22, 163, 74, 1)");

}
}
