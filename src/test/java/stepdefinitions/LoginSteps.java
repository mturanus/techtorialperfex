package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginSteps{
WebDriver driver=DriverHelper.getDriver();
LoginPage loginPage=new LoginPage(driver);

    @Given("User verifies the title is {string}")
    public void user_verifies_the_title_is(String expectedTitle) {
        driver.get(ConfigReader.readProperty("url"));
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
    }
    @When("User verifies log_in is visible on the page")
    public void user_verifies_log_in_is_visiable_on_the_page(){
        Assert.assertTrue(loginPage.isLoginVisible());
    }
    @Then("User validates the title {string} from MainPage")
    public void user_validates_the_title_from_main_page(String expectedTitle)  {

        Assert.assertTrue(driver.getTitle().trim().contains(expectedTitle));
    }


    @When("User provides wrong credentials as {string}  and {string} to the loginPage")
    public void user_provides_wrong_credentials_as_and_to_the_login_page(String email, String password) {
        this.loginPage.login(email, password);
        //loginPage.login(ConfigReader.readProperty("email"),ConfigReader.readProperty("password");

    }

    @Then("User validates {string} and {string} from loginPage")
    public void user_validates_and_from_login_page(String errorMessage, String expectedColor) {
        this.loginPage.errorMessageAndColor(errorMessage, expectedColor);
    //Assert.assertTrue(driver.getTittle().trim().contains(expectedTitle));
    }





}










