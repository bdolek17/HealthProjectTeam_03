package pages;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserManagmentPage {
    public UserManagmentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}

