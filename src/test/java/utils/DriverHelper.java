package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverHelper {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
            switch (ConfigReader.readProperty("browser")) {
                case "chrome":
                    String hubURL= "http://3.84.100.166:4444";
                    ChromeOptions options = new ChromeOptions();
                    try {
                        driver=new RemoteWebDriver(new URL(hubURL),options);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
//local
//                    driver = new ChromeDriver();
//                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    ChromeOptions options1 = new ChromeOptions();
                    options1.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options1);
                    break;
//local
//                    driver = new ChromeDriver();
//                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }
}