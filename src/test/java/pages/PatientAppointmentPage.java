package pages;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientAppointmentPage {
    public PatientAppointmentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}