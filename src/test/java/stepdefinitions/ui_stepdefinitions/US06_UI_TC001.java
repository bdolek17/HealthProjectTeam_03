package stepdefinitions.ui_stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.MakeAppointmentPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class US06_UI_TC001 {
    MakeAppointmentPage makeAppointmentPage=new MakeAppointmentPage();
    @Given("The user click on {string} appointment pagess")
    public void the_user_click_on_appointment_pagess(String string) {
        Driver.getDriver().get(string);
    }
    @When("The user enter firstname for appointment")
    public void the_user_enter_firstname_for_appointment() {
        makeAppointmentPage.firstNameInput.sendKeys("amine");

    }
    @When("The user enter lastname for appointment")
    public void the_user_enter_lastname_for_appointment() {
        makeAppointmentPage.lastNameInput.sendKeys("yila");

    }
    @When("The user enter SSN for appointment")
    public void the_user_enter_ssn_for_appointment() {
        makeAppointmentPage.ssnInput.sendKeys("456-55-7823");

    }
    @When("The user enter email for appointment")
    public void the_user_enter_email_for_appointment() {
        makeAppointmentPage.emailInput.sendKeys("a_yila@gmail.com");

    }
    @When("The user enter phone for appointment")
    public void the_user_enter_phone_for_appointment() {
        makeAppointmentPage.phoneInput.sendKeys("555-666-1234");

    }
    @When("The user clicks send an appointment request button")
    public void the_user_clicks_send_an_appointment_request_button() {
        ReusableMethods.waitFor(2);
       // makeAppointmentPage.sendRequest.click();
        JSUtils.clickElementByJS(makeAppointmentPage.sendRequest);

    }

    @Then("The user should see appointment registration saved message")
    public void theUserShouldSeeAppointmentRegistrationSavedMessage() {

    }

    @And("{int}--The user enter invalidSSN")
    public void theUserEnterInvalidSSN(int arg0) {
        makeAppointmentPage.ssnInput.sendKeys("457-88-3");
       makeAppointmentPage.emailInput.sendKeys("a");
    }

    @And("{int}-The user should error message")
    public void theUserShouldErrorMessage(int arg0) {
        Assert.assertEquals("Your SSN is invalid",makeAppointmentPage.invalidSSNmessage.getText());

    }
}
