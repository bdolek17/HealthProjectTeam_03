package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CreateOrEditTestResultPage {
    public CreateOrEditTestResultPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//h2[contains(@id,'createOrEditLabel')")
    public WebElement createOrEditTestResultPageHeader;

    @FindBy(id = "c-test-result-id")
    public WebElement inputId;

    @FindBy(name = "date")
    public WebElement inputDate;

    @FindBy(id = "c-test-result-result")
    public WebElement inputResult;

    @FindBy(id = "c-test-result-description")
    public WebElement inputDescription;

    @FindBy(id = "c-test-result-createdDate")
    public WebElement inputResultCreatedDate;

    @FindBy(id = "c-test-result-cTestItem")
    public WebElement inputResultTestItem;

    @FindBy(id = "c-test-result-cTest")
    public WebElement inputResultTest;

    @FindBy(id = "cancel-save")
    public WebElement btnCancelBack;

    @FindBy(id = "save-entity")
    public WebElement btnSave;

}
