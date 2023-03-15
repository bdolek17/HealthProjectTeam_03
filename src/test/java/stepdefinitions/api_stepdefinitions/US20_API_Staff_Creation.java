package stepdefinitions.api_stepdefinitions;

import api.pojos.US20_API_StaffCreation;
import api.pojos.US20_API_UserPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static utilities.MedunnaAuthentication.generateToken;

public class US20_API_Staff_Creation {

    @Given("admin sends post request for staff creation {string}")
    public void admin_sends_post_request_for_staff_creation(String string) {


        Response response;
            response = given().headers(
                    "Authorization",
                    "Bearer " + generateToken(),
                    "Content-Type", ContentType.JSON,
                    "Accept", ContentType.JSON
            ).when().get(string);

            response.prettyPrint();

        US20_API_StaffCreation expectedBody=new US20_API_StaffCreation();
        expectedBody.setFirstName("Patricia");
        expectedBody.setLastName("Cekrezi");
        expectedBody.setPhone(416557678);
        expectedBody.setSsn("455-66-9874");


        US20_API_UserPojo us20_api_userPojo=new US20_API_UserPojo();
        us20_api_userPojo.setActivated(true);
        us20_api_userPojo.setLogin("okey");
        us20_api_userPojo.setSsn("453-88-8984");



        }
    @Then("admin gets the staff data and validates")
    public void admin_gets_the_staff_data_and_validates() {

    }

}
