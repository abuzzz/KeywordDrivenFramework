package selenium_utls;
import java.util.HashMap;
import java.util.LinkedList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import Helper.PropertiesReader;

public class baseClass {

	/** The array. */
	public static HashMap<String,LinkedList<String>> listen_map = new HashMap<String,LinkedList<String>>();
	private static WebDriver driver;
	public static  DesiredCapabilities capabilities;

/**
 * Method is selecting browsers.
 * @param browser
 * @param url
 */
	public static void getBrowser(String browser, String url) {
		switch (browser){
		case "chrome":
			driver = initChromeDriver(url);
			break;
		case "firefox":
			driver = initFirefoxDriver(url);
			break;
		case "ie":
			driver = initIEDriver(url);
			break;
		default:
			System.out.println("browser : " + browser
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(url);
		}

	}
	
	

	public static WebDriver getDriver() {
		return baseClass.driver;
	}
	
	

	public static void open(String url) {
		driver.get(url);
	}

	public static void close() {
		driver.close();
	}
	public static void quit(){
		driver.quit();
	}
	
	public static void refresh(){
		driver.navigate().refresh();
	}
	
	public static void navigateBack(){
		driver.navigate().back();
	}
	
	public static void navigateForward(){
		driver.navigate().forward();
	}
	
	public static void navigateTo(String url){
		driver.navigate().to(url);;
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		 capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		System.setProperty("webdriver.chrome.driver",
				PropertiesReader.readProperty("chrome_driver")
						+ "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		open(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;

	}
	
	private static WebDriver initIEDriver(String appURL) {
		 capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,
				true);

		System.out.println("Launching IE browser..");
		System.setProperty("webdriver.chrome.driver",
				PropertiesReader.readProperty("ie_driver") + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		open(appURL);
		return driver;
	}
}