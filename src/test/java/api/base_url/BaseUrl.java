package api.base_url;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import utilities.ConfigReader;

import static utilities.MedunnaAuthentication.generateToken;

public class BaseUrl {

    public static RequestSpecification spec;

    @Before
    public void setUp() {
        spec = new  RequestSpecBuilder().
                addHeader("Authorization","Bearer "+generateToken()).
                setBaseUri(ConfigReader.getProperty("health_project_api_url")).
                build();
    }
}