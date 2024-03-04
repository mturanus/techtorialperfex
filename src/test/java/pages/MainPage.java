package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".menu-text")
    private List<WebElement> leftSideModules;

    @FindBy(xpath = "//ul[@class='nav nav-second-level collapse in']//li")
    private List<WebElement> salesModules;

    public void selectLeftSideModule(String moduleName) {
        for (WebElement module : leftSideModules) {
            if (BrowserUtils.getText(module).equals(moduleName)) {
                module.click();
                break;
            }
        }
    }

    public void selectSalesModule(String moduleName) {
        for (WebElement module : salesModules) {
            if (BrowserUtils.getText(module).equals(moduleName)) {
                module.click();
                break;
            }
        }
    }
}
