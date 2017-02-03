package listener;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class suite_Start implements ISuiteListener{
public RemoteWebDriver driver;
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("==================" + suite.getName());
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
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	
	
}
