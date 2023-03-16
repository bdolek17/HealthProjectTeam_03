package stepdefinitions.api_stepdefinitions;

import api.pojos.CountryS;
import api.pojos.CstateS;
import api.pojos.Staff;
import api.pojos.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utilities.ApiUtilities;
import utilities.JSONUtils;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.responseMedunna;
import static utilities.ApiUtilities.specMedunna;

public class ApiStaffStepDefinitions {
    User user = new User();
    CountryS country=new CountryS();
    CstateS state=new CstateS();
    Staff staff=new Staff();



    @Given("user sets the expected data for staff")
    public void user_sets_the_expected_data_for_staff() {
        specMedunna.pathParams("first","users","second","staff11.t03");
        responseMedunna=given().spec(specMedunna).when().get("{first}/{second}");
        responseMedunna.prettyPrint();
        user= JSONUtils.convertJsonToJavaObject(responseMedunna.asString(), User.class);
        //System.out.println(user);

        staff.setFirstName("Shaban-api");
        staff.setLastName("Azak-api");
        staff.setPhone("666-999-8877");
        staff.setSsn("333-33-5311");
        staff.setUser(user);

        ApiUtilities.setSpecWithAuthorization();
        specMedunna.pathParams("first","staff");
        responseMedunna=given().spec(specMedunna).contentType(ContentType.JSON).body(staff).when().post("{first}");
        responseMedunna.prettyPrint();



    }
    @When("user sends the POST request for staff and gets the response")
    public void user_sends_the_post_request_for_staff_and_gets_the_response() {

    }
}
