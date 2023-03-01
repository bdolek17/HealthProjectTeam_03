package stepdefinitions;

import api.pojos.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.JSONUtils;
import utilities.RequestSpec;

import static io.restassured.RestAssured.given;
import static stepdefinitions.StepDefinitionsUtilities.responseMedunna;
import static utilities.RequestSpec.specMedunna;

public class US07_API_UserSettingsEditableFieldsStepDefinitions {
    //Response response;
    User user;
    @Given("user sets the request specification")
    public void user_sets_the_request_specification() {
        RequestSpec.setSpecWithAuthorization();
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
}
