package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.UserSettingsPage;
import utilities.Driver;

public class US07_UI_TestsStepDefinitions {
    HomePage homePage=new HomePage();
    UserSettingsPage settingsPage=new UserSettingsPage();

    @When("verify user logged in")
    public void verify_user_logged_in() {
        Driver.waitForClickablility(homePage.account_menu_user_id,3);
        String userName= homePage.account_menu_user_id.getText();
        Assert.assertTrue(userName.length()>0);
    }

    @When("user clicks on the settings link on login page")
    public void user_clicks_on_the_settings_link_on_login_page() {
        homePage.linkUserSettings.click();
    }
    @Then("user verifies firstname lastname and email")
    public void user_verifies_firstname_lastname_ans_email() {
        Assert.assertTrue(settingsPage.inputFirstName.getAttribute("value").length()>0);
        Assert.assertTrue(settingsPage.inputLastName.getAttribute("value").length()>0);
        Assert.assertTrue(settingsPage.inputEmail.getAttribute("value").length()>0);
    }

    //TC002
    @When("user clears firstname inputbox")
    public void user_clears_firstname_inputbox() {
        settingsPage.inputFirstName.click();
        settingsPage.inputFirstName.clear();
    }
    @When("user enters new {string} in firstname inputbox")
    public void user_enters_new_in_firstname_inputbox(String newFirstName) {
        settingsPage.inputFirstName.sendKeys(newFirstName);
    }
    @When("user clicks save button")
    public void user_clicks_save_button() {
        settingsPage.btnSave.click();
    }
    @When("user clicks on the sign out link on login page")
    public void user_clicks_on_the_sign_out_link_on_login_page() {
        Driver.waitForClickablility(homePage.account_menu_user_id,10);
        Driver.waitAndClick(homePage.linkSignout,3);
    }
    @When("verify firstname inputbox has {string} value")
    public void verify_firstname_inputbox_has_value(String newFirstname) {
        Assert.assertEquals(newFirstname,settingsPage.inputFirstName.getAttribute("value"));
    }

    //TC003
    @When("user clears lastname inputbox")
    public void user_clears_lastname_inputbox() {
        settingsPage.inputLastName.click();
        settingsPage.inputLastName.clear();
    }
    @When("user enters new {string} in lastname inputbox")
    public void user_enters_new_in_lastname_inputbox(String newLastname) {
        settingsPage.inputLastName.sendKeys(newLastname);
    }
    @When("verify lastname inputbox has {string} value")
    public void verify_lastname_inputbox_has_value(String newLastName) {
        Assert.assertEquals(newLastName,settingsPage.inputLastName.getAttribute("value"));
    }

}
