package stepdefinitions.ui_stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ConfigReader;
import utilities.Driver;

import static io.restassured.RestAssured.given;

public class CommonStepDefinitions {

    @Given("user is on medunna home page")
    public void user_is_on_medunna_home_page()  {
        Driver.getDriver().get(ConfigReader.getProperty("health_project_url"));
    }

    @Then("close the application")
    public void close_the_application() throws InterruptedException {
        Driver.closeDriver();
    }
    @Then("wait {int} seconds and close the browser")
    public void wait_seconds_and_close_the_browser(int waitBeforeClose) {
        Driver.wait(waitBeforeClose);
        Driver.closeDriver();
    }

}
