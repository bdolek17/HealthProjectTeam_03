package pages;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserSettingsPage {
    public UserSettingsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
