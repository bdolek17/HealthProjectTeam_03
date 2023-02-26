package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PhysicianAppointmentPage {
    public PhysicianAppointmentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="entity-menu")
    public WebElement myPages;
    @FindBy(xpath = "//*[@id=\"entity-menu\"]/div/a[1]/span")
    public WebElement myAppointments;

    @FindBy(id= "fromDate")
    public WebElement fromDate;

    @FindBy(id= "toDate")
    public WebElement toDate;
    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/table/tbody/tr/td[13]/div/a")
    public WebElement editButton;

    @FindBy(id= "appointment-anamnesis")
    public WebElement anamnesis;
    @FindBy(id= "appointment-treatment")
    public WebElement treatment;

    @FindBy(id= "appointment-diagnosis")
    public WebElement diagnosis;

    @FindBy (id="appointment-prescription")
    public WebElement  prescription;

    @FindBy (id="appointment-status")
    public WebElement status;

    @FindBy(id="save-entity")
    public WebElement saveButton1;

}

