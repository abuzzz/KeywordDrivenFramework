package com.xavient.scripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import selenium_utls.ExcelLib;
import selenium_utls.ReportLog;
import selenium_utls.baseClass;
import selenium_utls.ReportLog.log;

@Listeners(Listener.ReporterListener.class)
public class Login2 extends baseClass {
	ReportLog  reportLog = new ReportLog(this.getClass().getSimpleName());	
	Logger logger = Logger.getLogger(Login.class);

	@Test
	public void LoginToApplicationTest11() {
		String Username = ExcelLib.getData("Sheet1", 1, 0);

		reportLog.LOG(log.INFO, "Login to App" , new Object(){}.getClass().getEnclosingMethod().getName());
		reportLog.LOG(log.INFO, "Validation test" , new Object(){}.getClass().getEnclosingMethod().getName());
		/*getBrowser("firefox", "https://www.hallwaze.com/");

		GenericLib.clickOnElement(Elements.getWebElementByXpath(Xpaths.signin), "Element got clicked");*/

		//GenericLib.impliciytlyWait(10, "10 second");

	}
	@Test
	public void LoginToApplicationTest21() {
		String Username = ExcelLib.getData("Sheet1", 1, 0);

		reportLog.LOG(log.INFO, "Logout App.." , new Object(){}.getClass().getEnclosingMethod().getName());

		/*getBrowser("firefox", "https://www.hallwaze.com/");

		GenericLib.clickOnElement(Elements.getWebElementByXpath(Xpaths.signin), "Element got clicked");*/

		//GenericLib.impliciytlyWait(10, "10 second");

	}
	
	

}
