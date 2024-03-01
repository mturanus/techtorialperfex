package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class WorkHook {
    public WebDriver driver;

    @Before//it must be imported from io.cucumber not from JUNIT****
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("perfex_login_url"));
    }

    @After
    public void tearDown(Scenario scenario){
        driver.quit();
    }
}
