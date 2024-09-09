package web.pageObjects.startgy;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayPal implements PaymentModeOptions{
	@FindBy(xpath = "//input[@value='paypal']")
	WebElement paypal;
	
	
	@FindBy(xpath = "//input[@id='input-paypal']")
	WebElement chequePayeeName;
	
	@Override
	public void enterPaymentInformation(Map<String, String> paymentDetails) {
		this.paypal.click();
		this.chequePayeeName.sendKeys(paymentDetails.get("paypalnum"));
		
	}

}
