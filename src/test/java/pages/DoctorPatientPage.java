package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DoctorPatientPage {
    public DoctorPatientPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "entity-menu")
    public WebElement mypageDoctor;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
    public WebElement myInpatient;

    @FindBy(id = "fromDate")
    public WebElement patientAppointmentsFrom;

    @FindBy(id = "toDate")
    public WebElement patientAppoinmentsTo;

    @FindBy(xpath = "//a[@class ='btn btn-primary btn-sm']")
    public WebElement InpatientEdit;

    @FindBy(xpath = "//tr[1]/td[13]//span/span")
    public WebElement appointmentEdit;

    @FindBy(xpath = "//*[text()='Show Test Results']")
    public WebElement showTestResult;

    @FindBy(xpath = "//span[@class='d-none d-md-inline']")
    public WebElement viewResult;


    @FindBy(xpath = "//*[text()='My Inpatients']")
    public WebElement myInpatientButton;

    @FindBy(xpath = "//div[@class='btn-group flex-btn-group-container']")
    public WebElement inpatientEditButton;

    @FindBy(xpath = "//select[@id='in-patient-status']")
    public WebElement statusTab;

    @FindBy(xpath = "//select[@id='in-patient-room']")
    public WebElement roomTab;

    @FindBy(xpath = "//li[@class='dropdown show nav-item']")
    public WebElement myPagesVerification;

   @FindBy(xpath = "//div[@ class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
   public WebElement saveMassageEditPatientInfo;

    @FindBy(xpath = "//h2[@id='appointment-heading']")
    public WebElement appointmentMassage;

    @FindBy(xpath = "//span[text()='Tests']")
    public WebElement testsMassage;

    @FindBy(xpath = "//span[text()='Test Results']")
    public WebElement testResultMassage;

    @FindBy(xpath = "//table[@class='table']" )
    public WebElement patientInfo;

    @FindBy(xpath = "//*[text()='In Patients']")
    public WebElement inPatientMassage;

    @FindBy(xpath = "//*[text()='Create or edit a In Patient']")
    public WebElement createOrEditInpatientMassage;

    @FindBy(id = "save-entity")
    public WebElement saveButtonEditPatient;

    @FindBy(xpath ="//*[contains (text(),'The In Patient is updated with identifier')]")
    public WebElement roomEditMassage;

    @FindBy(xpath = "//div[contains (text(),'InPatient status can not be changed with this type of status')")
    public WebElement savePatientEditMessage;

    @FindBy(xpath = "//select[@name='room.id']")
    public WebElement patientRoomNum;

    @FindBy(xpath = "//*[text()='InPatient request already done for this appointment']")
    public WebElement CurrentPatientAlert;

    @FindBy(xpath = "//div[text()='InPatient request already done for this appointment']")
    public WebElement inpatientMessage;

    @FindBy(xpath = "//div[text()='A new In Patient is created with identifier']")
    public WebElement inpatientSuccessfulMessage;
}


