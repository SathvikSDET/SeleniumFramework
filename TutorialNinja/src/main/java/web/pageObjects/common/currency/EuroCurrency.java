package pageObjects.common.currency;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EuroCurrency extends DollerCurrency {
	private final String EUR = "€";

	public EuroCurrency(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[contains(text(),'€Euro')]")
	WebElement euro;

	@Override
	public void setCurrency() {
		wait.until(ExpectedConditions.elementToBeClickable(currency)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(euro)).click();
	}
	
	
	@Override
	public boolean checkPriceChange() {
		return price.stream().map(WebElement::getText)
				.filter(i -> !i.startsWith("Ex"))
				.anyMatch(i -> i.endsWith(EUR));
	}
}
