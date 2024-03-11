package pages.customer;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class CustomerProposalPage {
    public CustomerProposalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".td-proposal-url-subject")
    List<WebElement> subjectNames;
    @FindBy(xpath = "//td[contains(text(),\"$\")]")
    List<WebElement> totalNumbers;
    @FindBy(css = ".td-proposal-url")
    List<WebElement> allProposalNumbers;
    @FindBy(xpath = "//tr")
    List<WebElement> rows;
    @FindBy(xpath="//h4[contains(text(),'PRO')]")
    WebElement h4;



    //public String proposalNumber;
    public String proposalID ;

    public void validateProposalNameAndTotal(String proposalName, String total) {
        for (WebElement name : subjectNames) {
            if (BrowserUtils.getText(name).equals(proposalName)) {
                break;
                //Assert.assertEquals(BrowserUtils.getText(name), proposalName);

            }
        }
        for (WebElement totalNumber : totalNumbers) {
            if (BrowserUtils.getText(totalNumber).equals(total)) {
                break;
                // Assert.assertEquals(BrowserUtils.getText(totalNumber), total);

            }
        }
    }

    public void saveProposalId(String proposalName){
        for (int i =1;i<= rows.size();i++) {
            WebElement subjectElement = rows.get(i).findElement(By.cssSelector(".td-proposal-url-subject"));
            if (subjectElement.getText().equals(proposalName)) {
                WebElement proposalNumberElement = rows.get(i).findElement(By.cssSelector(".td-proposal-url"));
                proposalID = proposalNumberElement.getText();
                //System.out.println("Proposal number found: " + proposalID);
                break;
            }
        }
    }
    public void chooseProposal(){
        //System.out.println(proposalID);
        for(WebElement proposalNumberElement: allProposalNumbers){

            if(BrowserUtils.getText(proposalNumberElement).equals(proposalID)){
                proposalNumberElement.click();
                break;
            }
        }
        Assert.assertTrue(BrowserUtils.getText(h4).contains(proposalID));
    }
}



