package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Cookie;
import io.restassured.specification.RequestSpecification;
import org.junit.platform.commons.util.StringUtils;

import static utilities.MedunnaAuthentication.generateToken;

public class RequestSpec {

    public static RequestSpecification spec;

    private static void setSpec(String type){
        if(type.toUpperCase().startsWith("A")){
            spec = new  RequestSpecBuilder().
                    addHeader("Authorization","Bearer "+generateToken()).
                    setBaseUri(ConfigReader.getProperty("health_project_api_url")).
                    build();;
        } else if (type.toUpperCase().startsWith("C")) {
            Cookie someCookie = new Cookie.Builder("token", generateToken()).setSecured(true).setComment("some comment").build();
            spec = new RequestSpecBuilder().
                    setBaseUri(ConfigReader.getProperty("health_project_api_url")).
                    addCookie(someCookie).
                    build();
        } else {
            spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("health_project_api_url")).build();
        }
    }

    public static void setSpecWithAuthorization(){
        setSpec("C");
    }
    public static void setSpecWithCookie(){
        setSpec("A");
    }
    public static void setSpec(){
        setSpec("N");
    }
}
