package stepdefinitions;

import api.pojos.Patient;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.PatientViewPage;
import pages.PatientsPage;
import utilities.Driver;

import java.util.List;

public class US10_UI_StafActionsStepDefinitions {
    HomePage homePage=new HomePage();
    PatientsPage patientsPage=new PatientsPage();
    PatientViewPage patientViewPage=new PatientViewPage();

    Patient patient=new Patient();

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
            patient.setLogin(firstRowCols.get(12).getText());

            Driver.waitAndClick(viewButton,2);

        }
    }
    @Then("Verify that staff is patient information page and views patient informations")
    public void verify_that_staff_is_patient_information_page_and_views_patient_informations() {
        Driver.waitForPageToLoad(10);
        String expectedUrlContain="patient-detail/"+patient.getId();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedUrlContain));
        //Driver.wait(5);

        String pageSource=Driver.getDriver().getPageSource();
        //System.out.println(pageSource);

        Assert.assertTrue(pageSource.contains(patient.getSsn()));
        Assert.assertTrue(pageSource.contains(patient.getFirstName()));
        Assert.assertTrue(pageSource.contains(patient.getLastName()));
        Assert.assertTrue(pageSource.contains(patient.getEmail()));
        Assert.assertTrue(pageSource.contains(patient.getLogin()));
    }

    @When("Staff clicks search input box")
    public void staff_clicks_search_input_box() {
        Driver.waitAndClick(patientsPage.inputSearchBySsn,2);
    }
    @When("Staff enters patient {string} number to find patient")
    public void staff_enters_patient_number_to_find_patient(String ssn) {
        Driver.waitAndSendText(patientsPage.inputSearchBySsn,ssn,2);
    }
    @When("Verify that patient found")
    public void verify_that_patient_found() {
        Driver.waitForPageToLoad(5);
        Assert.assertTrue(patientsPage.patientList.size()>0);
    }
    @When("Staff clicks patients view button on the page")
    public void staff_clicks_patients_view_button_on_the_page() {
        if(patientsPage.patientList.size()>0){
            List<WebElement> foundRowCols=patientsPage.patientList.get(0).findElements(By.tagName("td"));  //do not use xpath, use tagName
            WebElement buttonsColumn= foundRowCols.get(foundRowCols.size()-1);
            WebElement viewButton=buttonsColumn.findElement(By.xpath("//a[contains(@href,'patient-detail')]"));

            //Read Row Values to verify
            patient.setId(foundRowCols.get(0).getText());
            patient.setSsn(foundRowCols.get(1).getText());
            patient.setFirstName(foundRowCols.get(2).getText());
            patient.setLastName(foundRowCols.get(3).getText());
            patient.setPhone(foundRowCols.get(5).getText());
            patient.setEmail(foundRowCols.get(6).getText());
            patient.setGender(foundRowCols.get(7).getText());
            patient.setBloodGroup(foundRowCols.get(8).getText());
            patient.setLogin(foundRowCols.get(12).getText());

            Driver.waitAndClick(viewButton,2);

        }
    }


}
