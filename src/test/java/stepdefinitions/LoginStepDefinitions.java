package stepdefinitions;

import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utilities.JSUtils;

public class LoginStepDefinitions {
    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();


    @When("user clicks on the account menu icon on home page")
    public void user_clicks_on_the_account_menu_icon_on_home_page() {
        homePage.account_menu.click();
    }
    @When("user clicks on the sign in link on login page")
    public void user_clicks_on_the_sign_in_link_on_login_page() {
        try{
            homePage.linkLogin.click();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @When("user enters the username {string} on login page")
    public void user_enters_the_username_on_login_page(String username) {
        loginPage.inputUsername.sendKeys(username);
    }
    @When("user enters the password {string} on login page")
    public void user_enters_the_password_on_login_page(String pwd) {
        loginPage.inputPassword.sendKeys(pwd);
    }
    @When("user clicks on sign in button on login page")
    public void user_clicks_on_sign_in_button_on_login_page() {
        JSUtils.clickElementByJS(loginPage.btnSignin);
    }


}