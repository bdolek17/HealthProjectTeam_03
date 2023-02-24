package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.MedunnaAuthentication.generateToken;

public class US11_API_TC01 {

    Response response;
    @Given("the doctor sends GET requests to the {string}")
    public void the_doctor_sends_get_requests_to_the(String string) {
        response = given().headers(
                "Authorization",
                "Bearer " + generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).when().get(string);

        response.prettyPrint();


    }
    @Then("Http Status Code should be {int}")
    public void http_status_code_should_be(Integer int1) {
        assertEquals((int)int1, response.getStatusCode());
    }

    @Then("doctor can see their appointments list and time slots")
    public void doctor_can_see_their_appointments_list_and_time_slots() {
        US11_API_TC01 appointmentPojo= new US11_API_TC01();
        US11_API_TC01 actualPojo= response.as(US11_API_TC01.class);


    }
    @Then("the doctor can see patient id, start date, end date, status...")
    public void the_doctor_can_see_patient_id_start_date_end_date_status() {

    }



}


