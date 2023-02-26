package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;
import utilities.Driver;

public class RegistrationPage {


    public RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "account-menu")
    public WebElement account_menu;

    @FindBy(xpath = "//a[@href='/account/register']")  //a[contains(@href,'/account/register')]
    public WebElement linkRegister;


    @FindBy(id = "ssn")
    public WebElement inputSSN;

    @FindBy(id = "firstName")
    public WebElement inputFirstName;

    @FindBy(id = "lastName")
    public WebElement inputLastName;

    @FindBy(id = "username")
    public WebElement inputUserName;

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "firstPassword")
    public WebElement inputFirstPassword;

    @FindBy(id = "secondPassword")
    public WebElement inputSecondPassword;

    @FindBy(id = "register-submit")
    public WebElement btnRegisterSubmit;


    @FindBy(xpath = "//input[@id='firstPassword']")
    public WebElement newPasswordBox;

    @FindBy(xpath = "//input[@id='secondPassword']")
    public WebElement confirmPasswordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement registerButton;

    @FindBy(xpath = "//div[contains(text(),'Registration Saved')]")
    public WebElement registrationSuccessMessage;

    @FindBy(xpath = "//*[@style='background-color: rgb(255, 0, 0);']")
    public static WebElement passwordStrength1;

    @FindBy(xpath = "(//*[@style='background-color: rgb(153, 255, 0);'])[2]")
    public static WebElement passwordStrength2;

    @FindBy(xpath = "(//*[@style='background-color: rgb(153, 255, 0);'])[3]")
    public static WebElement passwordStrength3;

    @FindBy(xpath = "(//*[@style='background-color: rgb(153, 255, 0);'])[4]")
    public static WebElement passwordStrength4;

    @FindBy(xpath = "(//*[@style='background-color: rgb(153, 255, 0);'])[5]")
    public static WebElement passwordStrength5;

    @FindBy(xpath = "//*[@style='background-color: rgb(221, 221, 221);']")
    public static WebElement fifthPasswordBarGray;

    @FindBy(xpath = "//*[@class='invalid-feedback']")
    public static WebElement passwordErrorMessage;

    @FindBy(xpath = "//input[@id='firstPassword']")
    public static WebElement newPasswordBoxStatic;

    @FindBy(xpath = "//*[.='Registration Saved']")
    public WebElement savedMessage;



}

