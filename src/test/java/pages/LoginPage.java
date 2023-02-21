package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "username")
    public WebElement inputUsername;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(id = "rememberMe")
    public WebElement chkRememberMe;

    @FindBy(xpath = "(//*[@id='login-page']//button)[2]")
    public WebElement btnCancel;

    @FindBy(xpath = "(//*[@id='login-page']//button)[3]")
    public WebElement btnSignin;
}



