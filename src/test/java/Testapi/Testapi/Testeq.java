
package Testapi.Testapi;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import org.json.JSONObject;

public class Testeq{
//@Test
public void postBodyWithJsonString() {
	 JSONObject data = new JSONObject();
     data.put("client_id", "CZMNesAQ4Avg09YI5iSUngh1FMPtwRH0");
     data.put("client_secret", "uoUCcjv9fKkJquhS");
     data.put("grant_type", "client_credentials");
     

  given()
            .baseUri("https://uatapi.equinix.com")
            .body(data)
            .contentType("application/json")
           .when()
            .post("/oauth2/v1/token")
            .then()
            .statusCode(500);


}
@Test
public void queryParamTest() {
given()
.queryParam("detail","true")
.header("Authorization", "Bearer J6wGtwBSb8vO3lERw9NuUp72GR8m")
.when().get("https://uatapi.equinix.com/v1/orders/workvisit/locations")
.then().statusCode(200);
}
}