package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class Hooks {

    public WebDriver driver;

    @Before
    public void setup() {
        driver = DriverHelper.getDriver();
    }

    @After
    public void tearDown(){
        // BrowserUtils.getScreenshot(driver, "techtorial-perfex");
      //  driver.quit();
    }
}
