package stepdefinitions.ui_stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import pages.ContactPage;
import pages.HomePage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class US27_UI_Contact {
    HomePage homePage=new HomePage();
    ContactPage contactPage=new ContactPage();
    Faker faker=new Faker();
    @Given("The user goes to {string} home page..")
    public void the_user_goes_to_home_page(String string) {
        Driver.getDriver().get(string);

    }
    @Given("The user clicks contact button..")
    public void the_user_clicks_contact_button() {
       //homePage.contactButton.click();
        JSUtils.clickElementByJS(homePage.contactButton);
        ReusableMethods.waitFor(2);
    }
    @Given("The user enter name..")
    public void the_user_enter_name() {
        contactPage.nameInput.sendKeys(faker.name().fullName());

    }
    @Given("The user enter email..")
    public void the_user_enter_email() {

        contactPage.emailInput.sendKeys(faker.internet().emailAddress());
    }
    @Given("The user enter subject.")
    public void the_user_enter_subject() {

        contactPage.subjectInput.sendKeys("important");
    }
    @Given("The user enter message.")
    public void the_user_enter_message() {
        contactPage.messageInput.sendKeys("Call me!!!");
        ReusableMethods.waitFor(2);

    }
    @Given("The user clicks send button.")
    public void the_user_clicks_send_button() {
       // contactPage.sendButton.click();
        JSUtils.clickElementByJS( contactPage.sendButton);
        ReusableMethods.waitFor(1);

    }
    @Given("The user should see {string}.")
    public void the_user_should_see(String string) {
        contactPage.sentMessage.isDisplayed();

    }

    @And("The user does not enter name..")
    public void theUserDoesNotEnterName() {
        contactPage.nameInput.sendKeys("");
        contactPage.emailInput.sendKeys(Keys.ENTER);
    }

    @Then("The user should see error message")
    public void theUserShouldSeeErrorMessage() {

        contactPage.invalidNameMessage.isDisplayed();
    }
}
