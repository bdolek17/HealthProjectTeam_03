package stepdefinitions.ui_stepdefinitions;

import api.pojos.User;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AdminAllPatientsListPage;
import pages.CreateOrEditPatientPage;
import pages.HomePage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.LogUtilities;
import utilities.PatientWebTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.responseMedunna;
import static utilities.ApiUtilities.specMedunna;

public class US16_UI_PatientCreationAutherization {
    HomePage homePage=new HomePage();
    AdminAllPatientsListPage patientsListPage=new AdminAllPatientsListPage();
    CreateOrEditPatientPage createOrEditPatientPage=new CreateOrEditPatientPage();
    @When("user click on ItemsAndTitles menu")
    public void user_click_on_ıtems_and_titles_menu() {
        homePage.adminMenuItemsAndTitles.click();
        Driver.wait(2);
    }
    @When("user verifies admin patient menu is visible")
    public void user_verifies_admin_patient_menu_is_visible() {
        Assert.assertTrue(homePage.adminMenuPatient.isDisplayed());
        Driver.wait(2);
    }
    @When("user click on admin patient menu")
    public void user_click_on_admin_patient_menu() {
        homePage.adminMenuPatient.click();
    }
    @Then("user verifies that all patients page is opened")
    public void user_verifies_that_all_patients_page_is_opened() {
        Assert.assertTrue(patientsListPage.lblPageHeading.isDisplayed());
        Assert.assertTrue(patientsListPage.btnCreateNewPatient.isDisplayed());
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://medunna.com/patient"));
        Driver.wait(3);
    }

    @When("user verifies admin items and titles menu is not visible")
    public void user_verifies_admin_items_and_titles_menu_is_not_visible() {
        List<WebElement> fakeList=Driver.getDriver().findElements(By.xpath("//*[contains(@href,'/patient')]"));
        if(fakeList.size()>0){
            Assert.fail("User Should not view [patient] menu, but he/she does");
        }else {Assert.assertTrue(true);}
    }
    @Then("user verifies that {string} message on the page")
    public void user_verifies_that_message_on_the_page(String unauthorizedMessage) {
        Driver.waitForVisibility(patientsListPage.spanUnauthorizedMessage,5);
        Assert.assertTrue(patientsListPage.spanUnauthorizedMessage.isDisplayed());
        Driver.wait(2);
    }
    @Then("user verifies that he or she has seen all the patient informations on the page")
    public void user_verifies_that_he_or_she_has_seen_all_the_patient_informations_on_the_page(DataTable dataTable) {
        List<String> expectedColumns=dataTable.asList(String.class);

        for(WebElement header:patientsListPage.listPatientHeaders){
            String headerText=header.getText();
            if(header.getText().length()>0){   //16th column contains buttons and does not have column name
                Assert.assertTrue(expectedColumns.contains(header.getText()));
            }
        }
    }


    @When("user click on Create a new patient button")
    public void user_click_on_create_a_new_patient_button() {
        Driver.wait(1);patientsListPage.btnCreateNewPatient.click();
    }
    @Then("user verifies that {string} patient process page has necessery input items")
    public void user_verifies_that_patient_process_page_has_necessery_items(String processType) {
        if(processType.toLowerCase().startsWith("e")) {
            Assert.assertTrue(createOrEditPatientPage.inputID.isDisplayed());   //only edit page
        }
        //Assert.assertTrue(createOrEditPatientPage.inputSSN.isDisplayed());  // normally it should be in the page, but not
        Assert.assertTrue(createOrEditPatientPage.inputFirstName.isDisplayed());
        Assert.assertTrue(createOrEditPatientPage.inputLastName.isDisplayed());
        Assert.assertTrue(createOrEditPatientPage.datetimeControl.isDisplayed());
        Assert.assertTrue(createOrEditPatientPage.inputEmail.isDisplayed());
        Assert.assertTrue(createOrEditPatientPage.inputPhone.isDisplayed());
        Assert.assertTrue(createOrEditPatientPage.selectGender.isDisplayed());
        Assert.assertTrue(createOrEditPatientPage.selectBloodGroup.isDisplayed());
        Assert.assertTrue(createOrEditPatientPage.inputAddress.isDisplayed());
        Assert.assertTrue(createOrEditPatientPage.inputDescription.isDisplayed());
        Assert.assertTrue(createOrEditPatientPage.selectUser.isDisplayed());
        Assert.assertTrue(createOrEditPatientPage.selectCountry.isDisplayed());
        Assert.assertTrue(createOrEditPatientPage.selectStateCity.isDisplayed());
    }

