
package Testapi.Testapi;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import java.util.HashMap;
public class Testeq{
//@Test
public void postBodyWithJsonString() {
	 JSONObject data = new JSONObject();
     data.put("client_id", "CZMNesAQ4Avg09YI5iSUngh1FMPtwRH0");
     data.put("client_secret", "uoUCcjv9fKkJquhS");
     data.put("grant_type", "client_credentials");
     

  given()
            .baseUri("https://uatapi.equinix.com")
            .body(
                    "{\"client_id\":\"CZMNesAQ4Avg09YI5iSUngh1FMPtwRH0\",\n" +
            "    \"client_secret\":\"uoUCcjv9fKkJquhS\",\\n\" +\r\n"
            + "            \"    \\\"grant_type\\\":\\\"client_credentials\\\"}"
            )
            .contentType("application/json")
           .when()
            .post("/oauth2/v1/token")
            .then()
            .statusCode(500);


}
//@Test
public void queryParamTest() {
given()
.queryParam("detail","true")
.header("Authorization", "Bearer J6wGtwBSb8vO3lERw9NuUp72GR8m")
.when().get("https://uatapi.equinix.com/v1/orders/workvisit/locations")
.then().statusCode(200);
}
//@Test
public void queryParamTest1() {
given()
.queryParam("detail","true")
.header("Authorization", "Bearer J6wGtwBSb8vO3lERw9NuUp72GR8m")
.when().get("https://uatapi.equinix.com/v1/orders/workvisit/locations")
.then()
.statusCode(200)
.log().body()
.extract().response();
}

//@Test
public void inventory() {
	given()
	.when()
	.get("https://petstore.swagger.io/v2/store/inventory")
	.then()
	.statusCode(200)
	.statusLine("HTTP/1.1 200 OK")
	.log()
	.body()
	.extract()
	.response();
	
}
@BeforeTest
public void TestDataSetup()
{
File Src = new File(".\src\main\java\Config.Properties");
FileInputStream fis = new  FileInputStreams(src);
pro = new properties();
pro.load(fis);
}
RestAssured.baseURI= pro.getProperty("PATH");
//@Test
public void inventory1() {
	given()
	.when()
	.get("https://petstore.swagger.io/v2/user/login?username=user&password=admin")
	.then()
	.statusCode(200)
	.statusLine("HTTP/1.1 200 OK")
	.log()
	.body()
	.extract()
	.response();
	
}

@Test
public void user() {
	
	JSONObject user = new JSONObject();
	user.put("id",0);
	user.put("username","abc");
	user.put("firstName","ab");
	user.put("lastName","cd");
	user.put("email", "ab@gmail.com");
	user.put("password","admin");
	user.put("phone","123");
	user.put("userStatus",0);
	given()
	.body(user)
	.contentType("application/json")
	.when()
	.post("https://petstore.swagger.io/v2/user")
	.then()
	.statusCode(200)
	.statusLine("HTTP/1.1 200 OK")
	.log()
	.body()
	.extract()
	.response();
	
}



}