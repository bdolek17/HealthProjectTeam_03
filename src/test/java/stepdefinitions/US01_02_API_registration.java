package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import org.codehaus.jackson.map.ObjectMapper;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.MedunnaAuthentication.generateToken;

public class US01_02_API_registration {
    Response response;
  api.pojos.US01_02_API_registration expectedBody=new api.pojos.US01_02_API_registration();
    @Given("the user sends POST requests to the {string}")
    public void the_user_sends_post_requests_to_the(String url) {

        expectedBody.setActivated(true);
        expectedBody.setEmail("annazq@gmail.com");
        expectedBody.setFirstName("anaccikik");
        expectedBody.setPassword("Yeter12.");
        expectedBody.setSsn("906-99-5467");
        expectedBody.setLogin("anna_babacocuk");
        expectedBody.setLastName("birissi");




        response = given().headers(
                "Authorization",
                "Bearer " + generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).body(expectedBody).when().post(url);

        response.prettyPrint();
        //System.out.println(expectedBody);


    }
    @Then("Http Status Code should bee {int}")
    public void http_status_code_should_bee(Integer int1) {
        assertEquals((int)int1, response.getStatusCode());

    }
    @Then("user can create new account successfully")
    public void user_can_create_new_account_successfully() throws IOException {
        api.pojos.US01_02_API_registration actualData = response.as(api.pojos.US01_02_API_registration.class);
        assertEquals(expectedBody.getEmail(),actualData.getEmail());
        assertEquals(expectedBody.getFirstName(),actualData.getFirstName());
        assertEquals(expectedBody.getLogin(),actualData.getLogin());
        assertEquals(expectedBody.getPassword(),actualData.getPassword());
        assertEquals(expectedBody.getLastName(),actualData.getLastName());
        assertEquals(expectedBody.getSsn(),actualData.getSsn());



    }

}
