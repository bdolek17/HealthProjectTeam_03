package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestItemsPage {
    public TestItemsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Create a new Test Item")
    public WebElement createTestItem;

    @FindBy(name = "name")
    public WebElement inputName;

    @FindBy(id = "c-test-item-description")
    public WebElement inputdescription;

    @FindBy(name = "price")
    public WebElement inputPrice;

    @FindBy(name = "defaultValMin")
    public WebElement inputdefaultValMin;

    @FindBy(name = "defaultValMax")
    public WebElement inputdefaultValMax;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement createdMessage;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div[1]/div/table/tbody/tr[1]/td[8]/div/a[1]/span")
    public WebElement viewButton;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/h2")
    public WebElement viewNewTestItem;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/a[2]")
    public WebElement editButton;

    @FindBy(xpath = "//*[@id=\"hospitalmsappfrontendApp.cTestItem.home.createOrEditLabel\"]")
    public WebElement createOrEditMessage;

    @FindBy(xpath = "//*[@id=\"save-entity\"]")
    public WebElement editSave;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div[1]/div/table/tbody/tr[20]/td[8]/div/a[3]/span/span")
    public WebElement deleteButton1;

    @FindBy(id = "jhi-confirm-delete-cTestItem")
    public WebElement deleteButton2;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/div[1]")
    public WebElement deleteMessage;






}
