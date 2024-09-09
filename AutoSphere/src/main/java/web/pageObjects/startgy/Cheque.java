package web.pageObjects.startgy;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cheque implements PaymentModeOptions{
	
	@FindBy(xpath = "//input[@value='cheque']")
	WebElement cheque;
	
	
	@FindBy(xpath = "//input[@id='input-cheque']")
	WebElement chequePayeeName;
	
	@Override
	public void enterPaymentInformation(Map<String, String> paymentDetails) {
		this.cheque.click();
		this.chequePayeeName.sendKeys(paymentDetails.get("PayeeName"));
		
	}
	

}
