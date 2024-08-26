package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.common.MyAccount;

public class MainPage  {
	
	private MyAccount myAccount;

	public MainPage(WebDriver driver) {
		this.myAccount = PageFactory.initElements(driver, MyAccount.class);
		 
	}

	  public MyAccount getMyAccount() {
	        return myAccount;
	    }


}
