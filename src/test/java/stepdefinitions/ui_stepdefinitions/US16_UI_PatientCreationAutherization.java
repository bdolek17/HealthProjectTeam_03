package stepdefinitions.ui_stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AdminAllPatientsListPage;
import pages.HomePage;
import utilities.Driver;

import java.util.List;

public class US16_UI_PatientCreationAutherization {
    HomePage homePage=new HomePage();
    AdminAllPatientsListPage patientsListPage=new AdminAllPatientsListPage();
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

}
