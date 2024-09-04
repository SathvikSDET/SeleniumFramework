package api.test;

import org.testng.annotations.Test;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import api.endpoint.UserEndPoints;
import io.restassured.response.Response;

public class TC004_UserDeletetest {


	
	@Test
	void testGetUser(ITestContext context) {
		Response response =UserEndPoints.readUser((context.getAttribute("username")).toString());
		response.then().log().all();

	}

}
