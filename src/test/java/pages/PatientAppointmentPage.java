package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientAppointmentPage {
    public PatientAppointmentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[Contains(Text(), 'MY PAGES(PATIENT)'")
    public WebElement myPagePatient;

    @FindBy(xpath = "//*[text()='Make an']")
    public WebElement makeAnAppointment;

    @FindBy(id = "firstName")
    public WebElement firstnameBox;

    @FindBy(id = "lastName")
    public WebElement lastnameBox;

    @FindBy(id = "ssn")
    public WebElement ssnBox;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "phone")
    public WebElement phoneBox;

    @FindBy(name = "appoDate")
    public WebElement dateBox;

    @FindBy(xpath = "//*[text()='Send an Appointment Request']")
    public WebElement requestButton;


    @FindBy(xpath = "//*[text()='Appointment registration saved!']")
    public WebElement appointmentSuccessAlert;

}

