package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiUtilities {

    public static Response responseMedunna;
    public static RequestSpecification specMedunna;

    private static String generateMedunnaToken(){

        Map<String,Object> json=new HashMap<>();
        json.put("password","Team03+");
        json.put("rememberMe",true);
        json.put("username","AdminTeam03");
        Response response=given().contentType(ContentType.JSON).body(json).when().post("https://medunna.com/api/authenticate");
        return response.jsonPath().getString("id_token");
    }

    private static void setSpec(String type){
        if(type.toUpperCase().startsWith("A")){
            specMedunna = new  RequestSpecBuilder().
                    addHeader("Authorization","Bearer "+generateMedunnaToken()).
                    setBaseUri(ConfigReader.getProperty("health_project_api_url")).
                    build();;
        } else if (type.toUpperCase().startsWith("C")) {
            Cookie someCookie = new Cookie.Builder("token", generateMedunnaToken()).setSecured(true).setComment("some comment").build();
            specMedunna = new RequestSpecBuilder().
                    setBaseUri(ConfigReader.getProperty("health_project_api_url")).
                    addCookie(someCookie).
                    build();
        } else {
            specMedunna = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("health_project_api_url")).build();
        }
    }

    public static void setSpecWithAuthorization(){
        setSpec("A");
    }
    public static void setSpecWithCookie(){
        setSpec("C");
    }
    public static void setSpec(){
        setSpec("N");
    }
}
