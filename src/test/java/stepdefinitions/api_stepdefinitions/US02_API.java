package stepdefinitions.api_stepdefinitions;

import api.pojos.US02_API_Register;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import utilities.AuthenticationMedunna;
import utilities.ConfigReader;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utilities.ApiUtilities.specMedunna;
import static utilities.MedunnaAuthentication.generateToken;
import static utilities.TXTWriter.saveRegisterData;

public class US02_API {


    Faker faker = new Faker();
    Response response;
    US02_API_Register us02_api_register = new US02_API_Register();
   // US02_API_Register[] us02_api_registers;
    @Given("user sets the necessary path params params {string}")
    public void userSetsTheNecessaryPathParamsParams(String url) {
        //US02_API_Register us02_api_register = new US02_API_Register();

        response = given().
                headers("Authorization", "Bearer "+ AuthenticationMedunna.generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).


                body(us02_api_register).
                post(url);
        response.prettyPrint();

       //specMedunna.pathParams("first", "api", "second", "register");

    }
    @Given("user sets the expected data {string}, {string} {string} {string} {string} and  {string}")
            public void userSetsTheExpectedDataAnd(String firstname, String lastname, String ssn, String email, String username, String password) {

        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        ssn = faker.idNumber().ssnValid();
        email = faker.internet().emailAddress();
        username = faker.name().username();
        password = faker.internet().password(8, 15, true, true);




  US02_API_Register us02_api_register = new US02_API_Register();

        us02_api_register.setFirstName(firstname);
        us02_api_register.setLastName(lastname);
        us02_api_register.setSsn(ssn);
        us02_api_register.setEmail(email);
        us02_api_register.setLogin(username);
        us02_api_register.setPassword(password);



    }
    @Given("user sends the POST request and gets the response body")
    public void user_sends_the_post_request_and_gets_the_response_body() {
        Assert.assertEquals(201,response.getStatusCode());


    }
    @When("user saves the api records to correspondent files")
    public void user_saves_the_api_records_to_correspondent_files() {
       //saveRegisterData(us02_api_register);

    }
    @Then("user validates api records data")
    public void user_validates_api_records_data() throws IOException {

        US02_API_Register us02_api_register = new US02_API_Register();
    response.then().assertThat().body("firstname", equalTo(faker)).
            body("lastname", equalTo(faker)).
            body("ssn", equalTo(faker)).
            body("email", equalTo(faker)).
            body("username", equalTo(faker)).body("password", equalTo(faker));


        //ObjectMapper obj = new ObjectMapper();
       // US02_API_Register actualRegisterData = obj.readValue(response.asString(),US02_API_Register.class);

        //System.out.println(actualRegisterData);
       // assertEquals(us02_api_register.getFirstName(), actualRegisterData.getFirstName());
        //assertEquals(us02_api_register.getLastName(), actualRegisterData.getLastName());
        //assertEquals(us02_api_register.getLogin(), actualRegisterData.getLogin());
        //assertEquals(us02_api_register.getEmail(), actualRegisterData.getEmail());
        //assertEquals(us02_api_register.getSsn(), actualRegisterData.getSsn());



        }



    }




    /*
    Response response;
    US02_API_Register[] us02_api_registers;


    @Given("user send a get request for users' data")
    public void user_send_a_get_request_for_users_data() {

        response = given().headers(
                "Authorization",
                "Bearer " + generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).when().get(ConfigReader.getProperty("urlRegister"));

        response.prettyPrint();


    }
    @Given("user deserializes the user's data to java")
    public void user_deserializes_the_user_s_data_to_java() throws IOException {

        //US02_API_Register us02_api_registers = new US02_API_Register();
       // us02_api_registers.setLogin("doctormurat");
        //us02_api_registers.setEmail("doctormurat@gmail.com");

        ObjectMapper obj = new ObjectMapper();
        us02_api_registers = obj.readValue(response.asString(),US02_API_Register[].class);

        System.out.println("Actual Elements Size= " +us02_api_registers.length);

        boolean flag = false;
        for (int i=0; i< us02_api_registers.length; i++){
            if ("500-02-0202".contains(us02_api_registers[i].getSsn())){
                flag = true;

            }

        }
        assertTrue(flag);

       Gson gson = new Gson();
        US02_API_Register actualData = gson.fromJson(response.asString(), US02_API_Register.class);

        //Assert.assertEquals(us02_api_registers.getLogin(), actualData.getLogin());
        //Assert.assertEquals(us02_api_registers.getEmail(), actualData.getEmail());






    }
    @Then("user the user's data to correspondent file and validates")
    public void user_the_user_s_data_to_correspondent_file_and_validates() {

         //saveRegisterData(List.of(us02_api_registers));


    }



*/