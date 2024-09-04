package web.utilites;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridFactoryRemote {
	
	
public static WebDriver driver;
private static DesiredCapabilities capabilities=new DesiredCapabilities();
	
private static final BiConsumer<DesiredCapabilities, String> CHROME = (cap, browser) -> cap.setBrowserName("chrome");
private static final BiConsumer<DesiredCapabilities, String> FIREFOX = (cap, browser) -> cap.setBrowserName("firefox");
private static final BiConsumer<DesiredCapabilities, String> SAFARI = (cap, browser) -> cap.setBrowserName("safari");
private static final Map<String, BiConsumer<DesiredCapabilities, String>> MAP = new HashMap<>();

static {
    MAP.put("chrome", CHROME);
    MAP.put("firefox", FIREFOX);
    MAP.put("safari", SAFARI);
}

	public static WebDriver getdriver(String env, String browser) {
		 if (env.equals("remote")) {
	            if (MAP.containsKey(browser)) {
	                MAP.get(browser).accept(capabilities, browser);
	           //     return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
	            } else {
	                throw new IllegalArgumentException("Browser type not supported");
	            }
	        }
	        return driver;    
	}

}
