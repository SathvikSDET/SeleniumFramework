package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Login;
import pageObjects.MainPage;
import pageObjects.MyAccountPage;
import pageObjects.common.MyAccount;
import utilites.Dataprovider;

public class T002_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = Dataprovider.class)
	void loginTest(String email, String password, String exp) {

		try {
			MainPage main = new MainPage(driver);
			MyAccount myaccount = main.getMyAccount();
			myaccount.clickMyAccount();
			myaccount.clickLogin();

			Login login = new Login(driver);
			login.setEmail(email);
			login.setPassword(password);
			login.clickLogin();

			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();

			if (exp.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					macc.clickLogout();
					AssertJUnit.assertTrue(true);
				} else {
					AssertJUnit.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					macc.clickLogout();
					AssertJUnit.assertTrue(false);
				} else {
					AssertJUnit.assertTrue(true);
				}
			}
		} catch (Exception e) {
			AssertJUnit.fail("An exception occurred: " + e.getMessage());
		}

	}

}
