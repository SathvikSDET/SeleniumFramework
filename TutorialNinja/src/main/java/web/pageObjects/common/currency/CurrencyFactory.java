package pageObjects.common.currency;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;

public class CurrencyFactory {

	private static final Function<WebDriver, CurrencyConfig> USD = (d) -> new DollerCurrency(d);
	private static final Function<WebDriver, CurrencyConfig> EUR = (d) -> new EuroCurrency(d);
	private static final Function<WebDriver, CurrencyConfig> GBP = (d) -> new PoundCurrency(d);
	private static final Map<String, Function<WebDriver, CurrencyConfig>> MAP = new HashMap<String, Function<WebDriver, CurrencyConfig>>();

	static {
		MAP.put("EUR", EUR);
		MAP.put("USD", USD);
		MAP.put("GBP", GBP);
	}

	public static CurrencyConfig get(String currency, WebDriver driver) {
		return MAP.get(currency).apply(driver);

	}

}
