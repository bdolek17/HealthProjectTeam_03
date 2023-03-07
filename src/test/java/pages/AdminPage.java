package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AdminPage {
    public AdminPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "admin-menu")
    public WebElement adminMenuDropDown;

    @FindBy(xpath = "//span[.='User management']")
    public WebElement userManagement;

    @FindBy(xpath = "//ul[@class='pagination']/li")
    public List<WebElement> pageNumbers;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public List<WebElement> usersEditButtonList;

    @FindBy(name = "activated")
    public WebElement activatedCheckBox;

    @FindBy(id = "authorities")
    public WebElement userProfiles;

    @FindBy(xpath = "//span[.='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//tbody/tr/td[5]/button/span")
    public List<WebElement> statusList;

    @FindBy(xpath = "//tbody/tr/td[7]/div/span")
    public List<WebElement> profilesList;

    @FindBy(xpath = "//span[.='ID']")
    public WebElement sortById;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "login-item")
    public WebElement signin_btn;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//*[@id='login-page']/div/form/div[3]/button[2]/span")
    public WebElement signin_link;

    @FindBy(xpath = "//*[@id='adminteam03']/td[11]/div/a[2]/span/span")
    public WebElement edit_btn;

    @FindBy(xpath = "//*[@id='adminteam03']/td[5]/button/span")
    public WebElement activate_btn;

    @FindBy(xpath = "//*[@id='authorities']/option[3]")
    public WebElement role_patient;

    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div/div[2]/div/form/button/span")
    public WebElement save_btn;

}