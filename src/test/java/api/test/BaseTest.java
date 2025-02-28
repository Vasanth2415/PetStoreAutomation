package api.test;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	protected RequestSpecification request;
	protected String BASE_URL = "https://gorest.co.in/public/v2/users";
	protected String bearerToken = "your_api_token_here"; // Replace with your token

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = BASE_URL;
		request = RestAssured.given().header("Authorization", "Bearer " + bearerToken)
				.header("Content-Type", "application/json").header("Accept", "application/json");
	}
}