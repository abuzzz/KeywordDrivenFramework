package com.xavient.scripts;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.xavient.pagelib.Elements;
import com.xavient.pagelib.Xpaths;

import selenium_utls.Browsers;
import selenium_utls.GenericLib;

public class Login extends Browsers {

	Logger log = LogManager.getLogger(Login.class);

	@Test
	public void LoginToApplicationTest() {

		getBrowser("ie");

		GenericLib.clickOnElement(Elements.getWebElementByXpath(Xpaths.signin), "Element got clicked");

	}

}
