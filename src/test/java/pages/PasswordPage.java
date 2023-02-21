package pages;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PasswordPage {
    public PasswordPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}