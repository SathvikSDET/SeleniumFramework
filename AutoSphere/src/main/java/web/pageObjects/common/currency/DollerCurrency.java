package web.pageObjects.common.currency;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DollerCurrency extends CurrencyConfig {

	protected WebDriver driver;
	protected WebDriverWait wait;
	private final String USD = "$";

	public DollerCurrency(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Currency']")
	WebElement currency;
	@FindBy(xpath = "//button[normalize-space()='$US Dollar']")
	WebElement usdollar;
	@FindBy(xpath = "//div[@id='content']//p//span")
	List<WebElement> price;

	@Override
	public void setCurrency() {
		wait.until(ExpectedConditions.elementToBeClickable(currency)).click();
		wait.until(ExpectedConditions.elementToBeClickable(usdollar)).click();
	}

	@Override
	public boolean checkPriceChange() {
		return price.stream().map(WebElement::getText)
				.filter(i -> !i.startsWith("Ex"))
				.anyMatch(i -> i.startsWith(USD));
	}

}
