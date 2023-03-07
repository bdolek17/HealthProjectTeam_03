package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class Medunna_Base_Url {

    public static RequestSpecification spec;

    public static void medunnaSetUp(){
        spec= new RequestSpecBuilder().setBaseUri("https://medunna.com").build();
    }
}
