

package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.LoginPage2;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginSteps {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage2 loginPage2 = new LoginPage2(driver);


    @Given("User verifies the title is {string}")
    public void user_verifies_the_title_is(String expectedTitle) {
        driver.get(ConfigReader.readProperty("url"));
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
    }
    @When("User verifies log_in is visible on the page")
    public void user_verifies_log_in_is_visiable_on_the_page(){
        Assert.assertTrue(loginPage2.isLoginVisible());
    }
    @When("User provides correct employee email and password")
    public void user_provides_correct_employee_email_and_password(){
        loginPage2.login(ConfigReader.readProperty("employee_username"),ConfigReader.readProperty("employee_password") );
    }
    @When("User clicks login button")
    public void user_clicks_login_button(){
        loginPage2.clickLoginButton();
    }
    @Then("User validates the title {string} from MainPage")
    public void user_validates_the_title_from_main_page(String expectedTitle)  {

        Assert.assertTrue(driver.getTitle().trim().contains(expectedTitle));
    }




}
