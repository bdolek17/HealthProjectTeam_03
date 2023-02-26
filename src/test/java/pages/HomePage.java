package pages;

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
    public WebElement accountMenu;

    @FindBy(xpath = "//a[contains(@href,'login')]")
    public WebElement linkLogin;

    @FindBy(xpath = "//a[contains(@href,'register')]")
    public WebElement linkRegister;

    @FindBy(xpath = "//li[@id='account-menu']//a//span")
    public WebElement accountMenuUserName;

    @FindBy(xpath = "//a[contains(@href,'settings')]")
    public WebElement linkUserSettings;

    @FindBy(xpath = "//a[contains(@href,'password')]")
    public WebElement linkUserPassword;

    @FindBy(xpath = "//a[contains(@href,'logout')]")
    public WebElement linkSignout;

    @FindBy(xpath = "//a[@href='#']")
    public WebElement userIcon;

    @FindBy(xpath = "//li[@id='entity-menu']//a")  //S.A.
    public WebElement linkMyPages;

    @FindBy(xpath = "//a[contains(@href,'search-patient') and @role='menuitem']")  //S.A.
    public WebElement linkSearchPatient;

    @FindBy(xpath = "//a[contains(@href,'ps-in-patient') and @role='menuitem']")  //S.A.
    public WebElement linkInPatient;

}

