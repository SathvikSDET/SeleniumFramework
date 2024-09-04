package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class TC003_UserUpdatetest extends TC001_UserPosttest{
	
	@Test
	void testPostUser(ITestContext context) {
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		context.setAttribute("username", userpayload.getUsername());
		Response response = UserEndPoints.updateUser((context.getAttribute("username")).toString(),userpayload);
		response.then().log().headers();
		Assert.assertEquals(response.getStatusCode(),200);
		

	}

}
