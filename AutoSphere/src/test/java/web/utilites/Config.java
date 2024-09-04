package web.utilites;

import java.io.InputStream;
import java.util.Properties;

public class Config {

	private static final String DEFAULT_PROPERTIES = "config/default.properties";
	private static Properties properties;

	public static void initialize() {

		// load default properties
		properties = loadProperties();

		// check for any override
		for (String key : properties.stringPropertyNames()) {
			if (System.getProperties().containsKey(key)) {
				properties.setProperty(key, System.getProperty(key));
			}
		}

	}

	public static String get(String key) {
		return properties.getProperty(key);
	}

	private static Properties loadProperties() {
		Properties properties = new Properties();
		try (InputStream stream = ResourceLoader.getResource(DEFAULT_PROPERTIES)) {
			properties.load(stream);
		} catch (Exception e) {

		}
		return properties;
	}

}
