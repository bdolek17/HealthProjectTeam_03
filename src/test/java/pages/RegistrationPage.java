package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegistrationPage {
    public RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "ssn")
    public WebElement inputSSN;

    @FindBy(id = "firstName")
    public WebElement inputFirstName;

    @FindBy(id = "lastName")
    public WebElement inputLastName;

    @FindBy(id = "username")
    public WebElement inputUserName;

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "firstPassword")
    public WebElement inputFirstPassword;

    @FindBy(id = "secondPassword")
    public WebElement inputSecondPassword;

    @FindBy(id = "register-submit")
    public WebElement btnRegisterSubmit;


}

