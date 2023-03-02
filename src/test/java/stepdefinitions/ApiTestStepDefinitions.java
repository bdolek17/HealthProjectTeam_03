package stepdefinitions;

import api.pojos.Account;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.responseMedunna;
import static utilities.ApiUtilities.specMedunna;

public class ApiTestStepDefinitions {
    Faker faker = new Faker();
    Response response;
    Account account;
    @Given("user sets the necessary path params")
    public void user_sets_the_necessary_path_params() {
        specMedunna.pathParams("first",  "register");
    }
    @Given("user sets the expected data")
    public void user_sets_the_expected_data() {
        account=new Account();
        account.setActivated(false);
        account.setCreatedBy("Shaban");
        account.setEmail("shaban@azak.com");
        account.setFirstName("Shaban");
        account.setLastName("Azak");
        account.setLogin("shabanazak.t03");
        account.setPassword("Shaban03+");
        account.setSsn("333-13-1101");
    }
    @When("user sends the POST request and gets the response")
    public void user_sends_the_post_request_and_gets_the_response() {
        response = given().spec(specMedunna).contentType(ContentType.JSON).body(account).when().post("/{first}");
        System.out.println(response.prettyPrint());
    }
    @Then("user validates api records")
    public void user_validates_api_records() {

    }

    @When("user sends GET request to get all {string} and gets the response")
    public void user_sends_get_request_to_all_and_gets_the_response(String endpoint) {
        specMedunna.pathParam("first",endpoint);
        responseMedunna=given().spec(specMedunna).when().get("{first}");
        responseMedunna.prettyPrint();
    }
}
