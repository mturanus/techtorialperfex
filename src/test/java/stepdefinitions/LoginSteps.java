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


    @Given("User validates the title is {string} from MainPage")
    public void user_validates_the_title_is_from_main_page(String expectedTitle) {
        driver.get(ConfigReader.readProperty("url"));
        Assert.assertEquals(expectedTitle, driver.getTitle().trim());

    }

    @Given("User validates the log_in is visible on the page")
    public void user_validates_the_log_in_is_visible_on_the_page() {
        Assert.assertTrue(this.loginPage.isLoginVisible());

    }

    @When("User provides wrong credentials as {string}  and {string} to the loginPage")
    public void user_provides_wrong_credentials_as_and_to_the_login_page(String email, String password) {
        this.loginPage.login(email, password);
        //loginPage.login(ConfigReader.readProperty("email"),ConfigReader.readProperty("password");

    }
     @When("User clicks login button")
     public void user_clicks_login_button(){
        loginPage.clickLoginButton();
     }


    @Then("User validates {string} and {string} from loginPage")
    public void user_validates_and_from_login_page(String errorMessage, String expectedColor) {
        this.loginPage.errorMessageAndColor(errorMessage, expectedColor);
    //Assert.assertTrue(driver.getTittle().trim().contains(expectedTitle));
    }





}










