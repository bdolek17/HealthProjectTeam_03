package stepdefinitions;

import api.pojos.US06_API_appointment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.MedunnaAuthentication.generateToken;

public class US06_API_TC01 {

    US06_API_appointment expectedBody=new US06_API_appointment();
    Response response;
    @Given("the users sends POST requests to the {string}")
    public void the_users_sends_post_requests_to_the(String url) {
        expectedBody.setEmail("dannie.kuhlman@gmail.com");
        expectedBody.setFirstName("arlena.johns");
        expectedBody.setLastName("etka");
        expectedBody.setSsn("571-22-0242\n");
        expectedBody.setBirthDate("2017-02-27T20:02:54.487Z");
        expectedBody.setStartDate("2023-02-27");
        expectedBody.setSnumber("52345");
        expectedBody.setPhone("445-556-2365");
        expectedBody.setAppoSpeciality("lkdfj");
        expectedBody.setGender("male");

        response = given().headers(
                "Authorization",
                "Bearer " + generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).body(expectedBody).when().post(url);

        response.prettyPrint();

    }
    @Then("Http Status Codde should bee {int}")
    public void http_status_codde_should_bee(Integer int1) {
        assertEquals((int)int1, response.getStatusCode());

    }
    @Then("userss can create new account successfully")
    public void userss_can_create_new_account_successfully() throws IOException {
      //  US06_API_appointment actualData = response.as(api.pojos.US06_API_appointment.class);
        ObjectMapper objectMapper = new ObjectMapper();
        US06_API_appointment actualData = objectMapper.readValue(response.asString(), US06_API_appointment.class);
        assertEquals(expectedBody.getEmail(),actualData.getEmail());
        assertEquals(expectedBody.getFirstName(),actualData.getFirstName());
        assertEquals(expectedBody.getLastName(),actualData.getLastName());
        assertEquals(expectedBody.getSsn(),actualData.getSsn());
        assertEquals(expectedBody.getPhone(),actualData.getPhone());

    }

}
