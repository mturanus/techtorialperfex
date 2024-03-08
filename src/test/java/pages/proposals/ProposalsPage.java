package pages.proposals;

import org.junit.Assert;
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


    //////////////////////

    @FindBy(xpath="//input[@class='form-control input-sm']")
    WebElement searchProposalBox;

    @FindBy(xpath = "//tr[1]//td[1]//a")
    WebElement proposalId;

    @FindBy(xpath = "//tr[1]//td[2]//a")
    WebElement proposalSubject;

    @FindBy(xpath = "//tr[1]//td[7]//a")
    WebElement proposalProjectName;

    @FindBy(xpath = "//tr[1]//td[10]//span")
    WebElement proposalStatus;

    @FindBy(xpath = "//a[@aria-controls ='tab_comments']")
    WebElement comments;

    @FindBy(css = "#comment")
    WebElement commentTextArea;

    @FindBy(xpath = "//button[@onclick='add_proposal_comment();']")
    WebElement addCommentButton;

    @FindBy(xpath = "//div[@class='tw-mt-3']")
    WebElement addedComment;

    @FindBy(xpath = "//span[@class='badge total_comments']")
    WebElement countOfComment;

    @FindBy(xpath = "//button[@class ='btn btn-success dropdown-toggle']")
    WebElement convertButton;

    @FindBy(xpath = "//a[@data-template='invoice']")
    WebElement invoiceConvert;

    @FindBy(xpath = "//button//div//div//div[.='Apple LLC']")
    WebElement customerName;

    @FindBy (xpath = "//button[@class ='btn btn-primary invoice-form-submit transaction-submit']")
    WebElement saveButton;

    @FindBy(css=".invoice-status-1")
    WebElement invoiceStatus;

    @FindBy(xpath = "//div[@class='col-md-12']//h4//span[1]")// //h4//span[contains(text(),'INV')]
    WebElement invoiceHeader;

    @FindBy(xpath ="//input[@name='number']")
    WebElement invoiceNumber;


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

    public void searchProposal(String proposalName){
        searchProposalBox.sendKeys(proposalName);
    }

    public void searchedProposalDataValidation(String proposalSubject, String proposalProjectName, String proposalStatus) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(proposalSubject, BrowserUtils.getText( this.proposalSubject));
        Assert.assertEquals(proposalProjectName, BrowserUtils.getText(this.proposalProjectName));
        Assert.assertEquals(proposalStatus, BrowserUtils.getText(this.proposalStatus));

    }

    public void clickProposalId() throws InterruptedException {
        Thread.sleep(1000);
        proposalId.click();
        Thread.sleep(1000);
    }

    public void clickComments() throws InterruptedException {
        Thread.sleep(1000);
        comments.click();
    }
    public void addComment(String proposalSubject){
        commentTextArea.sendKeys(proposalSubject+" is accepted for invoice");
        addCommentButton.click();
    }

    public void validateCommentNumber(String commentNumber){
        Assert.assertEquals(BrowserUtils.getText(countOfComment), commentNumber);
    }

    public void clickConvertButton() throws InterruptedException {
        Thread.sleep(1000);
        convertButton.click();
    }
    public void selectInvoice(){
        invoiceConvert.click();
    }

    public void validateCustomerName(String customerName) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(customerName, BrowserUtils.getText(this.customerName));
    }

    public void scrollPageAndClickSaveButton(WebDriver driver){
        BrowserUtils.scrollIntoView(driver, saveButton);
        saveButton.click();
    }

    public void validateProposalStatus(String invoiceStatus){
        Assert.assertEquals(BrowserUtils.getText(this.invoiceStatus),invoiceStatus );
        Assert.assertEquals(this.invoiceStatus.getCssValue("color"),"rgba(220, 38, 38, 1)");
    }

    public void validateHeaderSameAsInvoiceNumber(String inv){
        String invoiceNumber = this.invoiceNumber.getAttribute("value");
        String expectedHeader = inv + invoiceNumber;
        Assert.assertEquals(expectedHeader, BrowserUtils.getText(invoiceHeader) );
    }

}
