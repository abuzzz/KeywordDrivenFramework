package selenium_utls;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browsers {

	public static WebDriver DRIVER = null;

	/**
	 * Method is initializing driver with defined browser properties.
	 * 
	 * @author SHasan
	 * @param browser
	 * @return driver Object
	 */

	static Logger log = LogManager.getLogger(Browsers.class);

	public static WebDriver getBrowser(String browser) {
		String path = System.getProperty("user.dir");
		if (browser.equalsIgnoreCase("Firefox")) {

			// Creating Firefox instance

			FirefoxProfile profile = new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(true);

			DRIVER = new FirefoxDriver(profile);
			DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
			log.info(browser + " instance initializing...");
			DRIVER.manage().window().maximize();
			log.info(browser + " browser launched successfully.");
			log.info("Opening... " + PropertiesReader.readProperty("URL"));
			DRIVER.get(PropertiesReader.readProperty("URL"));
			log.info("URL opens up. ");

		} else if (browser.equalsIgnoreCase("Chrome")) {

			// Creating Chrome instance

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			System.setProperty("webdriver.chrome.driver", path + PropertiesReader.readProperty("chrome_driver"));
			DRIVER = new ChromeDriver();
			DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
			log.info(browser + " instance initializing...");
			DRIVER.manage().window().maximize();
			log.info(browser + " browser launched successfully.");
			log.info("Opening... " + PropertiesReader.readProperty("URL"));
			DRIVER.get(PropertiesReader.readProperty("URL"));
			log.info("URL opens up. ");

		} else if (browser.equalsIgnoreCase("IE")) {

			// Creating InternetExplorer instance

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);

			System.setProperty("webdriver.ie.driver", path + PropertiesReader.readProperty("ie_driver"));
			DRIVER = new InternetExplorerDriver();
			log.info(browser + " instance initializing...");
			DRIVER.manage().window().maximize();
			log.info(browser + " browser launched successfully.");
			log.info("Opening... " + PropertiesReader.readProperty("URL"));
			DRIVER.get(PropertiesReader.readProperty("URL"));
			log.info("URL opens up. ");

		}
		return DRIVER;
	}
}
