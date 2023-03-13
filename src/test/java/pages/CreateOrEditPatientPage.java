package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CreateOrEditPatientPage {
    public CreateOrEditPatientPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[contains(@id,'createOrEditLabel')")
    public WebElement createOrEditPageHeader;

    @FindBy(id = "patient-id")
    public WebElement inputID;

    @FindBy(id = "patient-firstName")
    public WebElement inputFirstName;

    @FindBy(id = "patient-lastName")
    public WebElement inputLastName;

    @FindBy(id = "patient-birthDate")
    public WebElement datetimeControl;

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "patient-phone")
    public WebElement inputPhone;

    @FindBy(id = "patient-gender")
    public WebElement selectGender;

    @FindBy(id = "patient-bloodGroup")
    public WebElement selectBloodGroup;

    @FindBy(id = "patient-adress")
    public WebElement inputAddress;

    @FindBy(id = "patient-description")
    public WebElement inputDescription;

    @FindBy(id = "patient-user")
    public WebElement selectUser;

    @FindBy(id = "patient-country")
    public WebElement selectCountry;

    @FindBy(id = "patient-cstate")
    public WebElement selectStateCity;

    @FindBy(id = "save-entity")
    public WebElement btnSave;

    @FindBy(id = "cancel-save")
    public WebElement linkBack;

    @FindBy(xpath = "//div[@role='alert' and contains(@class,'Toastify')]")
    public WebElement savedMassagePatient;



}
