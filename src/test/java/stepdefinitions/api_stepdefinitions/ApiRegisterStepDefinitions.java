package stepdefinitions.api_stepdefinitions;

import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.responseMedunna;
import static utilities.ApiUtilities.specMedunna;

public class ApiRegisterStepDefinitions {

    @When("user sends POST request to {string} gets the response")
    public void user_sends_post_request_to_gets_the_response(String endpoint) {

        specMedunna.pathParams("first",endpoint);

        HashMap<String,Object> payloadValue=new HashMap<>();

        payloadValue.put("activated",true);
        payloadValue.put("email","staff11.t03@medunna.com");
        payloadValue.put("firstName","Team 03");
        payloadValue.put("lastName","03");
        payloadValue.put("login","staff11.t03");
        payloadValue.put("password","Team03+");
        payloadValue.put("ssn","333-33-5311");



        responseMedunna=given().spec(specMedunna).contentType(ContentType.JSON).body(payloadValue).when().post("{first}");
        responseMedunna.prettyPrint();

    }
}
