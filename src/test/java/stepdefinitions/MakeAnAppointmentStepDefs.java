package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.MakeAppointmentPage;
import pages.PatientViewPage;
import pages.PatientsPage;
import utilities.Driver;

public class MakeAnAppointmentStepDefs {

   MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage();
   PatientsPage patientsPage = new PatientsPage();


   @Given("user iss on {string} page")
   public void userIssOnPage(String health_project_url) {
      Driver.getDriver().get(health_project_url);
   }
   @When("user click on my pages")
   public void user_click_on_my_pages() {
      patientsPage.myPages.click();
   }
   @When("user click make an appointment")
   public void user_click_make_an_appointment() {
      patientsPage.makeApp.click();
   }
   @When("user enters the phone {string}")
   public void user_enters_the_phone(String phone) {
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

//   @Given("user is on {string} page")
//   public void user_is_on_page(String string) {
//
//    @When("user click on my pages")
//    public void user_click_on_my_pages(); {
//       patientsPage.myPages.click();
//
//    }
//    @When("user click make an appointment")
//    public void user_click_make_an_appointment() {
//       patientsPage.makeApp.click();
//
//    }
//    @When("user enters the phone {string}")
//    public void user_enters_the_phone_number(String phone) {
//       makeAppointmentPage.phone.sendKeys(phone);
//
//    }
//    @When("user enters date {string}")
//    public void user_enters_date(String app_date) {
//       makeAppointmentPage.app_date.sendKeys(app_date);
//
//
//    }
//    @When("user clicks send a request button")
//    public void user_clicks_send_a_request_button() {
//       makeAppointmentPage.appRequest.submit();
//
//    }
//
//}

