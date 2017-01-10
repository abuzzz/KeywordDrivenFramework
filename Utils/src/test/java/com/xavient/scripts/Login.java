package com.xavient.scripts;

import org.jsoup.Connection.Method;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.xavient.pagelib.Xpaths;

import selenium_utls.Elements;
import selenium_utls.ExcelLib;
import selenium_utls.GenericLib;
import selenium_utls.ReportLog;
import selenium_utls.baseClass;

@Listeners(selenium_utls.ReporterListener.class)
public class Login extends baseClass {

	@Test
	public void LoginToApplicationTest() {

		String Username = ExcelLib.getData("Sheet1", 1, 0);

		ReportLog.LogInfoMessage(Username + " : " + "fetched the data from excel sheet", Method.class.getName());

		getBrowser("firefox", "https://www.hallwaze.com/");

		GenericLib.clickOnElement(Elements.getWebElementByXpath(Xpaths.signin), "Element got clicked");

		GenericLib.impliciytlyWait(10, "10 second");

	}

}
