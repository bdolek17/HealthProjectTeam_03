package stepdefinitions.ui_stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.CreateOrEditTestResultPage;
import pages.SearchPatientPage;
import pages.TestResultsPage;
import utilities.Driver;
import utilities.PatientWebTable;

import java.util.Map;

public class US23_UI_StaffTestProcesses {

    SearchPatientPage searchPatient=new SearchPatientPage();
    CreateOrEditTestResultPage testResultCreateOrEditPage=new CreateOrEditTestResultPage();
    TestResultsPage testResults=new TestResultsPage();

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

//    @When("Verify that patient has been found with patient id {string}")
//    public void verify_that_patient_has_been_found_with_patient_id(String patientId) {
//
//        patientsListWebTable=new PatientWebTable(locatorTableHeader,locatorTableBody);
//
//        patientsListWebTable.loadCurrentPage(Driver.getDriver().findElements(locatorTableBody)); //load current page
//        Map<String, Map<String,WebElement>> patientDataRows=patientsListWebTable.getWebTableData();   //get all rows (normally only one)  //Map<patientid, Map<columnname,columnnCell>>
//
//        foundPatientDataRow=patientDataRows.get(patientId);
//
//        Assert.assertTrue(foundPatientDataRow!=null);
//
//    }
    @When("user clicks on Show Appointments button of patient with patient id {string}")
    public void user_clicks_on_show_appointments_button_of_patient_with_patient_id(String patientId) {
        patientsListWebTable=new PatientWebTable(locatorTableHeader,locatorTableBody);

        patientsListWebTable.loadCurrentPage(Driver.getDriver().findElements(locatorTableBody)); //load current page
        Map<String, Map<String,WebElement>> patientDataRows=patientsListWebTable.getWebTableData();   //get all rows (normally only one)  //Map<patientid, Map<columnname,columnnCell>>

        foundPatientDataRow=patientDataRows.get(patientId);

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

    @When("user clicks on Edit button of Test Results Item with id {string}")
    public void user_clicks_on_edit_button_of_test_results_item_with_id(String testResultsItemId) {
        patientsListWebTable=new PatientWebTable(locatorTableHeader,locatorTableBody);

        patientsListWebTable.loadCurrentPage(Driver.getDriver().findElements(locatorTableBody)); //load current page
        Map<String,WebElement> testResultsItemDataRow=patientsListWebTable.getWebTableData().get(testResultsItemId);
        WebElement buttonsColumn=testResultsItemDataRow.get("buttons");
        Driver.wait(1);
        WebElement editResults=buttonsColumn.findElements(By.tagName("a")).get(0);
        editResults.click();

    }
    @Then("user verifies that Create or edit a Test Result is displayed")
    public void user_verifies_that_create_or_edit_a_test_result_is_displayed() {
        Assert.assertTrue(testResultCreateOrEditPage.inputId.isDisplayed());
        Assert.assertTrue(testResultCreateOrEditPage.inputDate.isDisplayed());
        Assert.assertTrue(testResultCreateOrEditPage.inputResult.isDisplayed());
        Assert.assertTrue(testResultCreateOrEditPage.inputResultCreatedDate.isDisplayed());
    }

    @Then("user enters valid data for Result {string} and {string} description")
    public void user_enters_valid_data_for_result_and_description(String result, String description) {
        testResultCreateOrEditPage.inputResult.clear();
        testResultCreateOrEditPage.inputDescription.clear();
        Driver.waitAndSendText(testResultCreateOrEditPage.inputResult,result);
        Driver.waitAndSendText(testResultCreateOrEditPage.inputDescription,description);
    }
    @Then("user clicks Save button")
    public void user_clicks_save_button() {
        Driver.waitAndClickElement(testResultCreateOrEditPage.btnSave,5);
        Driver.wait(2);
    }
    @Then("verify that a successfully saves message with text {string} for Test Results Item with id {string}")
    public void verify_that_a_successfully_saves_message_with_text_for_test_results_item_with_id(String message, String testItemId) {
        String fullMessage = message+ " "+testItemId;
        Driver.waitForVisibility(testResults.savedMassageForTestResult,10);
        Assert.assertTrue(testResults.savedMassageForTestResult.isDisplayed());
        Assert.assertEquals(fullMessage,testResults.savedMassageForTestResult.getText());

    }

    @When("user enters valid data for Date {string} and {string} time")
    public void user_enters_valid_data_for_date_and_time(String datePart, String timePart) {
        testResultCreateOrEditPage.inputDate.clear();
        Driver.waitAndSendText(testResultCreateOrEditPage.inputDate,datePart);
        testResultCreateOrEditPage.inputDate.sendKeys(Keys.TAB);
        Driver.waitAndSendText(testResultCreateOrEditPage.inputDate,timePart);
    }

    @When("user enters valid data for Created Date {string} and {string} Created time")
    public void user_enters_valid_data_for_created_date_and_created_time(String datePart, String timePart) {
        testResultCreateOrEditPage.inputResultCreatedDate.clear();
        Driver.waitAndSendText(testResultCreateOrEditPage.inputResultCreatedDate,datePart);
        testResultCreateOrEditPage.inputResultCreatedDate.sendKeys(Keys.TAB);
        Driver.waitAndSendText(testResultCreateOrEditPage.inputResultCreatedDate,timePart);
    }


}
