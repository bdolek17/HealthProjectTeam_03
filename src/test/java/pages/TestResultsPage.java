package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestResultsPage {
    public TestResultsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@role='alert' and contains(text(),'A Test Result is updated with identifier')]")
    public WebElement savedMassageForTestResult;
}
