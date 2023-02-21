package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.Driver;


public class CommonStepDefinitions {
    @Given("user is on {string} page")
    public void user_is_on_page(String string)  {
        Driver.getDriver().get(string);
    }

    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }
}