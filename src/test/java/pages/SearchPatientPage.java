package pages;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchPatientPage {
    public SearchPatientPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}

