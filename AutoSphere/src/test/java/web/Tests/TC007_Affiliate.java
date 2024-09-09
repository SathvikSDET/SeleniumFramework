package web.Tests;

import java.util.Map;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import web.pageObjects.AffiliateInformation;
import web.pageObjects.MainPage;
import web.pageObjects.MyAccountPage;
import web.pageObjects.PaymentInfo;
import web.pageObjects.RegisterAccount;
import web.pageObjects.RegistrationCreated;
import web.pageObjects.common.MyAccount;
import web.pageObjects.startgy.PaymentOptionFactory;
import web.utilites.BaseClass;
import web.utilites.Dataprovider;

public class TC007_Affiliate extends BaseClass{
	
	
	String email;
	String password;
	
	
	
	@Test(priority = 1)
	void regiteration() throws InterruptedException {
		MainPage main = new MainPage(driver);
		MyAccount myaccount =  main.getMyAccount();
		myaccount.clickMyAccount();
		myaccount.clickRegister();
		
		RegisterAccount regpage = new RegisterAccount(driver);
		
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		email = randomeString();
		regpage.setEmail(email+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setPasswordConfirm(password);
		
		regpage.checkPolicy();
		regpage.setSubscribeRadio();
		regpage.clickContinueButton();
		
		RegistrationCreated confmsg =new RegistrationCreated(driver);
		
		AssertJUnit.assertEquals(confmsg.getConfirmationMsg(), "Your Account Has Been Created!");	
		confmsg.clickContinue();
		
	}
	
	
	
	
	
	@Test(priority = 2,dataProvider = "Payment", dataProviderClass = Dataprovider.class)
	public void testAffiliateInfo(String payment, Map<String, String> paymentData) {
		
		//Click My Affiliate Account
		MyAccountPage myAccountPage =new MyAccountPage(driver);
		myAccountPage.clickAfflicateAccont();
		
		//Your Affiliate Info
		AffiliateInformation info =new AffiliateInformation(driver);
		
		info.setCompany(randomeString());
		info.setWebsite(randomeString()+".com");
		
		PaymentInfo paymentinfo = info.getpaymentInfo();
		paymentinfo.setTaxId(randomAlphaNumeric());
		
		paymentinfo.setpaymentMode(PaymentOptionFactory.get(payment));
		
		paymentinfo.setData(paymentData);
		
		
		info.clickAgreeTc();
		info.clickContinue();
		
		//Logout
		myAccountPage.clickLogout();
		
	}
	
	
	
	
	

}
