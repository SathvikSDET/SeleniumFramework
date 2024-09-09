package web.pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import web.pageObjects.startgy.PaymentModeOptions;

public class PaymentInfo extends BasePomClass {

	public PaymentInfo(WebDriver driver) {
		super(driver);
	}

	PaymentModeOptions paymentOptions;

	@FindBy(xpath = "//input[@id='input-tax']")
	WebElement taxId;

	// Payment mode
	public void setpaymentMode(PaymentModeOptions paymentOptions) {
		this.paymentOptions = paymentOptions;
		PageFactory.initElements(driver, this.paymentOptions);

	}
	
	
	public void setTaxId(String taxid) {
		this.taxId.sendKeys(taxid);
	}
	
	public void setData(Map<String, String> paymentDetails) {
		this.paymentOptions.enterPaymentInformation(paymentDetails);
	}

	@Override
	public boolean isDisplayed() {
		return taxId.isDisplayed();
	}

}
