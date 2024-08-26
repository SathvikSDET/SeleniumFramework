package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MainPage;
import pageObjects.RegisterAccount;
import pageObjects.RegistrationCreated;
import pageObjects.common.MyAccount;

public class T001_Registration extends BaseClass{
	
	@Test
	void regiteration() throws InterruptedException {
		MainPage main = new MainPage(driver);
		MyAccount myaccount =  main.getMyAccount();
		myaccount.clickMyAccount();
		myaccount.clickRegister();
		
		RegisterAccount regpage = new RegisterAccount(driver);
		
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		String email = randomeString();
		regpage.setEmail(email+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setPasswordConfirm(password);
		System.out.println("Email "+ email);
		System.out.println("Password "+password);
		
		regpage.checkPolicy();
		regpage.setSubscribeRadio();
		regpage.clickContinueButton();
		
		RegistrationCreated confmsg =new RegistrationCreated(driver);
		
		AssertJUnit.assertEquals(confmsg.getConfirmationMsg(), "Your Account Has Been Created!");
		
	}

}
