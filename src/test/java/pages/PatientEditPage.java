package pages;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientEditPage {
    public PatientEditPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}