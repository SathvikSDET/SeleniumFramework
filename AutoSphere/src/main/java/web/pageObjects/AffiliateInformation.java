package web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AffiliateInformation extends BasePomClass {

	
	public AffiliateInformation(WebDriver driver) {
		super(driver);
	}

	public PaymentInfo paymentInfo;
	
	
	//My Affiliate Account
	@FindBy(xpath = "//input[@id='input-company']")
	WebElement company;
	
	
	@FindBy(xpath = "//input[@id='input-website']")
	WebElement website;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement agree;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continuebutton;
	
	
	//Payment Information
	public PaymentInfo getpaymentInfo() {
		PaymentInfo paymentInfo = new PaymentInfo(driver);
		return paymentInfo;
	}
	
	
	public void setCompany(String company) {
		this.company.sendKeys(company);
		
	}
	
	public void setWebsite(String website) {
		this.website.sendKeys(website);
		
	}
	
	
	public void clickAgreeTc() {
		this.agree.click();	
	}
	
	public void clickContinue() {
		this.continuebutton.click();
	}
	
	
	


	@Override
	public boolean isDisplayed() {
		return false;
	}
	
	
	
	
	
	
	
	

}
