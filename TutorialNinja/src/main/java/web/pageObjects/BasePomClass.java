package pageObjects;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract  class BasePomClass {
	
	
	protected WebDriver driver;
	protected  WebDriverWait wait;
	
	public BasePomClass(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public abstract boolean isDisplayed();

}
