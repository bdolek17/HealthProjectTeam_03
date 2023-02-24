package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientsPage {
    public PatientsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='MY PAGES(PATIENT)']")
    public WebElement myPages;

    @FindBy(xpath = "//span[.='Make an Appointment']")
    public WebElement makeApp;
}


