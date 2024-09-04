package web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccount extends BasePomClass {

	public RegisterAccount(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isDisplayed() {
		return logo.isDisplayed();
	}
	
	@FindBy(id = "logo")
	WebElement logo;
	
	
	@FindBy(xpath  = "//input[@id='input-firstname']")
	WebElement firstname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement passwordconfirm;
	@FindBy(xpath = "//label[normalize-space()='Yes']")
	WebElement subscribe;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement policy;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continuebutton;
	
	
	public void setFirstName(String firstname) {
		this.firstname.sendKeys(firstname);
	}
	
	public void setLastName(String lastname) {
		this.lastname.sendKeys(lastname);
	}
	
	public void setEmail(String email) {
				this.email.sendKeys(email);
	}
	
	public void setTelephone(String telephone) {
		
		this.telephone.sendKeys(telephone);
	}
	
	public void setPassword(String password) {
		
		this.password.sendKeys(password);
	}
	
	
	public void setPasswordConfirm(String passwordconfirm) {
		
		this.passwordconfirm.sendKeys(passwordconfirm);
	}
	
	public void setSubscribeRadio() {
		this.subscribe.click();
	}
	
	public void checkPolicy() {
		this.policy.click();
	}
	
	public void clickContinueButton() {
		this.continuebutton.click();
	}
	

}
