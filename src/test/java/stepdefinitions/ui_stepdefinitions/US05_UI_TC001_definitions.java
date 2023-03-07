package stepdefinitions.ui_stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import static org.junit.Assert.*;

public class US05_UI_TC001_definitions {

    HomePage homepage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("patientt is on {string} page")
    public void patientt_is_on_page(String string) {
        Driver.getDriver().get(string);

    }

    @When("patientt clicks on the account menu icon on home page")
    public void patientt_clicks_on_the_account_menu_icon_on_home_page() {
        homepage.account_menu.click();
        ReusableMethods.waitFor(1);
    }

    @When("patientt clicks on the sign in link on login page")
    public void patientt_clicks_on_the_sign_in_link_on_login_page() {
        homepage.linkLogin.click();
        ReusableMethods.waitFor(1);
    }

    @When("patientt enters the username {string} on login page")
    public void patientt_enters_the_username_on_login_page(String string) {
        loginPage.inputUsername.sendKeys(string);


    }

    @When("patientt enters the password {string} on login page")
    public void patientt_enters_the_password_on_login_page(String string) {
        loginPage.inputPassword.sendKeys(string);

    }

    @When("patientt clicks on the remember me box")
    public void patientt_clicks_on_the_remember_me_box() {
        loginPage.chkRememberMe.click();
        ReusableMethods.waitFor(1);
    }

    @When("patientt clicks on sign in button on login page")
    public void patientt_clicks_on_sign_in_button_on_login_page() {
        loginPage.btnSignin.click();

        // Driver.getDriver().get("https://medunna.com/");

    }

    @When("patientt clicks on patient menu icon on login page")
    public void patientt_clicks_on_patient_menu_icon_on_login_page() {
        loginPage.btnPatient.click();

        ReusableMethods.waitFor(1);
    }


    @When("patientt clicks on Sign out link on login page")
    public void patientt_clicks_on_sign_out_link_on_login_page() {
        loginPage.linkSignout.click();

    }

    @When("patientt click on the account menu icon on home page")
    public void patientt_click_on_the_account_menu_icon_on_home_page() {
        homepage.account_menu.click();
        ReusableMethods.waitFor(1);
    }

    @When("patientt click on the sign in link on login page")
    public void patientt_click_on_the_sign_in_link_on_login_page() {
        homepage.linkLogin.click();
        ReusableMethods.waitFor(1);
    }


    @Then("patientt should see username and password come automatically to log in to the system again")
    public void patienttShouldSeeUsernameAndPasswordComeAutomaticallyToLogInToTheSystemAgain() {


        assertNotEquals("The value of the username input box did not come automatically.", "patient.t03", loginPage.inputUsername.getAttribute("value"));
        ReusableMethods.waitFor(1);

        assertNotEquals("The value of the password input box did not come automatically.", "Team03+", loginPage.inputPassword.getAttribute("value"));
        ReusableMethods.waitFor(1);

    }

    @Then("patientt clicks the cancel button.")
    public void patientt_clicks_the_cancel_button() {
        JSUtils.clickElementByJS(loginPage.btnCancel);
        Driver.wait(2);

    }


    @When("patienttt clicks on the account menu icon on home page")
    public void patienttt_clicks_on_the_account_menu_icon_on_home_page() {
        homepage.account_menu.click();

        ReusableMethods.waitFor(1);

    }


    @Then("patientt clicks sign in button on home page")
    public void patientt_clicks_sign_in_button_on_home_page() { homepage.linkLogin.click();
        ReusableMethods.waitFor(1);

    }



    @Then("patientt navigate to link of Register a new account")
    public void patientt_navigate_to_link_of_register_a_new_account() { JSUtils.clickElementByJS(homepage.linkRegister);
    }

}

