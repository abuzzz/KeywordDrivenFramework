package selenium_utls;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericLib extends Browsers {

	static Logger log = LogManager.getLogger(GenericLib.class);

	// To Click on Any WebElement
	public static void clickOnElement(WebElement element, String message) {

		try {

			log.info("Webelement" + message);
			element.click();
		} catch (Exception e) {
			log.info(e.getMessage());
		}

	}

	// Send any value in to text box
	public static void sendValueInToTextBox(WebElement element, String actualValue, String message) {

		try {

			log.info("Sending Values in " + message);
			element.sendKeys(actualValue);
		} catch (Exception e) {
			log.info(e.getMessage());
		}

	}

	public static void clearTheTextBoxAndSendValue(WebElement element, CharSequence actualValue, String message) {

		try {
			log.info("Clearing and Sending value in " + message);

			element.clear();

			element.sendKeys(actualValue);
		} catch (Exception e) {
			log.info(e.getMessage());
		}

	}

	// Select any value from select box using visibleText
	public static void selectByVisibleText(WebElement element, String actualValue, String message) {

		try {
			log.info("Selecting" + message);

			Select sel = new Select(element);

			sel.selectByVisibleText(actualValue);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	// Select any value from select box using IndexValue
	public static void selectByIndex(WebElement element, int actualIndex, String message) {

		try {
			log.info("Selecting" + message);

			Select sel = new Select(element);

			sel.selectByIndex(actualIndex);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	// Select any value from select box using Value
	public static void selectByValue(WebElement element, String actualValue, String message) {

		try {
			log.info("Selecting" + message);

			Select sel = new Select(element);

			sel.deselectByValue(actualValue);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	// implicit wait
	public static void impliciytlyWait(long timeDuration, String message) {

		try {
			log.info("waiting for" + message);
			DRIVER.manage().timeouts().implicitlyWait(timeDuration, TimeUnit.SECONDS);

		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	// Page load timeout
	public static void pageLoadTimeOut(long timeDuration, String message) {

		try {
			log.info("waiting for" + message);

			DRIVER.manage().timeouts().pageLoadTimeout(timeDuration, TimeUnit.SECONDS);

		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	// Script timeOut
	public static void scriptTimeOut(long timeDuration, String message) {

		try {

			log.info("waiting for" + message);

			DRIVER.manage().timeouts().setScriptTimeout(timeDuration, TimeUnit.SECONDS);

		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	// Explicit Wait
	public static void explicitlyWait(long timeDuration, WebElement element, String message) {

		try {
			log.info("waiting for" + message);

			WebDriverWait wait = new WebDriverWait(DRIVER, timeDuration);

			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	// Thread sleep wait
	public void constantWait(long timeDuration, String message) {

		try {

			log.info("waiting for " + message);

			Thread.sleep(timeDuration);

		} catch (InterruptedException e) {

			log.info(e.getMessage());
		}
	}

	// Move to any element
	public static void moveToWebElement(WebElement element, String message) {

		try {

			log.info("Move to " + message);

			Actions act = new Actions(DRIVER);

			act.moveToElement(element).build().perform();

		} catch (Exception e) {
			log.info(e.getMessage());
		}

	}

	// right Click on any element
	public static void contextClickOnWebElement(WebElement element, String message) {
		try {

			log.info("contextClick on" + message);
			Actions act = new Actions(DRIVER);

			act.contextClick(element).build().perform();

		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	// double click on any web element
	public static void doubleClickOnWebElement(WebElement element, String message) {
		try {

			log.info("doubleClick on" + message);

			Actions act = new Actions(DRIVER);

			act.doubleClick(element).build().perform();

		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	// Drag and drop any webElement
	public static void dragAndDropWebElement(WebElement source, WebElement target, String message) {
		try {

			log.info("drag and drop file" + message);

			Actions act = new Actions(DRIVER);

			act.dragAndDrop(source, target).build().perform();

		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	// Click and hold any web element
	public static void clickAndHoldWebElement(WebElement element, String message) {
		try {

			log.info("Click and hold" + message);

			Actions act = new Actions(DRIVER);

			act.clickAndHold(element).build().perform();

		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	// Click on enter button
	public static void clickOnEnterButton(String message) {
		try {

			log.info("Performing" + message);

			Actions act = new Actions(DRIVER);

			act.sendKeys(Keys.ENTER).build().perform();

		} catch (Exception e) {
			log.info("");
		}
	}

	// Accept Alert Pop up
	public static void acceptAlert(String message) {
		try {
			log.info("Accept" + message);
			Alert alt = DRIVER.switchTo().alert();
			alt.accept();
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	// Dismiss Alert Pop up
	public static void dismissAlert(String message) {
		try {
			log.info("Dismiss" + message);
			Alert alt = DRIVER.switchTo().alert();
			alt.dismiss();
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
}
