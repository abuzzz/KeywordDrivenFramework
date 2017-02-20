package grid_test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
public class test_grid {
	public RemoteWebDriver driver;

	@Test
	public void onStartss() {
		// TODO Auto-generated method stub
		//System.out.println("==================" + suite.getName());
		System.setProperty("webdriver.gecko.driver", "d:\\s.w\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setPlatform(Platform.ANY);
		//capabilities.setCapability("binary", "d:\\s.w.\\firefox-sdk\\bin\\firefox.exe");
		try {
			 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
