package stepdefinitions.api_stepdefinitions;

import api.pojos.US17_API_Room;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;

import static base_urls.Medunna_Base_Url.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtilities.responseMedunna;
import static utilities.ApiUtilities.specMedunna;
import static utilities.AuthenticationMedunna.generateToken;

public class US17_API_RoomStepDef {

    Response response;

    US17_API_Room us17_api_room = new US17_API_Room();

    int roomNumber = (Faker.instance().number().numberBetween(100,10000000));

    @Given("ML Given the user sends POST requests to the {string}")
    public void mlGivenTheUserSendsPOSTRequestsToThe(String url) {


        US17_API_Room us17_api_room = new US17_API_Room();

        us17_api_room.setRoomNumber(roomNumber);
        us17_api_room.setRoomType("SUITE");
        us17_api_room.setStatus(true);
        us17_api_room.setPrice(500);
        us17_api_room.setDescription("This room is created by EmelArslan");

        response = given().
                headers("Authorization", "Bearer "+generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).


                body(us17_api_room).
                post(url);
        response.prettyPrint();
    }
    @Then("ML user gets the room data and validates")
    public void ml_user_gets_the_room_data_and_validates() {
        Assert.assertEquals(201,response.getStatusCode());


        response.then().assertThat().body("roomNumber" , equalTo(roomNumber)).
                body("roomType", equalTo("SUITE")).
                body("status", equalTo(true)).
                body("price",equalTo(500)).
                body("description", equalTo("This room is created by EmelArslan"));




    }


}
