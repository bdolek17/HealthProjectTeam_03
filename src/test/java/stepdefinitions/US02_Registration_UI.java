package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.RegistrationPage;
import utilities.Driver;
import utilities.JSUtils;

import javax.security.auth.callback.PasswordCallback;

import static org.junit.Assert.assertEquals;

public class US02_Registration_UI {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();

    @Given("user goes on {string} pagepage")
    public void userGoesOnPagepage(String arg0) {
        Driver.getDriver().get(arg0);
    }

    @When("user click on the account menu icon on home pagepage")
    public void userClickOnTheAccountMenuIconOnHomePagepage() {
        homePage.account_menu.click();

    }



    @When("user click on the registration link on home page")
    public void user_click_on_the_registration_link_on_home_page() {

        homePage.linkRegister.click();

    }
    @When("enter {string} in SSN input")
    public void enter_in_ssn_input(String SSN) {
        SSN = faker.idNumber().ssnValid();

        registrationPage.inputSSN.sendKeys(SSN);


    }
    @When("enter {string} in FirstName input")
    public void enter_in_first_name_input(String FirstName) {
        FirstName = faker.name().firstName();

        registrationPage.inputFirstName.sendKeys(FirstName);

    }
    @When("enter {string} in LastName input")
    public void enter_in_last_name_input(String LastName) {
        LastName = faker.name().lastName();
        registrationPage.inputLastName.sendKeys(LastName);

    }
    @When("enter {string} in username input")
    public void enter_emel01_in_username_input(String username) {
        username = faker.internet().domainName();
        registrationPage.inputUserName.sendKeys(username);

    }
    @When("enter {string} in Email input")
    public void enter_in_email_input(String Email) {
        Email = faker.internet().emailAddress();
        registrationPage.inputEmail.sendKeys(Email);

    }
    @When("enter {string} in New password input")
    public void enter_in_new_password_input(String password) {
        //password = faker.internet().password(10,20,true, true);


        registrationPage.inputFirstPassword.sendKeys(password);

    }
    @When("enter {string} in New password confirmation input")
    public void enter_in_new_password_confirmation_input(String password2) {

        //Driver.wait(3);
        //password2 = registrationPage.inputFirstPassword.getText();
        //Driver.wait(5);

            registrationPage.inputSecondPassword.sendKeys(password2);

        }

    @When("click Register button")
    public void click_register_button() {
        Driver.waitAndClick(registrationPage.btnRegisterSubmit);
        JSUtils.clickElementByJS(registrationPage.btnRegisterSubmit);

    }

    @Then("user should see {string} message on the pagepage")
    public void userShouldSeeMessageOnThePagepage(String arg0) {
        Assert.assertTrue(Driver.waitForVisibility(registrationPage.registrationSaved, 5).isDisplayed());
        //Assert.assertEquals(arg0, registrationPage.registrationSaved);
       //Assert.assertTrue(registrationPage.registrationSaved.isDisplayed());
        //assertEquals(arg0, registrationPage.registrationSaved.getText());
        //Assert.assertTrue(registrationPage.registrationSaved.getText().contains(arg0));

    }
    // negative Test
    @Given("user goes on {string} on home page")
    public void user_goes_on_on_home_page(String url) {
        Driver.getDriver().get(url);

    }
    @When("user click on the account menu icon on home  page")
    public void user_click_on_the_account_menu_icon_on_home_page() {
        homePage.account_menu.click();

    }
    @When("user click on the registration link on home page page")
    public void user_click_on_the_registration_link_on_home_page_page() {
        homePage.linkRegister.click();

    }
    @When("enter {string} in SSN input on registration page")
    public void enter_in_ssn_input_on_registration_page(String SSN) {
        registrationPage.inputSSN.sendKeys(SSN);

    }
    @When("enter {string} in FirstName input on registration page")
    public void enter_in_first_name_input_on_registration_page(String FirstName) {
        registrationPage.inputFirstName.sendKeys(FirstName);

    }
    @When("enter {string} in LastName input on registration page")
    public void enter_in_last_name_input_on_registration_page(String LastName) {
        registrationPage.inputLastName.sendKeys(LastName);

    }

    @When("enter {string} in Email input on registration page")
    public void enter_in_email_input_on_registration_page(String Email) {
        registrationPage.inputEmail.sendKeys(Email);


    }
    @When("enter {string} in New password input on registration page")
    public void enter_in_new_password_input_on_registration_page(String New) {
        registrationPage.inputFirstPassword.sendKeys(New);

    }
    @When("enter {string} in New password confirmation input on registration page")
    public void enter_in_new_password_confirmation_input_on_registration_page(String confirmation) {
        registrationPage.inputSecondPassword.sendKeys(confirmation);

    }
    @When("click Register button on registration page")
   public void click_register_button_on_registration_page() {
     JSUtils.clickElementByJS(registrationPage.btnRegisterSubmit);

    }
    @Then("user should see error message on registration page")
   public void user_should_see_error_message_on_registration_page() {
        registrationPage.getusernamerequiredmsj.isDisplayed();

    }

////Email negative
@Given("user goes on {string} on home pagepage")
public void user_goes_on_on_home_pagepage(String url) {
    Driver.getDriver().get(url);

}
    @When("user click on the account menu icon on home  pagepage")
    public void user_click_on_the_account_menu_icon_on_home_pagepage() {
        homePage.account_menu.click();

    }
    @When("user click on the registration link on home page pagepage")
    public void user_click_on_the_registration_link_on_home_page_pagepage() {
        homePage.linkRegister.click();

    }
    @When("enter {string} in SSN input on registration pagepage")
    public void enter_in_ssn_input_on_registration_pagepage(String SSN) {
        registrationPage.inputSSN.sendKeys(SSN);

    }
    @When("enter {string} in FirstName input on registration pagepage")
    public void enter_in_first_name_input_on_registration_pagepage(String FirstName) {
        registrationPage.inputFirstName.sendKeys(FirstName);

    }
    @When("enter {string} in LastName input on registration pagepage")
    public void enter_in_last_name_input_on_registration_pagepage(String LastName) {
        registrationPage.inputLastName.sendKeys(LastName);

    }
    @When("enter {string} in username input on registration pagepage")
    public void enter_in_username_input_on_registration_pagepage(String username) {
        registrationPage.inputUserName.sendKeys(username);


    }
    @When("enter {string} in Email input on registration pagepage")
    public void enter_in_email_input_on_registration_pagepage(String Email) {
        registrationPage.inputEmail.sendKeys(Email);


    }
    @When("enter {string} in New password input on registration pagepage")
    public void enter_in_new_password_input_on_registration_pagepage(String New) {
        registrationPage.inputFirstPassword.sendKeys(New);


    }
    @When("enter {string} in New password confirmation input on registration pagepage")
    public void enter_in_new_password_confirmation_input_on_registration_pagepage(String confirmation) {
        registrationPage.inputSecondPassword.sendKeys(confirmation);


    }
    @When("click Register button on registration pagepage")
    public void click_register_button_on_registration_pagepage() {
        JSUtils.clickElementByJS(registrationPage.btnRegisterSubmit);

    }
    @Then("user should see error message on registration pagepage")
    public void user_should_see_error_message_on_registration_pagepage() {
        //registrationPage.getemailinvalidmsj.isDisplayed();
        Assert.assertTrue(Driver.waitForVisibility(registrationPage.getemailinvalidmsj, 5).isDisplayed());

    }



}
