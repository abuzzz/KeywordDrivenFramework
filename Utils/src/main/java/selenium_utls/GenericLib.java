/*
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

public class GenericLib extends baseClass {
	
	*//** Method performing action or select operation.
	 * @author shasan
	 * @param element
	 * @param value
	 * @param message
	 *//*
	
	static Actions actions = new Actions(getDriver());
	
	public static void clickOnElement(WebElement element, String message){
		
		actions.click(element);
	}
	
	public static void moveToWebElement(WebElement element, String message){
				
		actions.click(element).build().perform();
	}
	
	public static void contextClickWebElement(WebElement element, String message){
		
		actions.contextClick(element).build().perform();
	}
	
	public static void doubleClickWebElement(WebElement element, String message){
		
		actions.doubleClick(element).build().perform();
	}
	
	public static void dragAndDropWebElement(WebElement source, WebElement target, String message){
		
		actions.dragAndDrop(source, target).build().perform();
	}
	
	public static void clickAndHoldWebElement(WebElement element, String message){
		
		actions.clickAndHold(element).build().perform();
	}
	
	
	
	
	// Select options
	
	public static void selectByValue(WebElement element, String value, String message) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public static void deselectByValue(WebElement element, String value, String message) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}
	
	public static void selectByIndex(WebElement element, int index, String message) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public static void deselectByIndex(WebElement element, int index, String message) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	
	public static void selectByVisibleText(WebElement element, String actualValue, String message) {
		Select select = new Select(element);
		select.selectByVisibleText(actualValue);
	}
	
	public static void deselectByVisibleText(WebElement element, String actualValue, String message) {
		Select select = new Select(element);
		select.deselectByVisibleText(actualValue);
	}
	
	public static void deSelectAll(WebElement element, String message) {
		Select select = new Select(element);
		select.deselectAll();
	}
	
	public static boolean isSelectionMultiple(WebElement element, String message) {
		Select select = new Select(element);
		return select.isMultiple();
	}
	
	public static void multiSelect() {
		
	}
}

*/