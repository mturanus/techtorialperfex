package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class dashboardStepDef {

    WebDriver driver= DriverHelper.getDriver();
    DashboardPage dashboardPage=new DashboardPage(driver);


    @Given("navigate to Techtorial CRM url")
    public void navigate_to_techtorial_crm_url() {
        driver.get(ConfigReader.readProperty("url"));

    }

    @When("Enter correct employee email and password")
    public void enter_correct_employee_email_and_password() {
        dashboardPage.login(ConfigReader.readProperty("email"),
                ConfigReader.readProperty("password"));

    }

    @When("Click {string} Module from left side navigation menu")
    public void click_module_from_left_side_navigation_menu(String SalesButton) {
        dashboardPage.validateSalesButton(SalesButton);

        }
        @Then("User validates the submodules are displayed in this order: {string},{string},{string},{string},{string},{string}")
        public void user_validates_the_submodules_are_displayed_in_this_order (String Proposals, String Estimates, String
                Invoices, String Payments, String CreditNotes, String Items){


        }
    }
