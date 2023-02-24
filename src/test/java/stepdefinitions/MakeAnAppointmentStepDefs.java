package stepdefinitions;

import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.MakeAppointmentPage;
import pages.PatientViewPage;
import pages.PatientsPage;

public class MakeAnAppointmentStepDefs {

 MakeAppointmentPage makeAppointmentPage=new MakeAppointmentPage();
 PatientsPage patientsPage=new PatientsPage();

    @When("user click on my pages")
    public void user_click_on_my_pages() {
       patientsPage.myPages.click();

    }
    @When("user click make an appointment")
    public void user_click_make_an_appointment() {
       patientsPage.makeApp.click();

    }
    @When("user enters the phone {string}")
    public void user_enters_the_phone_number(String phone) {
       makeAppointmentPage.phone.sendKeys(phone);

    }
    @When("user enters date {string}")
    public void user_enters_date(String app_date) {
       makeAppointmentPage.app_date.sendKeys(app_date);


    }
    @When("user clicks send a request button")
    public void user_clicks_send_a_request_button() {
       makeAppointmentPage.appRequest.submit();

    }

}
