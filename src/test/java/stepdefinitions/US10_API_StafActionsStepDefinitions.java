package stepdefinitions;

import api.pojos.Patient;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.JSONUtils;

import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static utilities.RequestSpec.specMedunna;
import static stepdefinitions.StepDefinitionsUtilities.responseMedunna;

public class US10_API_StafActionsStepDefinitions {

    @When("user sends GET request to {string} with {string} id as spec param and gets the response")
    public void user_sends_get_request_to_with_id_as_spec_param_and_gets_the_response(String endpointParam, String paramValue) {
        specMedunna.pathParams("first",endpointParam,"second",paramValue);
        responseMedunna=given().spec(specMedunna).when().get("{first}/{second}");
        responseMedunna.prettyPrint();
    }
    @Then("user verifies that status code is {int} and patient informations have {string} {string} {string} {string} values")
    public void user_verifies_that_status_code_is_and_patient_informations_have_values(Integer statusCode, String id, String ssn, String email, String login) {
        Assert.assertEquals((int)statusCode,responseMedunna.statusCode());

        JsonPath patientActual=responseMedunna.jsonPath();

        Assert.assertEquals(id,patientActual.getString("id"));
        Assert.assertEquals(ssn,patientActual.getString("user.ssn"));
        Assert.assertEquals(email,patientActual.get("email"));
        Assert.assertEquals(login,patientActual.get("user.login"));

    }

    @Then("user verifies that patient informations have {int} as id {string} as email {string} as login values")
    public void user_verifies_that_patient_informations_have_as_id_as_email_as_login_values(Integer id, String email, String login) {
        //response is an array !!
        JSONArray itemArray = new JSONArray(responseMedunna.asString());
        JSONObject patientActual = itemArray.getJSONObject(0);

        Integer ID=patientActual.getInt("id");

        Assert.assertEquals(id,ID);
        Assert.assertEquals(email,patientActual.get("email"));
        JSONObject user = patientActual.getJSONObject("user");
        Assert.assertEquals(login,user.get("login"));
    }

}
