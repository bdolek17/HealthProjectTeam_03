package stepdefinitions.api_stepdefinitions;

import api.pojos.US01_API_registration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.MedunnaAuthentication.generateToken;

public class US01_API_TC001 {
    Response response;
    @Given("the user sends POST requests to the {string}")
    public void the_user_sends_post_requests_to_the(String url) {

        US01_API_registration expectedBody=new US01_API_registration(true,"can","2023-02-26T14:39:15.168Z",
                "az@gmail.com","ali",5,"bla","bibabi","can","2023-02-26T14:39:15.168Z",
                "neyse","a_ali","123.Kalem","456-85-9655");

        response = given().headers(
                "Authorization",
                "Bearer " + generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).when().body(expectedBody).post(url);

        response.prettyPrint();


    }
    @Then("Http Status Code should bee {int}")
    public void http_status_code_should_bee(Integer int1) {
        assertEquals((int)int1, response.getStatusCode());

    }
    @Then("user can create new account successfully")
    public void user_can_create_new_account_successfully() throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        US01_API_registration actualData = objectMapper.readValue(response.asString(),US01_API_registration.class);
       //assertEquals(actualData.getCreatedBy());


    }

}
