package stepdefinitions.US05_TC_01;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class definitions {

    HomePage homepage = new HomePage();

    @Given("patientt is on {string} page")
    public void patientt_is_on_page(String string) {

    }
    @When("patientt clicks on the account menu icon on home page")
    public void patientt_clicks_on_the_account_menu_icon_on_home_page() {

    }
    @When("patientt clicks on the sign in link on login page")
    public void patientt_clicks_on_the_sign_in_link_on_login_page() {

    }
    @When("patientt enters the username {string} on login page")
    public void patientt_enters_the_username_on_login_page(String string) {

    }
}

