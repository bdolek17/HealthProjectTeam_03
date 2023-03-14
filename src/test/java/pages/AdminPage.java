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

    @FindBy(xpath = "//span[text()='Items&Titles']")
    public WebElement itemTitle;

    @FindBy(xpath = "//span[text()='Room']")
    public WebElement dropDownRoom;

    @FindBy(xpath = "//span[text()='Create a new Room']")
    public WebElement createRoomButton;

    @FindBy(xpath = "//span[text()='Create or edit a Room']")
    public WebElement createOrEditRoomText;

    @FindBy(xpath = "//input[@name='roomNumber']")
    public WebElement roomNumberBox;

    @FindBy(xpath = "//select[@name='roomType']")
    public WebElement roomTypeBox;

    @FindBy(xpath = "//input[@name='status']")
    public WebElement statusButton;

    @FindBy(xpath = "//input[@name='price']")
    public WebElement priceBox;

    @FindBy(xpath = "//input[@name='description']")
    public WebElement descriptionBox;

    @FindBy(xpath = "//input[@name='createdDate']")
    public WebElement createdDateBox;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement roomSaveButton;

    //@FindBy(xpath = "//*[text()='A new Room is created']")
    //public WebElement alertRoomIsCreated;

    @FindBy(xpath =  "//*[contains(text(),'A new Room is created with identifier')]")
            public WebElement alertRoomIsCreated;

    @FindBy(xpath = "//*[contains(text(), 'A Room is update with identifier')]")
    public WebElement alertRoomIsUpdate;

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement adminAccountButton;

    @FindBy(xpath = "//span[text()='Sign out']")
    public WebElement adminSignOutButton;


    @FindBy(xpath = "//span[text()='Room Type']")
    public WebElement roomType;

    @FindBy(xpath = "//span[text()='TWIN']")
    public WebElement twinType;

    @FindBy(xpath = "//span[text()='View']")
    public WebElement viewButton;

    @FindBy(xpath = "//dl[@class='jh-entity-details']")
    public WebElement visibleRoomInfo;

    @FindBy(xpath = "//span[text()='Edit']")
    public WebElement editButton;

    @FindBy(xpath = "//span[text()='Delete']")
    public WebElement deleteButton;

    @FindBy(xpath = "(//button[@type='button'])[4]")
    public WebElement deletButtonAlertRoom;

    @FindBy(xpath = "//*[contains(text(), 'Are you sure you want to delete Room')]")
    public WebElement deleteQuestionAlert;

    @FindBy(xpath = "//*[contains(text(), 'A Room is delete with identifier']")
    public WebElement alertDeleteRoom;

    @FindBy(xpath = "//button[@class='close']")
    public WebElement closeButtonRoom;


    @FindBy(xpath = "//span[text()='Test Item']")
    public WebElement testItemButton;

    @FindBy(xpath = "//span[text()='Create a new Test Item']")
    public WebElement createNewTestItemButton;

    @FindBy(xpath = "//span[text()='Create or edit a Test Item']")
    public WebElement createEditTestItemIsVisible;

    @FindBy(xpath = "//span[text()='Test Items']")
    public WebElement testItemsTextVisibleAdmin;

    @FindBy(xpath = "//button[@id='jhi-confirm-delete-cTestItem']")
    public WebElement deletButtonAlertTestItem;

    @FindBy(xpath = "//button[@class='close']")
    public WebElement closeButtonAlert;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement nameBox;

    @FindBy(xpath = "//input[@name='description']")
    public WebElement descriptionBoxTestItem;

    @FindBy(xpath = "//input[@name='price']")
    public WebElement priceBoxTestItem;

    @FindBy(xpath = "//input[@name='defaultValMin']")
    public WebElement defaultValMin;

    @FindBy(xpath = "//input[@name='defaultValMax']")
    public WebElement defaultValMax;



}