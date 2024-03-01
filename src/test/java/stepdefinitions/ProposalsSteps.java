package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.proposals.NewProposalPage;
import pages.proposals.ProposalsPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class ProposalsSteps {

    private WebDriver driver = DriverHelper.getDriver();
    private LoginPage loginPage = new LoginPage(driver);
    private MainPage mainPage = new MainPage(driver);
    private ProposalsPage proposalsPage = new ProposalsPage(driver);
    private NewProposalPage newProposalPage = new NewProposalPage(driver);

    @Given("navigate to Techtorial CRM url")
    public void navigate_to_techtorial_crm_url() {
        driver.get(ConfigReader.readProperty("url"));
    }

    @When("Enter correct employee email and password")
    public void enter_correct_employee_email_and_password() {
        loginPage.login(ConfigReader.readProperty("employee_username"),
                ConfigReader.readProperty("employee_password"));
    }

    @When("Click {string} Module from left side navigation menu")
    public void click_module_from_left_side_navigation_menu(String moduleName) {
        mainPage.selectLeftSideModule(moduleName);
    }

    @When("Click {string} module")
    public void click_module(String moduleName) {
        mainPage.selectSalesModule(moduleName);
    }

    @When("Click {string} button from top")
    public void click_button_from_top(String string) {
        proposalsPage.clickNewProposal();
    }

    @When("Fill the Subject line with {string}")
    public void fill_the_subject_line_with(String subjectName) {
        newProposalPage.fillSubject(subjectName);
    }

    @When("From Related dropdown select {string} option")
    public void from_dropdown_select_option(String relatedName) {
        newProposalPage.selectRelated(relatedName);
    }

    @When("Go to Customer filter and type {string} then select {string} option from results")
    public void go_to_filter_and_type_then_select_option_from_results(String userInput, String customerName) {
        newProposalPage.selectCustomer(userInput, customerName);
    }

    @When("Go to Project filter and type {string} then select {string}")
    public void go_to_filter_and_type_then_select(String userInput, String projectName) {
        newProposalPage.selectProject(userInput, projectName);
    }

    @When("Click Add Item button and select Asus Monitor items from drop down list: {string}")
    public void click_button_and_select_following_items_from_drop_down_list_asus_monitor(String item) {
        newProposalPage.selectItem(item);
    }

    @When("There is a blue check button next to auto filled item. Click blue check button to add item")
    public void there_is_a_blue_check_button_next_to_auto_filled_item_click_blue_check_button_to_add_item() {
        newProposalPage.clickCheckButton();
    }

    @When("Click Add Item button and select Ethernet Cable items from drop down list: {string}")
    public void click_button_and_select_following_items_from_drop_down_list_ethernet_cable(String item) {
        newProposalPage.selectItem(item);
    }

    @When("Change Qty of Ethernet Cable and type {string}")
    public void change_qty_of_ethernet_cable_and_type(String quantity) {
        newProposalPage.changeCableQuantity(quantity);
    }

    @When("Click blue check button to add item")
    public void click_blue_check_button_to_add_item() {
        newProposalPage.clickCheckButton();
    }

    @Then("Verify that Total is {string}")
    public void verify_that_total_is(String total) {
        Assert.assertEquals(total, newProposalPage.getTotal());
    }

    @Then("Click Save & Send button")
    public void click_button() {
        newProposalPage.clickSaveAndSend();
    }

    @Then("Find created Proposal by clicking {string}, {string} and verify that its status is {string}")
    public void find_created_proposal_and_verify_that_its_status_is(String leftModule, String salesModule,
                                                                    String status) {
        mainPage.selectLeftSideModule(leftModule);
        mainPage.selectSalesModule(salesModule);
        Assert.assertEquals(status, proposalsPage.getStatus());
    }
}