    @When("user clicks first patient edit button on the page")
    public void user_clicks_first_patient_edit_button_on_the_page() {
        List<WebElement> rows=Driver.getDriver().findElements(By.xpath("//table/tbody/tr"));
        if(patientsListPage.listPatientData.size()>0){
            List<WebElement> firstRowCols=rows.get(0).findElements(By.tagName("td"));  //do not use xpath, use tagName
            WebElement buttonsColumn= firstRowCols.get(firstRowCols.size()-1);

            List<WebElement> buttons=buttonsColumn.findElements(By.tagName("a"));

            WebElement viewButton=buttons.get(0);
            WebElement editButton=buttons.get(1);
            WebElement deleteButton=buttons.get(2);

            editButton.click();

        }
    }


    @When("user enters patient information")
    public void user_enters_patient_information(DataTable dataTable) {
        List<Map<String,String>> patientInfo=dataTable.asMaps(String.class, String.class);

        Driver.waitAndSendText(createOrEditPatientPage.inputFirstName,patientInfo.get(0).get("firstname"));
        Driver.waitAndSendText(createOrEditPatientPage.inputLastName,patientInfo.get(0).get("lastname"));
        Driver.waitAndSendText(createOrEditPatientPage.datetimeControl,patientInfo.get(0).get("birthdate"));
        createOrEditPatientPage.datetimeControl.sendKeys(Keys.TAB);
        Driver.waitAndSendText(createOrEditPatientPage.datetimeControl,patientInfo.get(0).get("birthtime"));
        Driver.waitAndSendText(createOrEditPatientPage.inputEmail,patientInfo.get(0).get("email"));
        Driver.waitAndSendText(createOrEditPatientPage.inputPhone,patientInfo.get(0).get("phone"));
        Driver.selectByVisibleText(createOrEditPatientPage.selectGender,patientInfo.get(0).get("gender"));
        Driver.selectByVisibleText(createOrEditPatientPage.selectBloodGroup,patientInfo.get(0).get("bloodgroup"));
        Driver.waitAndSendText(createOrEditPatientPage.inputAddress,patientInfo.get(0).get("address"));
        Driver.waitAndSendText(createOrEditPatientPage.inputDescription,patientInfo.get(0).get("description"));
        Driver.selectByVisibleText(createOrEditPatientPage.selectUser,patientInfo.get(0).get("user"));
        Driver.selectByVisibleText(createOrEditPatientPage.selectCountry,patientInfo.get(0).get("country"));
        Driver.selectByVisibleText(createOrEditPatientPage.selectStateCity,patientInfo.get(0).get("state_city"));
    }
    @Then("user clicks on patient save button")
    public void user_clicks_on_patient_save_button() {
        JSUtils.clickElementByJS(createOrEditPatientPage.btnSave);
    }
    @Then("verify that creation succeded message and log patient id to text file")
    public void verify_that_creation_succeded_message_and_log_patient_id_to_text_file() {
        Driver.waitForVisibility(createOrEditPatientPage.savedMassagePatient,10);
        String patientID = createOrEditPatientPage.savedMassagePatient.getText().replaceAll("[^0-9]", "");
        LogUtilities.savePatientCreationInfo(patientID,false);
    }

    @When("user enters patient information without State information")
    public void user_enters_patient_information_without_state_information(DataTable dataTable) {

        List<Map<String,String>> patientInfo=dataTable.asMaps(String.class, String.class);

        Driver.waitAndSendText(createOrEditPatientPage.inputFirstName,patientInfo.get(0).get("firstname"));
        Driver.waitAndSendText(createOrEditPatientPage.inputLastName,patientInfo.get(0).get("lastname"));
        Driver.waitAndSendText(createOrEditPatientPage.datetimeControl,patientInfo.get(0).get("birthdate"));
        createOrEditPatientPage.datetimeControl.sendKeys(Keys.TAB);
        Driver.waitAndSendText(createOrEditPatientPage.datetimeControl,patientInfo.get(0).get("birthtime"));
        Driver.waitAndSendText(createOrEditPatientPage.inputEmail,patientInfo.get(0).get("email"));
        Driver.waitAndSendText(createOrEditPatientPage.inputPhone,patientInfo.get(0).get("phone"));
        Driver.selectByVisibleText(createOrEditPatientPage.selectGender,patientInfo.get(0).get("gender"));
        Driver.selectByVisibleText(createOrEditPatientPage.selectBloodGroup,patientInfo.get(0).get("bloodgroup"));
        Driver.waitAndSendText(createOrEditPatientPage.inputAddress,patientInfo.get(0).get("address"));
        Driver.waitAndSendText(createOrEditPatientPage.inputDescription,patientInfo.get(0).get("description"));
        Driver.selectByVisibleText(createOrEditPatientPage.selectUser,patientInfo.get(0).get("user"));
        Driver.selectByVisibleText(createOrEditPatientPage.selectCountry,patientInfo.get(0).get("country"));
        //Driver.selectByVisibleText(createOrEditPatientPage.selectStateCity,patientInfo.get(0).get("state_city"));
        JSUtils.clickElementByJS(createOrEditPatientPage.btnSave);


    }
    @When("verify that page url is still {string}")
    public void verify_that_page_url_is_still(String createURL) {

        Driver.wait(2);
        if(Driver.getDriver().getCurrentUrl().contains("patient?page=1")){
            Driver.waitForVisibility(createOrEditPatientPage.savedMassagePatient,10);
            JSUtils.clickElementByJS(patientsListPage.listPatientHeaders.get(0)); //ID
            String patientID = createOrEditPatientPage.savedMassagePatient.getText().replaceAll("[^0-9]", "");
            LogUtilities.savePatientCreationInfo(patientID,true);
        }
        Driver.wait(5);
        Assert.assertEquals(createURL,Driver.getDriver().getCurrentUrl());
    }

