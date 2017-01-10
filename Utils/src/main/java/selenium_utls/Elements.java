package selenium_utls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//WebElement locator

public class Elements extends BaseClass {

	public static WebElement getWebElementByXpath(String xpath) {

		return getDriver().findElement(By.xpath(xpath));

	}

	public static WebElement getWebElementById(String id) {

		return getDriver().findElement(By.id(id));

	}

	public static WebElement getWebElementByName(String name) {

		return getDriver().findElement(By.name(name));

	}

	public static WebElement getWebElementByLinkText(String linkText) {

		return getDriver().findElement(By.linkText(linkText));

	}

	public static WebElement getWebElementByPartialLinkText(String partialLinkText) {

		return getDriver().findElement(By.partialLinkText(partialLinkText));

	}

	public static WebElement getWebElementByClassName(String className) {

		return getDriver().findElement(By.className(className));

	}

	public static WebElement getWebElementByCssSelector(String selector) {

		return getDriver().findElement(By.cssSelector(selector));

	}

	public static WebElement getWebElementByC(String tagName) {

		return getDriver().findElement(By.tagName(tagName));

	}

}
