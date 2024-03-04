

package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginSteps {

    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);


    @Given("User verifies the title is {string}")
    public void user_verifies_the_title_is(String expectedTitle) {
        driver.get(ConfigReader.readProperty("url"));
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
    }
    @When("User verifies log_in is visible on the page")
    public void user_verifies_log_in_is_visiable_on_the_page(){
        Assert.assertTrue(loginPage.isLoginVisible());
    }
    @When("User provides correct employee email and password, and login")
    public void user_provides_correct_employee_email_and_password_and_login() {
        loginPage.login(ConfigReader.readProperty("employee_username"),ConfigReader.readProperty("employee_password") );
    }

    @Then("User validates the title {string} from MainPage")
    public void user_validates_the_title_from_main_page(String expectedTitle)  {

        Assert.assertTrue(driver.getTitle().trim().contains(expectedTitle));
    }







}