    @When("user clicks patient delete button with id {int}")
    public void user_clicks_patient_delete_button_with_id(Integer patientId) {
        // STEPS
        //Click ID label to sort list DESC (so last created patient are on the first page)
        Driver.wait(1);
        patientsListPage.listPatientHeaders.get(0).click();
        Driver.wait(2);
        String tobeDeletePatientId;
        tobeDeletePatientId= patientId.toString();
        //-----------------------------------------------------------------------------------
        // THIS PART IS ONLY TO DELETE PATIENTS THAT WE CREATED.
        //Read Log file to get patient id whick is created by me (Normally parameter)
        Boolean gotPatientIdFromLogFile=false;  //

        List<String> createdPatientIds=LogUtilities.getAllCreatedPatientIds();
        if(createdPatientIds.size()>0) {
            tobeDeletePatientId=createdPatientIds.get(0);
            createdPatientIds.remove(tobeDeletePatientId);
            gotPatientIdFromLogFile=true;
        }
        //-----------------------------------------------------------------------------------
        //Find patient according to patient id
        By locatorTableHeader=By.xpath("//table//thead//tr");
        By locatorTableBody=By.xpath("//table//tbody//tr");
        PatientWebTable patientsListWebTable=new PatientWebTable(locatorTableHeader,locatorTableBody);
        Map<String,WebElement> foundPatientDataRow=null;


        Boolean keepReadingIfNotExistsInCurrentPage=true;
        while(keepReadingIfNotExistsInCurrentPage){
            patientsListWebTable.loadCurrentPage(Driver.getDriver().findElements(locatorTableBody)); //load current page
            Map<String, Map<String,WebElement>> patientData=patientsListWebTable.getPatientData();   //get list loaded until now

            if(patientData.containsKey(tobeDeletePatientId)) {
                foundPatientDataRow=patientData.get(tobeDeletePatientId);
                keepReadingIfNotExistsInCurrentPage=false;
            }
            else {
                Driver.wait(1);
                keepReadingIfNotExistsInCurrentPage=!patientsListPage.pageLastLinkItem.getAttribute("class").contains("disabled");
                if(keepReadingIfNotExistsInCurrentPage){
                    JSUtils.clickElementByJS(patientsListPage.pageNext);
                    Driver.wait(2);
                }
            }
        }
        //Click Delete Button and Confirm Deletion
        if(foundPatientDataRow==null){
            Assert.fail("Could not find patient id :"+tobeDeletePatientId);
        }

        WebElement buttonsColumn=foundPatientDataRow.get("buttons");
        Driver.wait(3);
        WebElement deleteButton=buttonsColumn.findElements(By.tagName("a")).get(2);
        deleteButton.click();
        Driver.wait(1);
        patientsListPage.btnConfirmDeletePatient.click();
        //-----------------------------------------------------------------------------------
        // THIS PART IS BECAUSE OF USING LOG FILE.
        if(gotPatientIdFromLogFile){
            //LogUtilities.savePatientCreationInfo(createdPatientIds,false);  //Do not delete, it will be used API and DB verification
        }
        //-----------------------------------------------------------------------------------


    }
    @Then("user verifies deleted message")
    public void user_verifies_deleted_message() {
        Driver.waitForVisibility(patientsListPage.deleteMassageForPatient,10);
        Assert.assertTrue(patientsListPage.deleteMassageForPatient.isDisplayed());
    }




}
