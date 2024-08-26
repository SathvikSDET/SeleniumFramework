package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationCreated extends BasePomClass {

	public RegistrationCreated(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isDisplayed() {
		return msgConfirmation.isDisplayed();
	}

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	} catch (Exception e) {
		return (e.getMessage());

	}
	}
}