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



    @FindBy(xpath = "//span[.='patient-updated Hasta-updated']")
    public WebElement btnPatient;

    @FindBy(xpath = "//span[.='Sign out']")
    public WebElement linkSignout;

  @FindBy(xpath = "//*[@id='login-page']")
   public WebElement linkNewregister;


   // @FindBy(xpath = "//span[.='Register a new account']")
   // public WebElement linkNewregister;

   // @FindBy(xpath = "//span[.='Cancel']")
  // public WebElement getBtnCancel;

   // @FindBy(xpath = "(//*[@id='login-page']//button)[1]")
    //public WebElement getBtnCancel;
//*[@id="login-page"]/div/form/div[3]/button[1]
// Register a new account
}



