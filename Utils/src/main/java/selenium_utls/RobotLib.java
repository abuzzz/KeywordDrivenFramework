package selenium_utls;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class RobotLib.
 */
public class RobotLib {

	/** The log. */
	static Logger log = LogManager.getLogger(RobotLib.class);

	/** The robot. */
	static Robot robot;

	/**
	 * Handle popup.
	 */
	public static void handlePopup() {
		try {
			// Initialize.
			robot = new Robot();
			// Pressing Escape for Browser Alert.
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (AWTException e) {
			log.info(e.getMessage());
		}
		log.info("pop up is handled ");
	}

	/**
	 * File download.
	 */
	public static void fileDownload() {

		try {
			robot = new Robot();

			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_S);
			//GenericLib.impliciytlyWait(10, "10 seconds");

			robot.keyRelease(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_ALT);

			//GenericLib.impliciytlyWait(10, "10 seconds");
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException e) {
			log.info(e.getMessage());
		}

	}

}
