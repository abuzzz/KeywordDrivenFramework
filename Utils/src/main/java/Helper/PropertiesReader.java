package Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PropertiesReader {

	/**
	 * Method is fetching values from config.properties file.
	 * 
	 * @author SHasan
	 * @param key
	 * @return String value based on key.
	 * 
	 */
	static Logger logger = LogManager.getLogger(PropertiesReader.class);

	public static String readProperty(String key) {

		File file = new File(System.getProperty("user.dir") + "\\Resources\\config.properties");
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			logger.info("Creating config input stream... ");
			fis = new FileInputStream(file);
			logger.info("Loading properties instance...");
			prop.load(fis);
			logger.info("Properties instance created.");

		} catch (FileNotFoundException fnfe) {
			logger.info("Configuration file not found. " + fnfe);

		} catch (IOException ioe) {
			logger.info(ioe);
		}

		return prop.getProperty(key);

	}
}
