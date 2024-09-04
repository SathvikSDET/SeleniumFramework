package pageObjects.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePomClass;

public class MyAccount extends BasePomClass{
	
	
	public MyAccount(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myaccount;
	@FindBy(xpath = "//li//a[normalize-space()='Register']")
	WebElement register;
	@FindBy(xpath = "//li//a[normalize-space()='Logout']")
	WebElement logout;
	@FindBy(xpath = "//li//a[normalize-space()='Login']")
	WebElement login;
	
	public void clickMyAccount() {
		myaccount.click();
	}

	public void clickRegister() {
		register.click();
	}

	public void clickLogin() {
		login.click();
	}
	public void clickLogout() {
		logout.click();
	}

	
	@Override
	public boolean isDisplayed() {
		return false;
	}

}
