package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePomClass{

	public Login(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement login;

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public void setEmail(String email) {
		this.email.sendKeys(email);
	}

	public void clickLogin() {
		this.login.click();
	}

	@Override
	public boolean isDisplayed() {
		return this.login.isDisplayed();
	}
}
