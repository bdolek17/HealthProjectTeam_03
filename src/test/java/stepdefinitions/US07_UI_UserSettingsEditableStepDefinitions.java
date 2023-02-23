package stepdefinitions;

import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.UserSettingsPage;
import utilities.Driver;

public class US07_UI_UserSettingsEditableStepDefinitions {
    HomePage homePage=new HomePage();
    UserSettingsPage settingsPage=new UserSettingsPage();
    @When("user enters new {string} firstname inputbox")
    public void user_enters_new_firstname_inputbox(String newFirstName) {
        settingsPage.inputFirstName.clear();
        Driver.waitAndSendText(settingsPage.inputFirstName,newFirstName);
    }
    @When("user clicks save button")
    public void user_clicks_save_button() {
        settingsPage.btnSave.click();
    }
    @When("user clicks on the sign out link on login page")
    public void user_clicks_on_the_sign_out_link_on_login_page() {
        Driver.waitForClickablility(homePage.accountMenuUserName,10);
        Driver.waitAndClick(homePage.linkSignout,3);
    }
    @When("verify firstname inputbox has {string} value")
    public void verify_firstname_inputbox_has_value(String newFirstname) {
        Assert.assertEquals(newFirstname,settingsPage.inputFirstName.getAttribute("value"));
    }

    @When("user enters new {string} lastname inputbox")
    public void user_enters_new_lastname_inputbox(String newLastname) {
        settingsPage.inputLastName.clear();
        Driver.waitAndSendText(settingsPage.inputLastName,newLastname);
    }
    @When("verify lastname inputbox has {string} value")
    public void verify_lastname_inputbox_has_value(String newLastName) {
        Assert.assertEquals(newLastName,settingsPage.inputLastName.getAttribute("value"));
    }

    @When("verify firstname is required message text visibility")
    public void verify_firstname_is_required_message_text_visibility() {
        Driver.waitForVisibility(settingsPage.firstNameIsRequiredMessageText,5);
        Assert.assertTrue(settingsPage.firstNameIsRequiredMessageText.isDisplayed());
    }

    @When("verify lastname is required message text visibility")
    public void verify_lastname_is_required_message_text_visibility() {
        Driver.waitForVisibility(settingsPage.lastNameIsRequiredMessageText,5);
        Assert.assertTrue(settingsPage.lastNameIsRequiredMessageText.isDisplayed());
    }
}
