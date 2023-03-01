package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientEditPage {
    public PatientEditPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='hospitalmsappfrontendApp.patient.home.createOrEditLabel']/span") //S.A.
    public WebElement labelCreateOrEditFormHeader;

    @FindBy(id="patient-id") //S.A.
    public WebElement inputId;

    @FindBy(id="patient-firstName") //S.A.
    public WebElement inputFirstname;

    @FindBy(id="patient-lastName") //S.A.
    public WebElement inputLastname;

    @FindBy(id="patient-birthDate") //S.A.
    public WebElement inputBirthDate;

    @FindBy(name="email") //S.A.
    public WebElement inputEmail;

    @FindBy(id="patient-phone") //S.A.
    public WebElement inputPhone;

    @FindBy(id="patient-gender") //S.A.
    public WebElement selectGender;

    @FindBy(id="patient-bloodGroup") //S.A.
    public WebElement selectBloodGroup;

    @FindBy(id="patient-adress") //S.A.
    public WebElement inputAddress;

    @FindBy(id="patient-description") //S.A.
    public WebElement inputDescription;

    @FindBy(id="patient-user") //S.A.
    public WebElement selectUser;

    @FindBy(id="patient-country") //S.A.
    public WebElement selectCountry;

    @FindBy(id="patient-cstate") //S.A.
    public WebElement selectStateCity;

    @FindBy(id="cancel-save") //S.A.
    public WebElement btnBack;

    @FindBy(id="save-entity") //S.A.
    public WebElement btnSave;
}