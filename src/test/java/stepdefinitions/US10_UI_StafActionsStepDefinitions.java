package stepdefinitions;

import api.pojos.CountryS;
import api.pojos.CstateS;
import api.pojos.PatientS;
import api.pojos.User;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.PatientEditPage;
import pages.PatientViewPage;
import pages.PatientsPage;
import utilities.Driver;
import utilities.JSUtils;

import java.util.List;

public class US10_UI_StafActionsStepDefinitions {
    HomePage homePage=new HomePage();
    PatientsPage patientsPage=new PatientsPage();
    PatientViewPage patientViewPage=new PatientViewPage();
    PatientEditPage patientEditPage=new PatientEditPage();

    PatientS patient=new PatientS();
    User user;
    CountryS country;
    CstateS cstate;

    @When("user clicks on the my pages menu link on home page")
    public void user_clicks_on_the_my_pages_menu_link_on_home_page() {
        Driver.waitAndClick(homePage.linkMyPages,1);
    }
    @When("user clicks on the search patient link on home page")
    public void user_clicks_on_the_search_patient_link_on_home_page() {
        Driver.waitAndClick(homePage.linkSearchPatient,1);
    }
    @When("Verify that staff in patients page")
    public void verify_that_staff_in_patients_page() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("search-patient"));
    }
    @When("Staff clicks first patient view button on the page")
    public void staff_clicks_first_patient_view_button_on_the_page() {
        List<WebElement> rows=Driver.getDriver().findElements(By.xpath("//table/tbody/tr"));
        if(rows.size()>0){
            List<WebElement> firstRowCols=rows.get(0).findElements(By.tagName("td"));  //do not use xpath, use tagName
            WebElement buttonsColumn= firstRowCols.get(firstRowCols.size()-1);
            WebElement viewButton=buttonsColumn.findElement(By.xpath("//a[contains(@href,'patient-detail')]"));
            WebElement editButton=buttonsColumn.findElement(By.xpath("//a[contains(@href,'patient-update')]"));
            WebElement showAppointmentsButton=buttonsColumn.findElement(By.xpath("//a[contains(@href,'patient-appointments')]"));

            //Read Row Values to verify
            patient.setId(firstRowCols.get(0).getText());
            patient.setSsn(firstRowCols.get(1).getText());
            patient.setFirstName(firstRowCols.get(2).getText());
            patient.setLastName(firstRowCols.get(3).getText());
            patient.setPhone(firstRowCols.get(5).getText());
            patient.setEmail(firstRowCols.get(6).getText());
            patient.setGender(firstRowCols.get(7).getText());
            patient.setBloodGroup(firstRowCols.get(8).getText());
            user=new User();user.setLogin(firstRowCols.get(12).getText());
            patient.setUser(user);

            Driver.waitAndClick(viewButton,2);

        }
    }
    @Then("Verify that staff is patient information page and views patient informations")
    public void verify_that_staff_is_patient_information_page_and_views_patient_informations() {
        Driver.wait(8);
        String expectedUrlContain="patient-detail/"+patient.getId();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedUrlContain));
        //Driver.wait(5);

        String pageSource=Driver.getDriver().getPageSource();
        //System.out.println(pageSource);

        Assert.assertTrue(pageSource.contains(patient.getSsn()));
        Assert.assertTrue(pageSource.contains(patient.getFirstName()));
        Assert.assertTrue(pageSource.contains(patient.getLastName()));
        Assert.assertTrue(pageSource.contains(patient.getEmail()));
        Assert.assertTrue(pageSource.contains(patient.getUser().getLogin()));
    }

    @When("Staff clicks search input box")
    public void staff_clicks_search_input_box() {
        Driver.waitAndClick(patientsPage.inputSearchBySsn,2);
    }
    @When("Staff enters patient {string} number to find patient")
    public void staff_enters_patient_number_to_find_patient(String ssn) {
        Driver.waitAndSendText(patientsPage.inputSearchBySsn,ssn,3);
    }
    @When("Verify that patient found")
    public void verify_that_patient_found() {
        Driver.wait(5);
        Assert.assertTrue(patientsPage.patientList.size()>0);
    }
    @When("Staff clicks patients view button with the ssn {string} on the page")
    public void staff_clicks_patients_view_button_with_the_ssn_on_the_page(String ssn) {

        if(patientsPage.patientList.size()>0){
            //there could be more than 1 record. (Normally there should be 1)
            //But datatable sometimes fails. So find spesific one
            WebElement buttonsColumn=patientsPage.patientList.get(0).findElements(By.tagName("td")).get(15);; //default
            for(WebElement row:patientsPage.patientList){
                List<WebElement> rowColumns=row.findElements(By.tagName("td"));
                if(rowColumns.get(1).getText().equals(ssn)){
                    buttonsColumn=rowColumns.get(rowColumns.size()-1);  //button column is the last column
                    //Read Row Values to verify
                    patient.setId(rowColumns.get(0).getText());
                    patient.setSsn(rowColumns.get(1).getText());
                    patient.setFirstName(rowColumns.get(2).getText());
                    patient.setLastName(rowColumns.get(3).getText());
                    patient.setPhone(rowColumns.get(5).getText());
                    patient.setEmail(rowColumns.get(6).getText());
                    patient.setGender(rowColumns.get(7).getText());
                    patient.setBloodGroup(rowColumns.get(8).getText());
                    user=new User();user.setLogin(rowColumns.get(12).getText());
                    patient.setUser(user);
                    break;
                }
            }

            WebElement viewButton=buttonsColumn.findElement(By.xpath("//a[contains(@href,'patient-detail')]"));

            Driver.waitAndClick(viewButton,2);

        }
    }

    @When("Staff clicks patients edit button with the ssn {string} on the page")
    public void staff_clicks_patients_edit_button_with_the_ssn_on_the_page(String ssn) {
        if(patientsPage.patientList.size()>0){
            WebElement buttonsColumn=patientsPage.patientList.get(0).findElements(By.tagName("td")).get(15);; //default
            for(WebElement row:patientsPage.patientList){
                List<WebElement> rowColumns=row.findElements(By.tagName("td"));
                //System.out.println(rowColumns.get(1).getText());
                String dataTableSSN=rowColumns.get(1).getText();
                if(rowColumns.get(1).getText().equals(ssn)){
                    buttonsColumn=rowColumns.get(rowColumns.size()-1);  //button column is the last column
                    //Read Row Values to verify
                    patient.setId(rowColumns.get(0).getText());

                    //WebElement editButton=buttonsColumn.findElement(By.xpath("(//div//a)[2]"));
                    //System.out.println(editButton.getAttribute("href"));

                    WebElement editButton=buttonsColumn.findElement(By.xpath("//a[contains(@href,'patient-update/"+patient.getId()+"')]"));
                    //System.out.println(editButton.getAttribute("href"));

                    JSUtils.clickElementByJS(editButton);

                    break;
                }
            }
        }
    }
    @Then("Verify that staff is on patient information edit page")
    public void verify_that_staff_is_on_patient_information_edit_page() {
        String updateUrl="patient-update/" + patient.getId();
        //System.out.println(Driver.getDriver().getCurrentUrl());
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(updateUrl));
        Driver.waitForVisibility(patientEditPage.inputFirstname,5);
        Assert.assertTrue(patientEditPage.inputFirstname.isDisplayed());

        //will be used to verify after edditing
        patient=new PatientS();
    }
    @Then("Staff enters the userid {string} on edit page")
    public void staff_enters_the_userid_on_edit_page(String id) {
        //patientEditPage.inputId.clear();
        Driver.waitAndSendText(patientEditPage.inputId,id);
        patient.setId(id);
        Driver.wait(30);
    }
    @Then("Staff enters the firstname {string} on edit page")
    public void staff_enters_the_firstname_on_edit_page(String firstname) {
        patientEditPage.inputFirstname.clear();
        Driver.waitAndSendText(patientEditPage.inputFirstname,firstname);
        patient.setFirstName(firstname);
    }
    @Then("Staff enters the lastname {string} on edit page")
    public void staff_enters_the_lastname_on_edit_page(String lastname) {
        patientEditPage.inputLastname.clear();
        Driver.waitAndSendText(patientEditPage.inputLastname,lastname);
        patient.setLastName(lastname);
    }
    @Then("Staff enters the birthdate {string} on edit page")
    public void staff_enters_the_birthdate_on_edit_page(String birthdate) {
        //System.out.println(patientEditPage.inputBirthDate.getAttribute("placeholder"));

        patientEditPage.inputBirthDate.clear();
        Driver.waitAndSendText(patientEditPage.inputBirthDate,birthdate);
        patientEditPage.inputBirthDate.sendKeys(Keys.TAB);
        patientEditPage.inputBirthDate.sendKeys("0245PM");   //dogum tarihinde saat mi olur arkadas ya
        patient.setBirthDate(birthdate);

    }
    @Then("Staff enters the email {string} on edit page")
    public void staff_enters_the_email_on_edit_page(String email) {
        patientEditPage.inputEmail.clear();
        Driver.waitAndSendText(patientEditPage.inputEmail,email);
        patient.setEmail(email);
    }
    @Then("Staff enters the phone {string} on edit page")
    public void staff_enters_the_phone_on_edit_page(String phone) {
        patientEditPage.inputPhone.clear();
        Driver.waitAndSendText(patientEditPage.inputPhone,phone);
        patient.setPhone(phone);
    }
    @Then("Staff enters the gender {string} on edit page")
    public void staff_enters_the_gender_on_edit_page(String gender) {
        Driver.selectByVisibleText(patientEditPage.selectGender,gender);
        patient.setGender(gender);
    }
    @Then("Staff enters the bloodgroup {string} on edit page")
    public void staff_enters_the_bloodgroup_on_edit_page(String bloodgroup) {
        Driver.selectByVisibleText(patientEditPage.selectBloodGroup,bloodgroup);
        patient.setBloodGroup(bloodgroup);
    }
    @Then("Staff enters the address {string} on edit page")
    public void staff_enters_the_address_on_edit_page(String address) {
        patientEditPage.inputAddress.clear();
        Driver.waitAndSendText(patientEditPage.inputAddress,address);
        patient.setAdress(address);
    }
    @Then("Staff enters the description {string} on edit page")
    public void staff_enters_the_description_on_edit_page(String description) {
        patientEditPage.inputDescription.clear();
        Driver.waitAndSendText(patientEditPage.inputDescription,description);
        patient.setDescription(description);
    }
    @Then("Staff enters the user {string} on edit page")
    public void staff_enters_the_user_on_edit_page(String userparam) {
        Driver.selectByVisibleText(patientEditPage.selectUser,userparam);
        user=new User();user.setLogin(userparam);
        patient.setUser(user);
    }
    @Then("Staff enters the country {string} on edit page")
    public void staff_enters_the_country_on_edit_page(String countryParam) {
        Driver.selectByVisibleText(patientEditPage.selectCountry,countryParam);
        country=new CountryS();country.setName(countryParam);
        patient.setCountry(country);
    }
    @Then("Staff enters the city_state {string} on edit page")
    public void staff_enters_the_city_state_on_edit_page(String state_city) {
        Driver.wait(3);
        //Driver.selectByVisibleText(patientEditPage.selectStateCity,state_city);
        cstate=new CstateS();cstate.setName(state_city);
        patient.setCstate(cstate);
        Driver.wait(30);
    }
    @Then("Staff clicks save button")
    public void staff_clicks_save_button() {
        Driver.waitAndClick(patientEditPage.btnSave);
        Driver.wait(30);
    }
    @Then("Verify patient information datas {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} on edit page")
    public void verify_patient_information_datas_on_edit_page(String id, String firstname, String lastname, String birthdate, String email, String phone, String gender, String bloodgroup, String address, String description, String user, String country, String state_city) {
        Assert.assertEquals(id,patientEditPage.inputId.getAttribute("value"));
        Assert.assertEquals(firstname,patientEditPage.inputFirstname.getAttribute("value"));
        Assert.assertEquals(lastname,patientEditPage.inputLastname.getAttribute("value"));
        //1977-02-02T02:45
        String dateAsString=birthdate.substring(4,8)+"-"+birthdate.substring(2,4)+"-"+birthdate.substring(0,2)+"T02:45";
        Assert.assertEquals(dateAsString,patientEditPage.inputBirthDate.getAttribute("value"));
        Assert.assertEquals(email,patientEditPage.inputEmail.getAttribute("value"));
        Assert.assertEquals(phone,patientEditPage.inputPhone.getAttribute("value"));
        Assert.assertEquals(gender,patientEditPage.selectGender.getText());
        Assert.assertEquals(bloodgroup,patientEditPage.selectBloodGroup.getText());
        Assert.assertEquals(address,patientEditPage.inputAddress.getAttribute("value"));
        Assert.assertEquals(description,patientEditPage.inputDescription.getAttribute("value"));
        Assert.assertEquals(user,patientEditPage.selectUser.getText());
        Assert.assertEquals(country,patientEditPage.selectCountry.getText());
        Assert.assertEquals(state_city,patientEditPage.selectStateCity.getText());

        Driver.wait(15);
    }

}
