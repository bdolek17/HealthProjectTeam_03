package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.DoctorPatientPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;


import java.util.List;

public class US15_DoctorEditPatient_UI {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    DoctorPatientPage doctorPatientPage = new DoctorPatientPage();

    @Given("the doctor goes on {string} pagepage")
    public void the_doctor_goes_on_pagepage(String url) {
        Driver.getDriver().get(url);

    }
    @When("the doctor click on the account menu icon on home pagepage")
    public void the_doctor_click_on_the_account_menu_icon_on_home_pagepage() {
        homePage.account_menu.click();


    }
    @When("the doctor clicks on the sign in link on home pagepage")
    public void the_doctor_clicks_on_the_sign_in_link_on_home_pagepage() {
        homePage.linkLogin.click();

    }
    @When("the doctor enter the username {string} on login pagepage")
    public void the_doctor_enter_the_username_on_login_pagepage(String username) {
        loginPage.inputUsername.sendKeys(username);

    }
    @When("the doctor enter the password {string} on login page")
    public void the_doctor_enter_the_password_on_login_page(String password) {
        loginPage.inputPassword.sendKeys(password);

    }
    @Then("the doctor click on sign in button on login pagepage")
    public void the_doctor_click_on_sign_in_button_on_login_pagepage() {
        JSUtils.clickElementByJS(loginPage.btnSignin);

    }
    ///////
    @When("the doctor click inpatient on doctor pagepage")
    public void the_doctor_click_inpatient_on_doctor_pagepage() {
        JSUtils.clickElementByJS(doctorPatientPage.mypageDoctor);

        ReusableMethods.waitFor(3);
        //Select select = new Select(doctorPatientPage.myInpatient);
       // ReusableMethods.waitForVisibility(doctorPatientPage.myInpatient, 3);
       JSUtils.clickElementByJS(doctorPatientPage.myInpatient);
        //Assert.assertTrue(doctorPatientPage.inPatientMassage.isDisplayed());



    }
    @When("the doctor should see patient info on doctor pagepage")
    public void the_doctor_should_see_patient_info_on_doctor_pagepage() {
        doctorPatientPage.patientAppointmentsFrom.sendKeys("2023-02-23");
        doctorPatientPage.patientAppoinmentsTo.sendKeys("2023-03-08");
        JSUtils.clickElementByJS(doctorPatientPage.InpatientEdit);



    }
    @When("the doctor edit patient info on doctor pagepage")
    public void the_doctor_edit_patient_info_on_doctor_pagepage() {
        /*Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitForVisibility(doctorPatientPage.inpatientEditButton, 10);
        doctorPatientPage.inpatientEditButton.click();*/
        Assert.assertTrue(doctorPatientPage.createOrEditInpatientMassage.isDisplayed());

    }
    @When("the doctor should edit status info on doctor pagepage")
    public void the_doctor_should_edit_status_info_on_doctor_pagepage() {
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitForVisibility(doctorPatientPage.statusTab, 10);
        Select select = new Select(doctorPatientPage.statusTab);
        List<WebElement> status = select.getOptions();
        for (WebElement each : status){
            each.click();
        }
        //System.out.println("satatus");



    }
    @When("the doctor should edit patient room info on doctor pagepage")
    public void the_doctor_should_edit_patient_room_info_on_doctor_pagepage() {
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Select select = new Select(doctorPatientPage.roomTab);
        List<WebElement> rooms = select.getOptions();
        for( WebElement each: rooms){
            if (each.getText().contains("UNAVAILABLE")){
                each.click();
                break;
            }
        }

       //action.sendKeys(Keys.ARROW_DOWN);

        ReusableMethods.waitFor(10);

        JSUtils.clickElementByJS(doctorPatientPage.saveButtonEditPatient);

        ReusableMethods.waitFor(10);

       Assert.assertTrue(doctorPatientPage.saveMassageEditPatientInfo.isDisplayed());






    }




}
