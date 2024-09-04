package web.utilites;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class GridFactory {

	private static WebDriver driver;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    // Predicates to determine environment
    private static final Predicate<String> IS_LOCAL = env -> env.equalsIgnoreCase("local");
    private static final Predicate<String> IS_REMOTE = env -> env.equalsIgnoreCase("remote");

    // Local browser initialization
    private static final Function<String, WebDriver> LOCAL_CHROME = (d) -> new ChromeDriver();
    private static final Function<String, WebDriver> LOCAL_FIREFOX = (d) -> new FirefoxDriver();
    private static final Function<String, WebDriver> LOCAL_SAFARI = (d) -> new SafariDriver();
    private static final Map<String, Function<String, WebDriver>> LOCAL_MAP = new HashMap<>();

    // Remote browser capabilities setup
    private static final BiConsumer<DesiredCapabilities, String> REMOTE_CHROME = (cap, browser) -> cap.setBrowserName("chrome");
    private static final BiConsumer<DesiredCapabilities, String> REMOTE_FIREFOX = (cap, browser) -> cap.setBrowserName("firefox");
    private static final BiConsumer<DesiredCapabilities, String> REMOTE_SAFARI = (cap, browser) -> cap.setBrowserName("safari");
    private static final Map<String, BiConsumer<DesiredCapabilities, String>> REMOTE_MAP = new HashMap<>();

    // Platform settings
    public static final Consumer<String> WIN = (s) -> capabilities.setPlatform(Platform.WIN11);
    public static final Consumer<String> MAC = (s) -> capabilities.setPlatform(Platform.MAC);
    private static final Map<String, Consumer<String>> PLATFORM_MAP = new HashMap<>();

    static {
        // Populate local browser map
        LOCAL_MAP.put("chrome", LOCAL_CHROME);
        LOCAL_MAP.put("firefox", LOCAL_FIREFOX);
        LOCAL_MAP.put("safari", LOCAL_SAFARI);

        // Populate remote browser map
        REMOTE_MAP.put("chrome", REMOTE_CHROME);
        REMOTE_MAP.put("firefox", REMOTE_FIREFOX);
        REMOTE_MAP.put("safari", REMOTE_SAFARI);

        // Populate platform map
        PLATFORM_MAP.put("win", WIN);
        PLATFORM_MAP.put("mac", MAC);
    }

    public static WebDriver getDriver(String env, String browser, String platform) throws MalformedURLException {
    	  String lowerCaseEnv = env.toLowerCase();
          String lowerCaseBrowser = browser.toLowerCase();

          // Apply platform capabilities
          Consumer<String> platformConsumer = PLATFORM_MAP.get(platform.toLowerCase());
          if (platformConsumer != null && lowerCaseEnv.equals("remote")) { 
              platformConsumer.accept(platform);
          } else {
              throw new IllegalArgumentException("Platform not supported: " + platform);
          }

          // Traditional switch statement
          switch (lowerCaseEnv) {
              case "local":
                  Function<String, WebDriver> localDriverFunction = LOCAL_MAP.get(lowerCaseBrowser);
                  if (localDriverFunction != null) {
                      return localDriverFunction.apply(browser);
                  }
                  break;

              case "remote":
                  BiConsumer<DesiredCapabilities, String> remoteDriverConsumer = REMOTE_MAP.get(lowerCaseBrowser);
                  if (remoteDriverConsumer != null) {
                      remoteDriverConsumer.accept(capabilities, browser);
                      return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
                  }
                  break;

          }
		return driver;    
      }
    
}
