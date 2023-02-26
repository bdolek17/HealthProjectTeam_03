package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.PhysicianAppointmentPage;
import utilities.Driver;

public class US012_UI_TC012 {

HomePage homePage=new HomePage();
Driver driver;
PhysicianAppointmentPage physicianAppointmentPage=new PhysicianAppointmentPage();
    @When("user clicks on the my pages menu icon on home page")
    public void user_clicks_on_the_my_pages_menu_icon_on_home_page() {
    physicianAppointmentPage.myPages.click();

    }
    @When("user chooses {string} from dropdow")
    public void user_chooses_from_dropdow(String string) {
Driver.selectAnItemFromDropdown(physicianAppointmentPage.myPages,"My Appointments");
    }
    @When("user enter the dates to see appointments")
    public void user_enter_the_dates_to_see_appointments() {
physicianAppointmentPage.fromDate.sendKeys("2023-02-01");
physicianAppointmentPage.toDate.sendKeys("2023-02-15");
    }
    @When("user should click on edit button.")
    public void user_should_click_on_edit_button() {
physicianAppointmentPage.editButton.click();
    }
    @When("user type in Anamnesis")
    public void user_type_in_anamnesis() {
physicianAppointmentPage.anamnesis.sendKeys("");
    }
    @When("user type in Treatment")
    public void user_type_in_treatment() {
physicianAppointmentPage.treatment.sendKeys("");
    }
    @When("user type in Diagnosis")
    public void user_type_in_diagnosis() {
physicianAppointmentPage.diagnosis.sendKeys("");
    }
    @When("user chose status")
    public void user_chose_status() {
physicianAppointmentPage.status.click();
    }
    @Then("user click on save button")
    public void user_click_on_save_button() {
physicianAppointmentPage.saveButton1.click();
    }
}
