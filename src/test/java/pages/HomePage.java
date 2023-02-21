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

    @FindBy(id = "login-item")
    public WebElement linkLogin;

    @FindBy(xpath = "//a[@href='/account/register']")  //a[contains(@href,'/account/register')]
    public WebElement linkRegister;


}

