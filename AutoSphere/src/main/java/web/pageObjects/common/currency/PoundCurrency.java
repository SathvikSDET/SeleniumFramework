package web.pageObjects.common.currency;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PoundCurrency extends EuroCurrency {
	private final String GBP = "£";
	public PoundCurrency(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[normalize-space()='£Pound Sterling']")
	WebElement pound;

	@Override
	public void setCurrency() {
		this.currency.click();
		this.pound.click();
	}
	@Override
	public boolean checkPriceChange() {
		return price.stream().map(WebElement::getText)
				.filter(i -> !i.startsWith("Ex"))
				.anyMatch(i -> i.startsWith(GBP));
	}
}
