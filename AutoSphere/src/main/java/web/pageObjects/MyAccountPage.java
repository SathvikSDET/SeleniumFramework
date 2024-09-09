package web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class MyAccountPage extends BasePomClass{
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[text()='My Account']") // MyAccount Page heading
	WebElement msgHeading;
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
	
	@FindBy(xpath = "//a[starts-with(text(),'Register')]")
	WebElement registerAfflicateAccont;

	
	public void clickAfflicateAccont() {
		registerAfflicateAccont.click();
	}
	

	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickLogout() {
		lnkLogout.click();

	}

	@Override
	public boolean isDisplayed() {
		return this.msgHeading.isDisplayed();
	}

}
