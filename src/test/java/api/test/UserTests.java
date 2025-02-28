package api.test;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;

	public Logger logger; // For logs

	@BeforeClass // generate the data and pass it to pojo class,and the data will be ready and
					// that data will be pass to POST Request
	public void setup() {
		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUserName(faker.name().fullName());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());

		// logger = LogManager.getLogger(this.getClass());
		logger.debug("debugging.......");

		// User user =
		// User.builder().id(1).userName("mani").firstName("vasanth").build();

	}

	@Test(priority = 1)
	public void testPostUser() {
		logger.info("**************Create User************");
		setup();
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**************User is Created************");
	}

	@Test(priority = 2)
	public void testGetUserByName() {
		setup();
		logger.info("**************Reading User info************");
		// System.out.println("testGetUserByName : " + userPayload);
		Response response = UserEndPoints.readUser(this.userPayload.getUserName());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**************User info is displayed************");
	}

	@Test(priority = 3)
	public void testUpdateUserByName() {
		setup();
		logger.info("**************Updating User************");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());

		Response response = UserEndPoints.updateUser(this.userPayload.getUserName(), userPayload);
		response.then().log().body();

		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**************User is Updated************");
		// checking data after update

		Response responseAfterUpdate = UserEndPoints.readUser(this.userPayload.getUserName());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	}

	@Test(priority = 4)
	public void testDeleteUserByName() {
		logger.info("**************Deleting User************");
		Response response = UserEndPoints.deleteUser(this.userPayload.getUserName());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**************User Deleted************");
	}

}
