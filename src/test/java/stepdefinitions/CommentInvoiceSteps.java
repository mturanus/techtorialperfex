package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.customer.CustomerLoginPage;
import pages.customer.CustomerMainPaige;
import pages.customer.CustomerProposalPage;
import pages.proposals.ProposalsPage;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class CommentInvoiceSteps {

    WebDriver driver = DriverHelper.getDriver();
    CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
    CustomerMainPaige customerMainPaige = new CustomerMainPaige(driver);
    ProposalsPage proposalsPage = new ProposalsPage(driver);

    @When("Search proposal name {string} from search box which is on tha top of table right corner")
    public void search_proposal_name_from_search_box_which_is_on_tha_top_of_table_right_corner(String proposalName) {
        proposalsPage.searchProposal(proposalName);
    }

    //??????????????????????
    @Then("Verify that listed proposal data")
    public void verify_that_listed_proposal_data(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> rows = dataTable.asMaps();
        Thread.sleep(1000);
        for (Map<String, String> columns : rows){
            String proposalSubject = columns.get("proposalSubject");
            String proposalProjectName = columns.get("proposalProjectName");
            String proposalStatus = columns.get("proposalStatus");
            proposalsPage.searchedProposalDataValidation(proposalSubject,proposalProjectName,proposalStatus);
        }

    }
    @When("Click associated proposal id from Proposal # column, and From new panel, click Comments tab")
    public void click_associated_proposal_id_from_proposal_column_and_from_new_panel_click_comments_tab() throws InterruptedException {
        proposalsPage.clickProposalId();
        proposalsPage.clickComments();
    }

    @When("Add comment as {string}, and Click Add Comment button.")
    public void add_comment_as_and_click_add_comment_button(String proposalSubject) {
        proposalsPage.addComment(proposalSubject);
    }

    @When("Verify that proposal comment added and that next to Comments tab there is {string} badge for total comment.")
    public void verify_that_proposal_comment_added_and_that_next_to_comments_tab_there_is_badge_for_total_comment(String numberOfComment) {
        proposalsPage.validateCommentNumber(numberOfComment);

    }

    @When("Click Convert button, and Select Invoice button from drop down menu.")
    public void click_convert_button_and_select_invoice_button_from_drop_down_menu() throws InterruptedException {
        proposalsPage.clickConvertButton();
        proposalsPage.selectInvoice();
    }

    @When("Verify that customer is {string} as default from form")
    public void verify_that_customer_is_as_default_from_form(String customer) throws InterruptedException {
        proposalsPage.validateCustomerName(customer);
    }

    @When("Scroll down page and click Save button.")
    public void scroll_down_page_and_click_save_button() {
        proposalsPage.scrollPageAndClickSaveButton(driver);
    }


    @When("Verify that there is red {string} label next to record header.")
    public void verify_that_there_is_red_label_next_to_record_header(String invoiceStatus) {
        proposalsPage.validateProposalStatus(invoiceStatus);

        //????? red ekle
    }


    @Then("Verify that record header that starts with {string} same number with Invoice Number section in the form")
    public void verify_that_record_header_that_starts_with_same_number_with_invoice_number_section_in_the_form(String inv) {
        proposalsPage.validateHeaderSameAsInvoiceNumber(inv);
    }
}
