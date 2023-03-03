package stepdefinitions;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static utilities.MedunnaAuthentication.generateToken;

public class US07_API_user_info {

    public static void main(String[] args) {
        RequestSpecification spec=new RequestSpecBuilder().
                addHeader("Authorization","Bearer "+generateToken()).
                setBaseUri(ConfigReader.getProperty("health_project_api_url")).
                build();
        spec.pathParam("first","users");
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();


    }


}
