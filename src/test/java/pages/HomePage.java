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
    public WebElement account_menu;

    @FindBy(xpath = "//a[contains(@href,'login')]")
    public WebElement linkLogin;

    @FindBy(xpath = "//a[contains(@href,'register')]")
    public WebElement linkRegister;

    @FindBy(xpath = "//li[@id='account-menu']//a//span")
    public WebElement account_menu_user_id;

    @FindBy(xpath = "//a[@href='/account/settings']")
    public WebElement linkUserSettings;

    @FindBy(xpath = "//a[@href='/account/password']")
    public WebElement linkUserPassword;

    @FindBy(xpath = "//a[contains(@href,'logout')]")
    public WebElement linkSignout;




}

