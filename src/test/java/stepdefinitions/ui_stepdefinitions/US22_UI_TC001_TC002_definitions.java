package stepdefinitions.ui_stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.LoginPage;
import pages.PatientAppointmentPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US22_UI_TC001_TC002_definitions {

    HomePage homepage = new HomePage();
    LoginPage loginPage = new LoginPage();

    PatientAppointmentPage patientAppointmentPage = new PatientAppointmentPage();

    @Given("staff is on {string} page")
    public void staff_is_on_page(String string) {
        Driver.getDriver().get(string);
        ReusableMethods.waitFor(1);

    }


    @When("staff clicks on the account menu icon on home page")
    public void staffClicksOnTheAccountMenuIconOnHomePage() {
        homepage.account_menu.click();
        ReusableMethods.waitFor(1);

    }


    @And("staff clicks on the sign in link on login page")
    public void staffClicksOnTheSignInLinkOnLoginPage() {

        homepage.linkLogin.click();
        ReusableMethods.waitFor(1);

    }


    @And("staff enters the username {string} on login page")
    public void staffEntersTheUsernameOnLoginPage(String string) {

        loginPage.inputUsername.sendKeys(string);
        ReusableMethods.waitFor(1);
    }


    @And("staff enters the password {string} on login page")
    public void staffEntersThePasswordOnLoginPage(String string) {

        loginPage.inputPassword.sendKeys(string);
        ReusableMethods.waitFor(1);
    }

    @And("staff clicks on sign in button on login page")
    public void staffClicksOnSignInButtonOnLoginPage() {
        loginPage.btnSignin.click();
        ReusableMethods.waitFor(1);

    }

    @And("staff clicks on My Pages icon on home page")
    public void staffClicksOnMyPagesIconOnHomePage() {
        homepage.linkMyPages.click();
        ReusableMethods.waitFor(1);
    }


    @And("staff clicks on search Patient")
    public void staffClicksOnSearchPatient() {
        homepage.linkSearchPatient.click();
        ReusableMethods.waitFor(1);
    }


    @And("staff enters SSN: {string} on the box")
    public void staffEntersSSNOnTheBox(String string) {
        patientAppointmentPage.inputSsn.sendKeys(string);
        ReusableMethods.waitFor(2);

    }

    @And("staff clicks on Show Appointments")
    public void staffClicksOnShowAppointments() {
        patientAppointmentPage.btnAppointments.click();
        ReusableMethods.waitFor(2);
    }

    @And("staff clicks on Edit")
    public void staffClicksOnEdit() {
        patientAppointmentPage.linkEdit.click();
        ReusableMethods.waitFor(2);

    }

    @And("staff clicks on start date time")
    public void staffClicksOnStartDateTime() {
        patientAppointmentPage.startDateTime.click();
    }


    @And("staff enters an appointment start date time: {string}")
    public void staffEntersAnAppointmentStartDateTime(String startDateTime) {

        Driver.waitAndSendText(patientAppointmentPage.startDateTime, startDateTime);
        patientAppointmentPage.startDateTime.sendKeys("09:10 AM");

    }


    @And("staff enters an appointment end date time: {string}")
    public void staffEntersAnAppointmentEndDateTime(String endDateTime) {
        Driver.waitAndSendText(patientAppointmentPage.endDateTime, endDateTime);
        patientAppointmentPage.endDateTime.sendKeys("10:17 PM");


    }

    @And("staff can select status as {string} , {string} , {string} but can not select as {string}")
    public void staffCanSelectStatusAsButCanNotSelectAs(String arg0, String arg1, String arg2, String arg3) {
       Driver.selectAnItemFromDropdown(patientAppointmentPage.appointmentStatusDropdown, "UNAPPROVED");
        Driver.selectAnItemFromDropdown(patientAppointmentPage.appointmentStatusDropdown, "PENDING");
        Driver.selectAnItemFromDropdown(patientAppointmentPage.appointmentStatusDropdown, "CANCELLED");

      //  Select select = new Select(patientAppointmentPage.appointmentStatusDropdown);
       // Assert.assertFalse(select.getOptions().contains("COMPLETED")); //contains("COMPLETED"));


        ReusableMethods.waitForVisibility(patientAppointmentPage.appointmentStatusDropdown,10);
        Select selectStatus = new Select(patientAppointmentPage.appointmentStatusDropdown);
        List<WebElement> options = selectStatus.getOptions();
        List<String> optionValues = new ArrayList<>();

        for(WebElement e: options){
            optionValues.add(e.getText());
        }

        //Assert that select has number of options with the same number of given options
       // Assert.assertEquals(4,options.size());

      //  Assert.assertTrue(optionValues.contains("UNAPPROVED"));
      //  Assert.assertTrue(options.get(0).isEnabled());

     //   Assert.assertTrue(optionValues.contains("PENDING"));
     //   Assert.assertTrue(options.get(1).isEnabled());

        Assert.assertTrue(optionValues.contains("COMPLETED"));
        //Assert that user can not choose completed
        Assert.assertFalse(options.get(2).isEnabled());

   //     Assert.assertTrue(optionValues.contains("CANCELLED"));
   //     Assert.assertTrue(options.get(3).isEnabled());





    }

    @And("staff can select the doctor")
    public void staffCanSelectTheDoctor() {
        Driver.selectAnItemFromDropdown(patientAppointmentPage.selectPhysician, "1311:doctor jim:PATHOLOGY");
        ReusableMethods.waitFor(2);

    }

    @And("staff can click to Save button")
    public void staffCanClickToSaveButton() {

        patientAppointmentPage.clickBtnSave.click();
        System.out.println("It should not save because the status is already set as Completed.I am not allowed to change it");

    }

    @And("staff enters SSN: {string} on the box again")
    public void staffEntersSSNOnTheBoxAgain(String string) {
        patientAppointmentPage.inputSsn.sendKeys(string);
        ReusableMethods.waitFor(1);

    }

    @And("staff clicks on Show Appointments again")
    public void staffClicksOnShowAppointmentsAgain() {
        patientAppointmentPage.btnAppointments.click();
        ReusableMethods.waitFor(1);

    }

    @And("staff clicks Show Test button")
    public void staffClicksShowTestButton() {
        patientAppointmentPage.showTestbtn.click();
        ReusableMethods.waitFor(1);

    }

    @And("staff clicks on  View Result")
    public void staffClicksOnViewResult() {
        patientAppointmentPage.viewResult.click();
        ReusableMethods.waitFor(1);

    }
}