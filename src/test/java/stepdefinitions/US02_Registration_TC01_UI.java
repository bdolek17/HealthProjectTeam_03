package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegistrationPage;
import utilities.Driver;

public class US02_Registration_TC01_UI {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();

    @Given("user goes on {string} pagepage")
    public void userGoesOnPagepage(String arg0) {
        Driver.getDriver().get(arg0);
    }



    @When("user clicks on the account menu icon on home page")
    public void user_clicks_on_the_account_menu_icon_on_home_page() {

        homePage.account_menu.click();
    }

    @When("user click on the registration link on home page")
    public void user_click_on_the_registration_link_on_home_page() {

        homePage.linkRegister.click();

    }
    @When("enter {string} in SSN input")
    public void enter_in_ssn_input(String SSN) {
        registrationPage.inputSSN.sendKeys(SSN);


    }
    @When("enter {string} in FirstName input")
    public void enter_in_first_name_input(String FirstName) {
        registrationPage.inputFirstName.sendKeys(FirstName);

    }
    @When("enter {string} in LastName input")
    public void enter_in_last_name_input(String LastName) {
        registrationPage.inputLastName.sendKeys(LastName);

    }
    @When("enter {string} in username input")
    public void enter_emel01_in_username_input(String username) {
        registrationPage.inputUserName.sendKeys(username);

    }
    @When("enter {string} in Email input")
    public void enter_in_email_input(String Email) {
        registrationPage.inputEmail.sendKeys(Email);

    }
    @When("enter {string} in New password input")
    public void enter_in_new_password_input(String password) {
        registrationPage.inputFirstPassword.sendKeys(password);

    }
    @When("enter {string} in New password confirmation input")
    public void enter_in_new_password_confirmation_input(String password) {
        registrationPage.inputSecondPassword.sendKeys(password);

    }
    @When("click Register button")
    public void click_register_button() {
        registrationPage.btnRegisterSubmit.click();







    }
}
