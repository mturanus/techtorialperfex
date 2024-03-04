package pages.proposals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;
import utils.DriverHelper;

public class ProposalsPage {

    public ProposalsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(partialLinkText = "New Proposal")
    private WebElement newProposalButton;

    @FindBy(xpath = "//span[contains(text(), 'Sent')]")
    private WebElement status;

    @FindBy(name = "DataTables_Table_0_length")
    private WebElement tableLength;

    @FindBy(xpath = "(//table[@id=\'DataTables_Table_0\']//tbody/tr)[1]//span[.=\'Accepted\']")
    private WebElement acceptedText;

    public String getAcceptedText(){
        return BrowserUtils.getText(acceptedText);
    }


    public void selectListLength(String value){
        Select select=new Select(tableLength);
        select.selectByVisibleText(value);
    }


    public void clickNewProposal() {
        this.newProposalButton.click();
    }

    public String getStatus() {
        return BrowserUtils.getText(status);
    }
}
