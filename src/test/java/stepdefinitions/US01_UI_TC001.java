package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegistrationPage;
import utilities.Driver;

public class US01_UI_TC001 {

    HomePage homePage=new HomePage();
    RegistrationPage registrationPage=new RegistrationPage();

    Faker faker = new Faker();


    @When("user clicks on the sign in link on registration page")
    public void user_clicks_on_the_sign_in_link_on_registration_page() {
        homePage.linkRegister.click();

    }



   @When("user enters the valid {string} on registration page")
   public void user_enters_the_valid_on_registration_page(String string) {
       registrationPage.inputSSN.sendKeys(string);

   }
    @When("user enters the firstname on registration page")
    public void user_enters_the_firstname_on_registration_page() {
        registrationPage.inputFirstName.sendKeys(faker.name().firstName());
    }
    @When("user enters the lastname on registration page")
    public void user_enters_the_lastname_on_registration_page() {
        registrationPage.inputLastName.sendKeys(faker.name().lastName());
    }
    @When("user enters the username on registration page")
    public void user_enters_the_username_on_registration_page() {
        registrationPage.inputUserName.sendKeys(faker.name().username());
    }
    @When("user enters the email on registration page")
    public void user_enters_the_email_on_registration_page() {
        registrationPage.inputEmail.sendKeys(faker.internet().emailAddress());
    }
    @When("user enters the password on registration page")
    public void user_enters_the_password_on_registration_page() {
        registrationPage.inputFirstPassword.sendKeys("Kabul01.");
    }
    @When("user enters the confirmation password on registration page")
    public void user_enters_the_confirmation_password_on_registration_page() {
        registrationPage.inputSecondPassword.sendKeys("Kabul01.");
    }
    @When("user clicks on register button")
    public void user_clicks_on_register_button() {
        registrationPage.btnRegisterSubmit.click();

    }
    @Then("user should see {string} message on the page")
    public void user_should_see_message_on_the_page(String string) {

    }


}
