package stepdefinitions.api_stepdefinitions;

import api.pojos.PatientS;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.ApiUtilities;
import utilities.JSONUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.responseMedunna;
import static utilities.ApiUtilities.specMedunna;

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


    @When("user sends GET request to {string} endpoint with {string} id and gets the response")
    public void user_sends_get_request_to_endpoint_with_id_and_gets_the_response(String endpointParam, String patientId) {
        ApiUtilities.setSpecWithAuthorization();
        specMedunna.pathParams("first",endpointParam,"second",patientId);
        responseMedunna=given().spec(specMedunna).when().get("{first}/{second}");
        responseMedunna.prettyPrint();


    }
    @Then("user verifies the patient informations")
    public void user_verifies_the_patient_informations(DataTable dataTable) {
        Map<String,String> expectedData=dataTable.asMap(String.class,String.class);
        PatientS actualData= JSONUtils.convertJsonToJavaObject(responseMedunna.asString(), PatientS.class);

        Assert.assertEquals(expectedData.get("id"),actualData.getId());
        Assert.assertEquals(expectedData.get("firstName"),actualData.getFirstName());
        Assert.assertEquals(expectedData.get("lastName"),actualData.getLastName());
        Assert.assertEquals(expectedData.get("phone"),actualData.getPhone());
        Assert.assertEquals(expectedData.get("ssn"),actualData.getUser().getSsn());
        Assert.assertEquals(expectedData.get("gender"),actualData.getGender());
        Assert.assertEquals(expectedData.get("email"),actualData.getEmail());
        Assert.assertEquals(expectedData.get("bloodGroup"),actualData.getBloodGroup());
        Assert.assertEquals(expectedData.get("birthDate"),actualData.getBirthDate());
        Assert.assertEquals(expectedData.get("country"),actualData.getCountry().getName());
        Assert.assertEquals(expectedData.get("description"),actualData.getDescription());
        Assert.assertEquals(expectedData.get("state_city"),actualData.getCstate().getName());
        Assert.assertEquals(expectedData.get("adress"),actualData.getAdress());
    }

}
