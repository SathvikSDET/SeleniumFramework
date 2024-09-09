package web.pageObjects.startgy;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BankTransfer implements PaymentModeOptions{
	
	
	@FindBy(xpath = "//input[@value='bank']")
	WebElement bankTransfer;
	
	
	@FindBy(xpath = "//input[@id='input-bank-name']")
	WebElement bankName;
	
	@FindBy(xpath = "//input[@id='input-bank-branch-number']")
	WebElement branchName;
	
	@FindBy(xpath = "//input[@id='input-bank-swift-code']")
	WebElement swiftCode;
	
	
	@FindBy(xpath = "//input[@id='input-bank-account-name']")
	WebElement accountName;
	
	@FindBy(xpath = "//input[@id='input-bank-account-number']")
	WebElement accountNumber;
	
	
	@Override
	public void enterPaymentInformation(Map<String, String> paymentDetails) {
		this.bankTransfer.click();
		this.bankName.sendKeys(paymentDetails.get("bankname"));
		this.branchName.sendKeys(paymentDetails.get("branchname"));
		this.swiftCode.sendKeys(paymentDetails.get("swift"));
		this.accountName.sendKeys(paymentDetails.get("accountname"));
		this.accountNumber.sendKeys(paymentDetails.get("accountnumber"));
	}

}