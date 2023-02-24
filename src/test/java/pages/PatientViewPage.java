package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientViewPage {
    public PatientViewPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }




}