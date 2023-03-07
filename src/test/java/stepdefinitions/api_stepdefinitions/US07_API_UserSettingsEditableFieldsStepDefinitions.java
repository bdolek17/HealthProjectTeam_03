package stepdefinitions.api_stepdefinitions;

import api.pojos.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.ApiUtilities;
import utilities.JSONUtils;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.responseMedunna;
import static utilities.ApiUtilities.specMedunna;

public class US07_API_UserSettingsEditableFieldsStepDefinitions {
    //Response response;
    User user;
    @Given("user sets the request specification")
    public void user_sets_the_request_specification() {
        ApiUtilities.setSpecWithAuthorization();
    }
    @When("user sends GET request to {string} with {string} query string and gets the response")
    public void user_sends_get_request_to_with_query_string_and_gets_the_response(String endpointParam, String queryStringValue) {
        specMedunna.pathParam("endpoint",endpointParam);
        responseMedunna=given().spec(specMedunna)
                .queryParam("ssn",queryStringValue)
                .when()
                .get("{endpoint}");

        responseMedunna.prettyPrint();
    }
    @Then("user verifies status code is {int}")
    public void user_verifies_status_code_is(Integer statusCode) {
        Assert.assertEquals((int)statusCode,responseMedunna.statusCode());
    }
    @Then("user verifies then firstname field has {string} value")
    public void user_verifies_then_firstname_field_has_value(String expectedValue) {
        user= JSONUtils.convertJsonToJavaObject(responseMedunna.asString(), User.class);
        Assert.assertEquals(expectedValue,user.getFirstName());
    }

    @Then("user verifies then lastname field has {string} value")
    public void user_verifies_then_lastname_field_has_value(String expectedValue) {
        user= JSONUtils.convertJsonToJavaObject(responseMedunna.asString(), User.class);
        Assert.assertEquals(expectedValue,user.getLastName());
    }
}
