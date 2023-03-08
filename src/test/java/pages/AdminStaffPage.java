package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminStaffPage {
    public AdminStaffPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "entity-menu")
    public WebElement itemTitle;

  //  @FindBy(xpath = "//a[@href='/staff']")
    public WebElement staff;

    @FindBy(linkText = "Staff")
    public WebElement staffText;

    @FindBy(linkText = "4354")
    public WebElement patient;

    @FindBy(xpath = "//a[@href='/staff/4354/edit']")
    public WebElement edit;

    @FindBy(id ="searchSSN")
    public WebElement SSN;

    @FindBy(id="useSSNSearch")
    public WebElement useSSN;

    @FindBy(xpath = "//button[@class='btn btn-secondary']")
    public WebElement button;

    @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast--success toastify-toast']")
    public WebElement text;

    @FindBy(id="staff-id")
    public WebElement ID;

    @FindBy(id="staff-firstName")
    public WebElement firstName;

    @FindBy(id="staff-lastName")
    public WebElement lastName;

    @FindBy(id="staff-birthDate")
    public WebElement birthDate;

    @FindBy(id="staff-phone")
    public WebElement phoneNumber;

    @FindBy(id="staff-gender")
     public WebElement gender;

     @FindBy(id="staff-bloodGroup")
     public WebElement bloodGroup;

     @FindBy(id="staff-country")
     public WebElement country;

  @FindBy(id="save-entity")
  public WebElement saveButton;

  @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast--success toastify-toast']")
  public WebElement saveText;

  @FindBy(id="//a[@href='/staff/4353/delete?page=1&sort=id,asc']")
  public WebElement deleteButton;













}
