package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserSettingsPage {
    public UserSettingsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "settings-title")
    public WebElement settingsPageHeader;
    @FindBy(id="firstName")
    public WebElement inputFirstName;

    @FindBy(id="lastName")
    public WebElement inputLastName;

    @FindBy(id="email")
    public WebElement inputEmail;

    @FindBy(xpath="//form[@id='settings-form']//button")
    public WebElement btnSave;

    @FindBy(xpath = "//*[text()='Settings saved!']")
    public WebElement settingsSaveAlertBox;

    @FindBy(xpath = "//div[text()='Your first name is required.']")
    public WebElement firstNameIsRequiredMessageText;

    @FindBy(xpath = "//div[text()='Your last name is required.']")
    public WebElement lastNameIsRequiredMessageText;

}
