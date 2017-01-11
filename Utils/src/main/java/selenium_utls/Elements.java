package selenium_utls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// TODO: Auto-generated Javadoc
/**
 * The Class Elements.
 */
public class Elements extends baseClass {

	/**
	 * Gets the web element by xpath.
	 *
	 * @param xpath the xpath
	 * @return the web element by xpath
	 */
	public static WebElement getWebElementByXpath(String xpath) {

		return getDriver().findElement(By.xpath(xpath));

	}

	/**
	 * Gets the web element by id.
	 *
	 * @param id the id
	 * @return the web element by id
	 */
	public static WebElement getWebElementById(String id) {

		return getDriver().findElement(By.id(id));

	}

	/**
	 * Gets the web element by name.
	 *
	 * @param name the name
	 * @return the web element by name
	 */
	public static WebElement getWebElementByName(String name) {

		return getDriver().findElement(By.name(name));

	}

	/**
	 * Gets the web element by link text.
	 *
	 * @param linkText the link text
	 * @return the web element by link text
	 */
	public static WebElement getWebElementByLinkText(String linkText) {

		return getDriver().findElement(By.linkText(linkText));

	}

	/**
	 * Gets the web element by partial link text.
	 *
	 * @param partialLinkText the partial link text
	 * @return the web element by partial link text
	 */
	public static WebElement getWebElementByPartialLinkText(String partialLinkText) {

		return getDriver().findElement(By.partialLinkText(partialLinkText));

	}

	/**
	 * Gets the web element by class name.
	 *
	 * @param className the class name
	 * @return the web element by class name
	 */
	public static WebElement getWebElementByClassName(String className) {

		return getDriver().findElement(By.className(className));

	}

	/**
	 * Gets the web element by css selector.
	 *
	 * @param selector the selector
	 * @return the web element by css selector
	 */
	public static WebElement getWebElementByCssSelector(String selector) {

		return getDriver().findElement(By.cssSelector(selector));

	}

	/**
	 * Gets the web element by C.
	 *
	 * @param tagName the tag name
	 * @return the web element by C
	 */
	public static WebElement getWebElementByC(String tagName) {

		return getDriver().findElement(By.tagName(tagName));

	}

}
