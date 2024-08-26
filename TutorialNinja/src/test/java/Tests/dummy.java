package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.common.currency.CurrencyConfig;
import pageObjects.common.currency.CurrencyFactory;

public class dummy {
	public CurrencyConfig currency;
	WebDriver driver;
	@Test
	public void test() {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo");
		currency = CurrencyFactory.get("GBP", driver);
		currency.setCurrency();
	}
	
	
	 @DataProvider
	    public Object[] getData(){
	        return new Object[]{
	                "ENG","ARF"
	                
	        };
	    }

}
