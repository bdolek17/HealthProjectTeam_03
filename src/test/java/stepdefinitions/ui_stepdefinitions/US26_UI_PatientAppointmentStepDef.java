package stepdefinitions.ui_stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.PatientAppointmentPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class US26_UI_PatientAppointmentStepDef {

    HomePage homepage = new HomePage();
    LoginPage loginPage = new LoginPage();
    PatientAppointmentPage patientAppointmentPage = new PatientAppointmentPage();
    Faker faker = new Faker();

    @Given("ML patient is on {string} page")
    public void ml_patient_is_on_page(String url) {
        Driver.getDriver().get(url);

    }
    @When("ML patient clicks on the account menu icon on home page")
    public void ml_patient_clicks_on_the_account_menu_icon_on_home_page() {
        JSUtils.clickElementByJS(homepage.account_menu);
        Driver.wait(1);

    }
    @When("ML patient clicks on the sign in link on login page")
    public void ml_patient_clicks_on_the_sign_in_link_on_login_page() {
        JSUtils.clickElementByJS(homepage.linkLogin);
        Driver.wait(1);



    }
    @When("ML patient enters the username {string} on login page")
    public void ml_patient_enters_the_username_on_login_page(String username) {
        loginPage.inputUsername.sendKeys(username);

    }
    @When("ML patient enters the password {string} on login page")
    public void ml_patient_enters_the_password_on_login_page(String password) {
        loginPage.inputPassword.sendKeys(password);

    }
    @When("ML patient clicks the sign in button")
    public void ml_patient_clicks_the_sign_in_button() {
        JSUtils.clickElementByJS(loginPage.btnSignin);

    }
    @When("ML patient clicks my pages select make an appointment")
    public void ml_patient_clicks_my_pages_select_make_an_appointment() {
        JSUtils.clickElementByJS(patientAppointmentPage.myPagePatient);
        ReusableMethods.waitFor(1);
        JSUtils.clickElementByJS(patientAppointmentPage.makeAnAppointment);



    }
    @And("ML patient enter first name {string}")
    public void mlPatientEnterFirstName(String firstname) {
       firstname = faker.name().firstName();
       patientAppointmentPage.firstnameBox.sendKeys(firstname);
    }
    @And("Ml patent enter last name {string}")
    public void mlPatentEnterLastName(String lastname) {

       lastname = faker.name().lastName();
       patientAppointmentPage.lastnameBox.sendKeys(lastname);

    }
    @And("ML patient enter ssn {string}")
    public void mlPatientEnterSsn(String SSN) {
        SSN = faker.idNumber().ssnValid();
        patientAppointmentPage.ssnBox.sendKeys(SSN);

    }

    @And("ML patient enter email {string}")
    public void mlPatientEnterEmail(String email) {
        email = faker.internet().emailAddress();
        patientAppointmentPage.emailBox.sendKeys(email);

    }
    @And("ML patient enter phone {string}")
    public void mlPatientEnterPhone(String phone) {
        phone = faker.phoneNumber().cellPhone();
        patientAppointmentPage.phoneBox.sendKeys(phone);

    }
    @And("ML patient enter appointment date time {string}")
    public void mlPatientEnterAppointmentDateTime(String date) {
       patientAppointmentPage.dateBox.sendKeys(date);




    }
    @When("ML patient click send an appointment request")
    public void ml_patient_click_send_an_appointment_request() {
        JSUtils.clickElementByJS(patientAppointmentPage.requestButton);
        Assert.assertTrue(Driver.waitForVisibility(patientAppointmentPage.appointmentSuccessAlert, 5).isDisplayed());


    }




}

