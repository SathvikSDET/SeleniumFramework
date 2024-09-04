package api.endpoint;
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndPoints {
	
	
	
	public static Response creatUser(User payload) {

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(Route.post_url);
		return response;

	}
	
	public static Response readUser(String username) {

		Response response = given()
				.pathParam("username", username)
				.when()
				.get(Route.get_url);
		return response;

	}
	
	public static Response updateUser(String username,User payload) {

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", username)
				.when()
				.put(Route.update_url);
		return response;

	}
	
	public static Response deleteUser(String username) {

		Response response = given().pathParam("username", username)
							.when().delete(Route.delete_url);
		return response;

	}
	
	
	

}
