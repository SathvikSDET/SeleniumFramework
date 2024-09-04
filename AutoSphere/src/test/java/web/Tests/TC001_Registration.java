package web.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import web.pageObjects.MainPage;
import web.pageObjects.RegisterAccount;
import web.pageObjects.RegistrationCreated;
import web.pageObjects.common.MyAccount;
import web.utilites.BaseClass;

public class TC001_Registration extends BaseClass{
	
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
		
		regpage.checkPolicy();
		regpage.setSubscribeRadio();
		regpage.clickContinueButton();
		
		RegistrationCreated confmsg =new RegistrationCreated(driver);
		
		AssertJUnit.assertEquals(confmsg.getConfirmationMsg(), "Your Account Has Been Created!");
		
	}

}
