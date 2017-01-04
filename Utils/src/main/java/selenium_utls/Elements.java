package selenium_utls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Elements extends Browsers {

	public static WebElement getWebElementByXpath(String xpath) {

		return DRIVER.findElement(By.xpath(xpath));

	}

	public static WebElement getWebElementById(String id) {

		return DRIVER.findElement(By.id(id));

	}

	public static WebElement getWebElementByName(String name) {

		return DRIVER.findElement(By.name(name));

	}

	public static WebElement getWebElementByLinkText(String linkText) {

		return DRIVER.findElement(By.linkText(linkText));

	}

	public static WebElement getWebElementByPartialLinkText(String partialLinkText) {

		return DRIVER.findElement(By.partialLinkText(partialLinkText));

	}

	public static WebElement getWebElementByClassName(String className) {

		return DRIVER.findElement(By.className(className));

	}

	public static WebElement getWebElementByCssSelector(String selector) {

		return DRIVER.findElement(By.cssSelector(selector));

	}

	public static WebElement getWebElementByC(String tagName) {

		return DRIVER.findElement(By.tagName(tagName));

	}

}
