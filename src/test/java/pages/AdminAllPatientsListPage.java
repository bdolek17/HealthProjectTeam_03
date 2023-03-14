package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AdminAllPatientsListPage {
    public AdminAllPatientsListPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[@id='patient-heading']/span")   //S.A.
    public WebElement lblPageHeading;

    @FindBy(id = "jh-create-entity")   //S.A.
    public WebElement btnCreateNewPatient;

    @FindBy(xpath = "//*[@id='app-view-container']//span")   //S.A.
    public WebElement spanUnauthorizedMessage;

    @FindBy(xpath = "//table/thead/tr/th")   //S.A.
    public List<WebElement> listPatientHeaders;

    @FindBy(xpath = "//table/tbody/tr")   //S.A.
    public List<WebElement> listPatientData;

    @FindBy(xpath = "(//ul[@class='pagination']/li)[1]")   //S.A.
    public WebElement pageFirstLinkItem;
    @FindBy(xpath = "//a[.='««']")   //S.A.
    public WebElement pageFirst;
    @FindBy(xpath = "//a[@aria-label='Previous']")   //S.A.
    public WebElement pagePrevious;
    @FindBy(xpath = "//a[@aria-label='Next']")   //S.A.
    public WebElement pageNext;
    @FindBy(xpath = "//a[.='»»']")   //S.A.
    public WebElement pageLast;
    @FindBy(xpath = "(//ul[@class='pagination']/li)[last()]")   //S.A.
    public WebElement pageLastLinkItem;

    @FindBy(id = "jhi-confirm-delete-patient")
    public WebElement btnConfirmDeletePatient;

    @FindBy(xpath = "//div[@role='alert' and contains(text(),'A Patient is deleted with identifier')]")
    public WebElement deleteMassageForPatient;

}
