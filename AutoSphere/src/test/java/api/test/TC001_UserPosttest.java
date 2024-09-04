package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class TC001_UserPosttest {
	
	Faker faker;
	User userpayload;
	

	@BeforeTest
	public void setupData() {
		faker = new Faker();
		userpayload = new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	
	@Test
	void testPostUser(ITestContext context) {
		context.setAttribute("username", userpayload.getUsername());
		Response response = UserEndPoints.creatUser(userpayload);
		response.then().log().headers();
		Assert.assertEquals(response.getStatusCode(),200);
		

	}

}
