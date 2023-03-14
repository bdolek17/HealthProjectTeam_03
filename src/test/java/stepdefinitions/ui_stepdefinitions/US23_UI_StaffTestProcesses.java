package stepdefinitions.ui_stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SearchPatientPage;
import utilities.Driver;
import utilities.PatientWebTable;

import java.util.Map;

public class US23_UI_StaffTestProcesses {

    SearchPatientPage searchPatient=new SearchPatientPage();

    By locatorTableHeader=By.xpath("//table//thead//tr");
    By locatorTableBody=By.xpath("//table//tbody//tr");
    PatientWebTable patientsListWebTable=null;
    Map<String,WebElement> foundPatientDataRow=null;
    //Map<String, Map<String,WebElement>> patientDataRows=null;  //Map<patientid, Map<columnname,columnnCell>>
    @When("user enters the ssn {string} on patient search page")
    public void user_enters_the_ssn_on_patient_search_page(String ssn) {
        Driver.waitAndSendText(searchPatient.inputSearchSSN,ssn);
        Driver.wait(2);
    }
    @Then("Verify that patient found and has information as {string} {string} {string} {string}")
    public void verify_that_patient_found_and_has_information_as(String id, String ssn, String firstname, String lastname) {

        By locatorTableHeader=By.xpath("//table//thead//tr");
        By locatorTableBody=By.xpath("//table//tbody//tr");
        patientsListWebTable=new PatientWebTable(locatorTableHeader,locatorTableBody);

        patientsListWebTable.loadCurrentPage(Driver.getDriver().findElements(locatorTableBody)); //load current page
        Map<String, Map<String,WebElement>> patientsData=patientsListWebTable.getWebTableData();   //get list loaded until now
        if(patientsData.size()<1){
            Assert.fail("Could Not Find the Patient with SSN Id ["+ssn+"]");
        }
        else{
            Map<String,WebElement> foundPatient=patientsData.get(id);
            Assert.assertEquals(id,foundPatient.get("ID").getText());
            Assert.assertEquals(ssn,foundPatient.get("SSN").getText());
            Assert.assertEquals(firstname,foundPatient.get("First Name").getText());
            Assert.assertEquals(lastname,foundPatient.get("Last Name").getText());
        }
    }

    @When("Verify that patient has been found with patient id {string}")
    public void verify_that_patient_has_been_found_with_patient_id(String patientId) {

        patientsListWebTable=new PatientWebTable(locatorTableHeader,locatorTableBody);

        patientsListWebTable.loadCurrentPage(Driver.getDriver().findElements(locatorTableBody)); //load current page
        Map<String, Map<String,WebElement>> patientDataRows=patientsListWebTable.getWebTableData();   //get all rows (normally only one)  //Map<patientid, Map<columnname,columnnCell>>

        foundPatientDataRow=patientDataRows.get(patientId);

        Assert.assertTrue(foundPatientDataRow!=null);

    }
    @When("user clicks on Show Appointments button")
    public void user_clicks_on_show_appointments_button() {
        WebElement buttonsColumn=foundPatientDataRow.get("buttons");
        Driver.wait(1);
        WebElement showAppointmentsButton=buttonsColumn.findElements(By.tagName("a")).get(2);
        showAppointmentsButton.click();
        Driver.wait(1);
    }
    @When("user clicks on Show Tests button of appointment id {string}")
    public void user_clicks_on_show_tests_button_of_appointment_id(String appointmentId) {

        patientsListWebTable=new PatientWebTable(locatorTableHeader,locatorTableBody);

        patientsListWebTable.loadCurrentPage(Driver.getDriver().findElements(locatorTableBody)); //load current page
        Map<String, Map<String,WebElement>> appointmentDataRows=patientsListWebTable.getWebTableData();   //get all rows (normally only one)  //Map<patientid, Map<columnname,columnnCell>>


        Map<String, WebElement> foundAppointmentDataRow=appointmentDataRows.get(appointmentId);

        WebElement buttonsColumn=foundAppointmentDataRow.get("buttons");
        Driver.wait(1);
        WebElement showTestsButton=buttonsColumn.findElements(By.tagName("a")).get(1);
        showTestsButton.click();


    }
    @When("user clicks on View Results button of test id {string}")
    public void user_clicks_on_view_results_button_of_test_id(String testId) {
        patientsListWebTable=new PatientWebTable(locatorTableHeader,locatorTableBody);

        patientsListWebTable.loadCurrentPage(Driver.getDriver().findElements(locatorTableBody)); //load current page
        Map<String, Map<String,WebElement>> testDataRows=patientsListWebTable.getWebTableData();   //get all rows (normally only one)  //Map<patientid, Map<columnname,columnnCell>>


        Map<String, WebElement> foundTestDataRow=testDataRows.get(testId);

        WebElement buttonsColumn=foundTestDataRow.get("buttons");
        Driver.wait(1);
        WebElement viewResults=buttonsColumn.findElements(By.tagName("a")).get(0);
        viewResults.click();
    }
    @Then("verify that test results has test items")
    public void verify_that_test_results_has_test_items() {
        patientsListWebTable=new PatientWebTable(locatorTableHeader,locatorTableBody);

        patientsListWebTable.loadCurrentPage(Driver.getDriver().findElements(locatorTableBody)); //load current page
        Map<String, Map<String,WebElement>> testResultsDataRows=patientsListWebTable.getWebTableData();

        Assert.assertTrue(testResultsDataRows.size()>0);

    }
}
