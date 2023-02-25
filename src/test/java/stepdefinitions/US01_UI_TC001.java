package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.Driver;

public class US01_UI_TC001 {
    @Given("the user is on {string} registration pages")
    public void the_user_is_on_registration_pages(String url1) {
        Driver.getDriver().get(url1);
    }
    @When("user clicks on the account menu icons")
    public void user_clicks_on_the_account_menu_icons() {

    }
    @When("user clicks on the sign in link on registration pages")
    public void user_clicks_on_the_sign_in_link_on_registration_pages() {

    }
    @When("user enters the valid {string} on registration pages")
    public void user_enters_the_valid_on_registration_pages(String string) {

    }
    @When("user enters the firstname on registration pages")
    public void user_enters_the_firstname_on_registration_pages() {

    }
    @When("user enters the lastname on registration pages")
    public void user_enters_the_lastname_on_registration_pages() {

    }
    @When("user enters the username on registration pages")
    public void user_enters_the_username_on_registration_pages() {

    }
    @When("user enters the email on registration pages")
    public void user_enters_the_email_on_registration_pages() {

    }
    @When("user enters the password on registration pages")
    public void user_enters_the_password_on_registration_pages() {

    }
    @When("user enters the confirmation password on registration pages")
    public void user_enters_the_confirmation_password_on_registration_pages() {

    }
    @When("user clicks on register buttons")
    public void user_clicks_on_register_buttons() {

    }
    @Then("user should see {string} message on the pages")
    public void user_should_see_message_on_the_pages(String string) {

    }

}
