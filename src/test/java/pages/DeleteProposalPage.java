package pages;

import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DeleteProposalPage {
    public DeleteProposalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'PRO')]")
    List<WebElement> proposalNumbers;
    @FindBy(xpath = "//button[contains(text(),'More')]")
    WebElement moreDropdown;
    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    WebElement delete;

    public void deleteProposal(WebDriver driver) {
        proposalNumbers.get(0).click();
        moreDropdown.click();
        delete.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();


    }


}
