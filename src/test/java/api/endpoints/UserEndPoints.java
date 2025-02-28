package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// userendpoints.java
//created for perform Create,Read,Update,Delete requests to the user API.

public class UserEndPoints {

	public static Response createUser(User userPayload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(userPayload).when()
				.post(Routes.post_url);

		return response;
	}

	public static Response readUser(String userName) {
		System.out.println("my data " + Routes.get_url);
		System.out.println("userName :  " + userName);
		Response response = given().pathParam("username", userName).when().get(Routes.get_url);

		return response;
	}

	public static Response updateUser(String userName, User userPayload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).body(userPayload).when().put(Routes.update_url);

		return response;
	}

	public static Response deleteUser(String userName) {

		Response response = given().pathParam("username", userName).when().delete(Routes.delete_url);

		return response;
	}

}
