package utilites;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.base.Predicate;

import io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue.Consumer;
import pageObjects.common.currency.CurrencyConfig;
import pageObjects.common.currency.DollerCurrency;
import pageObjects.common.currency.EuroCurrency;
import pageObjects.common.currency.PoundCurrency;

public class GridFactory {

	public static WebDriver driver;
	/*
	 * //capabilities.setPlatform(Platform.WIN11); public static final
	 * BiConsumer<String,String> CHROME = (env,brw)->{ Predicate<String> isChrome =
	 * (browser) -> "chrome".equalsIgnoreCase(browser); Predicate<String> isLocal =
	 * (environment) -> "local".equalsIgnoreCase(environment);
	 * 
	 * if (isLocal.test(env) && isChrome.test(brw)){ new ChromeDriver(); } else {
	 * DesiredCapabilities capabilities = new DesiredCapabilities();
	 * capabilities.setPlatform(Platform.WIN11); } /*
	 * 
	 * { if(env.equals("local")) { new ChromeDriver(); }else { DesiredCapabilities
	 * capabilities = new DesiredCapabilities();
	 * capabilities.setPlatform(Platform.WIN11); } }
	 */

	
	private static final Function<String, WebDriver> CHROME_LOCAL = (d) -> new ChromeDriver();
	private static final Function<WebDriver, CurrencyConfig> EUR = (d) -> new EuroCurrency(d);
	private static final Function<WebDriver, CurrencyConfig> GBP = (d) -> new PoundCurrency(d);
	private static final Map<String, Function<WebDriver, CurrencyConfig>> MAP = new HashMap<String, Function<WebDriver, CurrencyConfig>>();

	static {
		MAP.put("EUR", EUR);
		MAP.put("USD", USD);
		MAP.put("GBP", GBP);
	}

	
	
	
	private static DesiredCapabilities capabilities = new DesiredCapabilities();

	
	public static final Consumer<String> CHROME = (env) -> {
		Predicate<String> isLocal = (environment) -> "chrome".equalsIgnoreCase(environment);
		if (isLocal.test(env)) {
			new ChromeDriver();
		} else {
			capabilities.setBrowserName("chrome");
		}
	};
	public static final Consumer<String> EDGE = (env) -> {
		Predicate<String> isLocal = (environment) -> "edge".equalsIgnoreCase(environment);
		if (isLocal.test(env)) {
			new EdgeDriver();
		} else {
			capabilities.setBrowserName("MicrosoftEdge");
		}
	};
	public static final Consumer<String> FIREFOX = (env) -> {
		Predicate<String> isLocal = (environment) -> "firefox".equalsIgnoreCase(environment);
		if (isLocal.test(env)) {
			new FirefoxDriver();
		} else {
			capabilities.setBrowserName("FireFox");
		}
	};
	
	
	
	

	
	
	public static final Consumer<String> WIN = (S)-> capabilities.setPlatform(Platform.WIN11);
	public static final Consumer<String> MAC = (S)-> capabilities.setPlatform(Platform.WIN11);

	

	public static WebDriver getdriver(String env, String browser) {
		return new ChromeDriver();
	}

}
