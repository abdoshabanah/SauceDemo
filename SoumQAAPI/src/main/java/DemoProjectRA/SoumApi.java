package DemoProjectRA;


import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.testng.annotations.Test;

import files.Payload;

import static org.hamcrest.Matchers.*;



public class SoumApi {

	@Test 
	public void CheckProductsAPI() { 
		
		RestAssured.baseURI = "https://api.qa.soum.sa";
		
		String response = given().log().all().queryParam("page%20number", 2 ).queryParam("size", 3)
		.header("Content-Type","application/json")
		.when().get("api-v2/rest/api/v1/product")
		.then().assertThat().body(matchesJsonSchemaInClasspath("schema.json")).body("message", equalTo("Get Products successfully"))
		.body("responseData.info.total", equalTo(463134))
		.body("status", equalTo("success")).statusCode(200).
		extract().response().asString();
		System.out.println(response);
		JsonPath js = new JsonPath(Payload.Products());
		int count =js.getInt("responseData.size()");
		System.out.println(count);
		String Status =js.get("status").toString();
		System.out.println(Status);
		
	}

}
