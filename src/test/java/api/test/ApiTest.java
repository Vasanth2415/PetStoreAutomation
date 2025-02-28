package api.test;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;

public class ApiTest extends BaseTest {

	Faker faker = new Faker();
	int userId; // To store the created user ID

	@Test(priority = 1)
	public void testCreateUser() throws JsonProcessingException {
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", faker.name().fullName());
		requestParams.put("gender", "male");
		requestParams.put("email", faker.internet().emailAddress());
		requestParams.put("status", "active");

		// User user = User.builder().email(faker.internet().emailAddress()).build();

		// ObjectMapper mapper = new ObjectMapper();
		// String jsoOb = mapper.writeValueAsString(user);

		// Response response =
		// request.body(jsoOb).when().post().then().statusCode(201).log().all().extract().response();

		// userId = response.jsonPath().getInt("id"); // Store the user ID for future
		// use
		// Assert.assertNotNull(userId, "User ID should not be null");
	}
}
