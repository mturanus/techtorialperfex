package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DeleteProposalPage;
import pages.customer.CustomerIndividualProposalPage;
import pages.customer.CustomerLoginPage;
import pages.customer.CustomerMainPaige;
import pages.customer.CustomerProposalPage;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class CustomerProposalsSteps {
    private WebDriver driver = DriverHelper.getDriver();
    private CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
    private CustomerMainPaige customerMainPaige = new CustomerMainPaige(driver);
    private CustomerProposalPage customerProposalPage = new CustomerProposalPage(driver);
    private CustomerIndividualProposalPage customerIndividualProposalPage = new CustomerIndividualProposalPage(driver);

    private DeleteProposalPage deleteProposalPage = new DeleteProposalPage(driver);
    @Given("Customer navigates to Techtorial CRM url")
    public void customer_navigates_to_techtorial_crm_url() {
        driver.get(ConfigReader.readProperty("customer_url"));

    }
    @Given("Customer enters valid email and password")
    public void customer_enters_valid_email_and_password() {
        customerLoginPage.customerLogin(ConfigReader.readProperty("customer_username"),
                ConfigReader.readProperty("customer_password") );

    }
    @Then("Customer validates the page title {string}")
    public void customer_validates_the_page_title(String title) {
        customerMainPaige.titleValidation(driver,title);

    }
    @When("Customer clicks Proposals menu from top navigation bar")
    public void customer_clicks_proposals_menu_from_top_navigation_bar() {
        customerMainPaige.clickProposals();

    }
    @Then("Customer validates that proposal {string} is on the list and total is {string}")
    public void customer_validates_that_proposal_is_in_the_list_and_total_is(String proposalName, String total) {
        customerProposalPage.validateProposalNameAndTotal(proposalName,total);

    }
    @When("Customer gets the proposal number from {string} and saves it to proposal_id")
    public void customer_gets_the_proposal_from_and_saves_it_to(String proposalName) {
        customerProposalPage.saveProposalId(proposalName);


    }
    @When("Customer clicks on the proposal from the table and validates proposal_id matches h4 header")
    public void customer_clicks_on_the_proposal_from_the_table() {
        customerProposalPage.chooseProposal();

    }
    @Then("Customer validates proposal data")
    public void customer_validates_proposal_data(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps();
        for (Map<String, String> columns : rows){
            String pageTitle = columns.get("page_title");
            String item1 = columns.get("item1");
            String item2 = columns.get("item2");
            String acceptBtn = columns.get("button");
            customerIndividualProposalPage.proposalDataValidation(pageTitle, item1, item2, acceptBtn);
        }

        }


    @When("Customer clicks Accept and Sign buttons")
    public void customer_clicks_accept_and_buttons() {
        customerIndividualProposalPage.clickAcceptSignBtn();

    }
    @Then("Customer validates red signature error message {string}")
    public void customer_validates_red_signature_error_message(String errorMsg) {
        customerIndividualProposalPage.errorValidation(errorMsg);

    }
    @When("Customer draws a signature in canvas and clicks Sign")
    public void customer_draws_a_signature_in_canvas_and_clicks() {

        customerIndividualProposalPage.sign(driver);

    }
    @Then("Customer validates status label {string} with green background")
    public void customer_validates_status_label_with_green_background(String msg) {
        customerIndividualProposalPage.acceptedMsgValidation(msg);

    }
    @When("Click first Proposal number, More button, Delete and press OK in the confirmation pop up")
    public void click_first_proposal_number_more_button_and_delete() {
        deleteProposalPage.deleteProposal(driver);

    }
}
