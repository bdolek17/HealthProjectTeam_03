package pages;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserManagmentEditPage {
    public UserManagmentEditPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}

