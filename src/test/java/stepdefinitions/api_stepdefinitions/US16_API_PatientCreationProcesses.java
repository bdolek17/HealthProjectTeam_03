package stepdefinitions.api_stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import utilities.ApiUtilities;
import utilities.LogUtilities;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static utilities.ApiUtilities.responseMedunna;
import static utilities.ApiUtilities.specMedunna;

public class US16_API_PatientCreationProcesses {

    @When("user sends GET request to {string} with created id as spec param and gets the response")
    public void user_sends_get_request_to_with_created_id_as_spec_param_and_gets_the_response(String endpointParam) {
        String patientID=LogUtilities.getAllCreatedPatientIds().get(0);  //get it from text file

        specMedunna.pathParams("first",endpointParam,"second",patientID);
        responseMedunna=given().spec(specMedunna).when().get("{first}/{second}");
        responseMedunna.prettyPrint();
    }
    @Then("user verifies that status code is {int} and patient informations have created id and following {string} {string} {string} {string} {string} values")
    public void user_verifies_that_status_code_is_and_patient_informations_have_created_id_and_following_values(int statusCode, String firstname, String lastname, String email, String phone, String gender) {
        JsonPath jsonPath = responseMedunna.jsonPath();

        Assert.assertEquals(statusCode,responseMedunna.statusCode());

        String patientID=LogUtilities.getAllCreatedPatientIds().get(0);
        Assert.assertEquals(patientID,jsonPath.getString("id"));

        Assert.assertEquals(firstname,jsonPath.getString("firstName"));
        Assert.assertEquals(lastname,jsonPath.getString("lastName"));
        Assert.assertEquals(email,jsonPath.getString("email"));
        Assert.assertEquals(phone,jsonPath.getString("phone"));
        Assert.assertEquals(gender,jsonPath.getString("gender"));
    }


    @When("user sends GET request to {string} with id {int} as spec param and gets the response")
    public void user_sends_get_request_to_with_id_as_spec_param_and_gets_the_response(String endpointParam, Integer patientID) {
        String deletedPatientId=LogUtilities.getFirstCreatedPatientId();  //get it from text file
        if(deletedPatientId.length()==0) {deletedPatientId=patientID.toString();}


        specMedunna.pathParams("first",endpointParam,"second",deletedPatientId);
        responseMedunna=given().spec(specMedunna).when().get("{first}/{second}");
        responseMedunna.prettyPrint();
    }



    @When("user sends DELETE request to {string} to delete all created patients and gets the response")
    public void user_sends_delete_request_to_to_delete_all_created_patients_and_gets_the_response(String endpoint) {
        //Given user sets the request specification
        ApiUtilities.setSpecWithAuthorization();

        List<String> createdPatiens=LogUtilities.getAllCreatedPatientIds();
        List<String> undeletedPatients=createdPatiens.stream().collect(Collectors.toList());

        for(String patientId:createdPatiens){
            if(patientId.length()>0){
                System.out.println("Deleting :"+patientId);
                specMedunna.pathParams("first",endpoint,"second",patientId);
                responseMedunna=given().spec(specMedunna).when().delete("{first}/{second}");
                if(responseMedunna.statusCode()==500 || responseMedunna.statusCode()==204){
                    undeletedPatients.remove(patientId);
                }
                //System.out.println(responseMedunna.statusCode());
                responseMedunna.prettyPrint();
            }
        }

        LogUtilities.savePatientCreationInfo(undeletedPatients,false);

    }
}
