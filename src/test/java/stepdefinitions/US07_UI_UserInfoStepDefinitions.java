package stepdefinitions;

import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.UserSettingsPage;
import utilities.Driver;

public class US07_UI_UserInfoStepDefinitions {
    HomePage homePage=new HomePage();
    UserSettingsPage settingsPage=new UserSettingsPage();

    @When("user clicks on the settings link on login page")
    public void user_clicks_on_the_settings_link_on_login_page() {
        homePage.linkUserSettings.click();
    }

    @When("user verifies the setting page")
    public void user_verifies_the_setting_page() {
        Driver.waitForVisibility(settingsPage.settingsPageHeader,3);
        Assert.assertTrue(settingsPage.settingsPageHeader.isDisplayed());
    }
}
