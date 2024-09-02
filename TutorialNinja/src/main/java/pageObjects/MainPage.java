package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.common.MyAccount;
import pageObjects.common.Search;

public class MainPage  {
	
	private MyAccount myAccount;
	private Search search;

	public MainPage(WebDriver driver) {
		this.myAccount = PageFactory.initElements(driver, MyAccount.class);	 
	}

	public MyAccount getMyAccount() {
	        return myAccount;
	}
	
	public Search getSearch() {
		return search;
	}
}
