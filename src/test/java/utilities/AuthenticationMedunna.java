package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class AuthenticationMedunna {

    public static String generateToken(){
        HashMap<String,Object> hashmap=new HashMap<>();
        hashmap.put("password","Mark.123");
        hashmap.put("rememberMe",true);
        hashmap.put("username","mark_twain");
        Response response=given().contentType(ContentType.JSON).body(hashmap).when().post("https://medunna.com/api/authenticate");
        String token= response.jsonPath().getString("id_token");
        return token;

    }
}
