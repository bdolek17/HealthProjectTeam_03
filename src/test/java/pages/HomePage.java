package pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Room")
    public WebElement roomOption;

    @FindBy(id = "account-menu")
    public WebElement account_menu  ;

    @FindBy(id = "login-item")  //a[contains(@href,'login')]
    public WebElement linkLogin;

    @FindBy(xpath = "//a[@href='/account/register']")  //a[contains(@href,'/account/register')]
    public WebElement linkRegister;

    @FindBy(xpath = "//a[@href='#']")
    public WebElement userIcon;

    @FindBy(id = "account-menu")  //S.A.
    public WebElement accountMenu;

    @FindBy(xpath = "//li[@id='account-menu']//a//span") //S.A.
    public WebElement accountMenuUserName;

    @FindBy(xpath = "//a[contains(@href,'settings')]") //S.A.
    public WebElement linkUserSettings;

    @FindBy(xpath = "//a[contains(@href,'password')]") //S.A.
    public WebElement linkUserPassword;

    @FindBy(xpath = "//a[contains(@href,'logout')]") //S.A.
    public WebElement linkSignout;

    @FindBy(xpath = "//li[@id='entity-menu']//a")  //S.A.
    public WebElement linkMyPages;

    @FindBy(xpath = "//a[contains(@href,'search-patient') and @role='menuitem']")  //S.A.
    public WebElement linkSearchPatient;

    @FindBy(xpath = "//a[contains(@href,'ps-in-patient') and @role='menuitem']")  //S.A.
    public WebElement linkInPatient;

    @FindBy(xpath = "//li[@id='admin-menu']/a")  //S.A.
    public WebElement adminMenuAdministration;

    @FindBy(xpath = "//a[contains(@href,'user-management')]")  //S.A.
    public WebElement adminMenuUserManagement;

    @FindBy(xpath = "//li[@id='entity-menu']/a")  //S.A.
    public WebElement adminMenuItemsAndTitles;

    @FindBy(xpath = "//a[contains(@href,'/patient')]")  //S.A.
    public WebElement adminMenuPatient;

    @FindBy(xpath = "//a[contains(@href,'/staff')]")  //S.A.
    public WebElement adminMenuStaff;

    @FindBy(xpath = "//a[contains(@href,'/physician')]")  //S.A.
    public WebElement adminMenuPhysician;

    @FindBy(xpath = "//a[contains(@href,'/appointment')]")  //S.A.
    public WebElement adminMenuAppointment;

    @FindBy(xpath = "//a[contains(@href,'/c-test-item')]")  //S.A.
    public WebElement adminMenuCTestItem;

    @FindBy(xpath = "//a[contains(@href,'/room')]")  //S.A.
    public WebElement adminMenuRoom;

    @FindBy(xpath = "//a[contains(@href,'/country')]")  //S.A.
    public WebElement adminMenuCountry;

    @FindBy(xpath = "//a[contains(@href,'/c-state')]")  //S.A.
    public WebElement adminMenuCState;

    @FindBy(xpath = "//a[contains(@href,'/c-message')]")  //S.A.
    public WebElement adminMenuCMessage;



}

