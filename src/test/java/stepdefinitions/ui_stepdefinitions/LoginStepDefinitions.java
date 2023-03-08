package stepdefinitions.ui_stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.Driver;
import utilities.JSUtils;

public class LoginStepDefinitions {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();


    @When("user clicks on the account menu icon on home page")
    public void user_clicks_on_the_account_menu_icon_on_home_page() {
        homePage.accountMenu.click();
        Driver.wait(1);
    }

    @When("user clicks on the sign in link on login page")
    public void user_clicks_on_the_sign_in_link_on_login_page() {
        try {
            homePage.linkLogin.click();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }}
