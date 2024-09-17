package qacart;


import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestCase {

    @Test
    public void test() {
      /*  given().baseUri("https://660946510f324a9a288309d1.mockapi.io/api/v1/")
                .when().get("users")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("[0].name", equalTo("Georgia Kertzmann"),
                        "name", hasItem("Mr. Olivia Russel"),
                        "country", hasItems("Buckinghamshire", "Berkshire"));*/
        Response res = given().baseUri("https://660946510f324a9a288309d1.mockapi.io/api/v1/")
                .when().get("users")
                .then().extract().response();

        
        String name = res.path("[0].name");
        System.out.println(name);

        
    }
}