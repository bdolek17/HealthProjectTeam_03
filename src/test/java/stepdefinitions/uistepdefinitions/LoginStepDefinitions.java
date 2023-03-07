package stepdefinitions.uistepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.Driver;
import utilities.JSUtils;

public class LoginStepDefinitions {
    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();


    @When("user clicks on the account menu icon on home page")
    public void user_clicks_on_the_account_menu_icon_on_home_page() {
        homePage.accountMenu.click();
        Driver.wait(1);
    }
    @When("user clicks on the sign in link on home page")
    public void user_clicks_on_the_sign_in_link_on_home_page() {
        homePage.linkLogin.click();
        Driver.wait(1);
    }
    @When("user enters the username {string} on login page")
    public void user_enters_the_username_on_login_page(String username) {
        Driver.waitAndSendText(loginPage.inputUsername,username);
        Driver.wait(1);
    }
    @When("user enters the password {string} on login page")
    public void user_enters_the_password_on_login_page(String pwd) {
        Driver.waitAndSendText(loginPage.inputPassword,pwd);
        Driver.wait(1);
    }
    @When("user clicks on sign in button on login page")
    public void user_clicks_on_sign_in_button_on_login_page() {
        JSUtils.clickElementByJS(loginPage.btnSignin);Driver.wait(1);
    }
    @When("verify user logged in")
    public void verify_user_logged_in() {
        Driver.waitForClickablility(homePage.accountMenuUserName,3);
        String userName= homePage.accountMenuUserName.getText();
        Assert.assertTrue(userName.length()>0);
        Driver.wait(2);
    }
}