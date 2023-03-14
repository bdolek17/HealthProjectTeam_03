package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchPatientPage {
    public SearchPatientPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//input[@name='ssn']")   //S.A.
    public WebElement inputSearchSSN;

}

