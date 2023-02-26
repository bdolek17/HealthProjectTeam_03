package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MedunnaDoctorAuthentication {
    public static void main(String[] args) {
        System.out.println(generateTokenDr());
    }

    public static String generateTokenDr(){

        Map<String,Object> json=new HashMap<>();
        json.put("password","Team03+");
        json.put("rememberMe",true);
        json.put("username","doctor.t03");
        Response response=given().contentType(ContentType.JSON).body(json).when().post("https://medunna.com/api/authenticate");
        return response.jsonPath().getString("id_token");
    }
}

