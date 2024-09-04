package api.test;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import api.endpoint.UserEndPoints;
import io.restassured.response.Response;

public class TC002_UserGettest {


	
	@Test
	void testGetUser(ITestContext context) {
		Response response =UserEndPoints.deleteUser((context.getAttribute("username")).toString());
		System.out.println(response.getStatusCode());
	}

}
