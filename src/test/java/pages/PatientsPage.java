package pages;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientsPage {
    public PatientsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}

