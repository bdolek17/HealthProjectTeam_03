package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientAppointmentPage {
    public PatientAppointmentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name="ssn")
    public WebElement inputSsn;

    @FindBy(xpath = "//span[.='Show Appointments']")
    public WebElement btnAppointments;

    @FindBy(xpath = "//span[.='Edit']")
    public WebElement linkEdit;

    @FindBy(xpath = "//input[@name='id']")
    public WebElement idPatient;

    @FindBy(xpath = "//input[@name='startDate']")
    public WebElement startDateTime;

    @FindBy(xpath = "//input[@name='endDate']")
    public WebElement endDateTime;

    @FindBy(xpath = "//select[@name='status']")
    public WebElement appointmentStatusDropdown;

    @FindBy(xpath = "//select[@id='appointment-physician']")
    public WebElement selectPhysician;

    @FindBy(xpath = "//span[.='Save']")
    public WebElement clickBtnSave;

    @FindBy(xpath = "//span[.='Show Tests']")
    public WebElement showTestbtn;

    @FindBy(xpath = "//span[@class='d-none d-md-inline']")
    public WebElement viewResult;
}