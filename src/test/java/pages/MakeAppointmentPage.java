package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MakeAppointmentPage {
    public MakeAppointmentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id="phone")
    public WebElement phone;

    @FindBy(id="appoDate")
    public WebElement app_date;

    @FindBy(xpath = "//span[.='Send an Appointment Request']")
    public WebElement appRequest;

<<<<<<< HEAD
    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement ssnInput;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phoneInput;

    @FindBy(xpath = "//input[@name='appoDate']")
    public WebElement appoDateInput;

    @FindBy(xpath = "//div[contains(text(),'Appointment registration saved! We will call you as soon as possible.')]")
    public WebElement AppRegistrationSuccessMessage;

    @FindBy(id = "register-submit")
    public WebElement sendRequest;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement invalidSSNmessage;

    @FindBy(xpath ="//span[.='Appointment registration saved!'")
    public WebElement appSaved;





=======
    @FindBy(xpath ="//span[.='Appointment registration saved!'")
    public WebElement appSaved;

>>>>>>> main



}