package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import pages.HomePage;
import pages.RegistrationPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.security.Key;

public class US01_UI_TC001 {
    HomePage homePage= new HomePage();
    RegistrationPage registrationPage=new RegistrationPage();
    Faker faker=new Faker();

    @Given("the user is on {string} registration pages")
    public void the_user_is_on_registration_pages(String url1) {

        Driver.getDriver().get(url1);
    }
    @When("user clicks on the account menu icons")
    public void user_clicks_on_the_account_menu_icons() {
        homePage.account_menu.click();

    }
    @When("user clicks on the sign in link on registration pages")
    public void user_clicks_on_the_sign_in_link_on_registration_pages() {

        homePage.linkRegister.click();
    }
    @When("user enters the valid {string} on registration pages")
    public void user_enters_the_valid_on_registration_pages(String string) {

        registrationPage.inputSSN.sendKeys("734-24-1187");
    }
    @When("user enters the firstname on registration pages")
    public void user_enters_the_firstname_on_registration_pages() {

        ReusableMethods.waitFor(2);
        registrationPage.inputFirstName.sendKeys(faker.name().firstName());
    }
    @When("user enters the lastname on registration pages")
    public void user_enters_the_lastname_on_registration_pages() {

        registrationPage.inputLastName.sendKeys(faker.name().lastName());
    }
    @When("user enters the username on registration pages")
    public void user_enters_the_username_on_registration_pages() {

        registrationPage.inputUserName.sendKeys(faker.name().username());
    }
    @When("user enters the email on registration pages")
    public void user_enters_the_email_on_registration_pages() {

        registrationPage.inputEmail.sendKeys(faker.internet().emailAddress());
    }
    @When("user enters the password on registration pages")
    public void user_enters_the_password_on_registration_pages() {

        registrationPage.inputFirstPassword.sendKeys("Unutma6.");
    }
    @When("user enters the confirmation password on registration pages")
    public void user_enters_the_confirmation_password_on_registration_pages() {

        registrationPage.inputSecondPassword.sendKeys("Unutma6.");
    }
    @When("user clicks on register buttons")
    public void user_clicks_on_register_buttons() {

        JSUtils.clickElementByJS(registrationPage.btnRegisterSubmit);
    }
    @Then("user should see {string} message on the pages")
    public void user_should_see_message_on_the_pages(String string) {

        ReusableMethods.waitFor(5);
        // Assert.assertEquals(string,registrationPage.registrationSaved);
           registrationPage.registrationSaved.isDisplayed();
    }
    //negative

    @And("user enters the without line {string}")
    public void userEntersTheWithoutLine(String arg0) {
        registrationPage.inputSSN.clear();
        registrationPage.inputSSN.sendKeys("358441177");
        registrationPage.inputFirstName.sendKeys(Keys.ENTER);
    }

    @And("user should be see error message")
    public void userShouldBeSeeErrorMessage() {
        ReusableMethods.waitFor(1);
        registrationPage.invalidSSNmessage.isDisplayed();
        
    }

    @And("user enters the missing {string} on registration pages")
    public void userEntersTheMissingOnRegistrationPages(String arg0) {
        registrationPage.inputSSN.clear();
        registrationPage.inputSSN.sendKeys("358-44-11");
        registrationPage.inputFirstName.sendKeys(Keys.ENTER);
    }

    @And("user should be see error{int} message")
    public void userShouldBeSeeErrorMessage(int arg0) {
        ReusableMethods.waitFor(2);
        registrationPage.invalidSSNmessage.isDisplayed();
    }
}
