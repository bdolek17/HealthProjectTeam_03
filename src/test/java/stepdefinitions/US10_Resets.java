package stepdefinitions;

import api.pojos.CountryS;
import api.pojos.CstateS;
import api.pojos.PatientS;
import api.pojos.User;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import utilities.RequestSpec;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepdefinitions.StepDefinitionsUtilities.responseMedunna;
import static utilities.RequestSpec.specMedunna;

public class US10_Resets {
    PatientS patient=new PatientS();
    User user=new User();

    @When("user sends PUT request to {string} gets the response")
    public void user_sends_put_request_to_gets_the_response(String endpoint, DataTable dataTable) {
        Map<String,String> resetInfo=dataTable.asMap(String.class,String.class);
        user.setActivated(true);
        user.setLogin(resetInfo.get("user"));
        user.setSsn(resetInfo.get("ssn"));

        patient.setUser(user);
        patient.setAdress(resetInfo.get("adress"));
        patient.setBloodGroup(resetInfo.get("bloodgroup"));

        CountryS country=new CountryS();
        country.setName(resetInfo.get("country"));
        //patient.setCountry(country);

        CstateS cstate=new CstateS();
        cstate.setCountry(country);
        cstate.setName(resetInfo.get("state_city"));
        //patient.setCstate(cstate);

        patient.setDescription(resetInfo.get("description"));
        patient.setEmail(resetInfo.get("email"));
        patient.setFirstName(resetInfo.get("firstname"));
        patient.setGender(resetInfo.get("gender"));
        patient.setLastName(resetInfo.get("lastname"));
        patient.setPhone(resetInfo.get("phone"));
        patient.setSsn(resetInfo.get("ssn"));

        RequestSpec.setSpecWithAuthorization();

        specMedunna.pathParams("first",endpoint);
        //responseMedunna=given().spec(specMedunna).contentType(ContentType.JSON).body(patient).when().put("{first}");
        responseMedunna=given().spec(specMedunna).when().get("{first}");
        responseMedunna.prettyPrint();

    }
}
