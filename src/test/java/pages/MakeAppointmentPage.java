package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MakeAppointmentPage {
    public MakeAppointmentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id="phone")
    public WebElement phone;

    @FindBy(id="appoDate")
    public WebElement app_date;

    @FindBy(xpath = "//span[.='Send an Appointment Request']")
    public WebElement appRequest;

    @FindBy(xpath ="//span[.='Appointment registration saved!'")
    public WebElement appSaved;




}