package selenium_utls;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.bcel.util.ClassPath.ClassFile;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.Connection.Method;

import com.xavient.scripts.Login;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportLog.
 */
public class ReportLog {

	/** The log. */
	static Logger log;

	/** The array. */
	static ArrayList<String> array = new ArrayList<String>();

	/**
	 * Log info message.
	 *
	 * @param message the message
	 * @param className the class name
	 */
	public static void LogInfoMessage(String message, String className) {
		log = LogManager.getLogger(className);
		log.info(message);
		array.add(message);
		for (String data : array) {
			System.out.println(data);
		}

	}

	/**
	 * Log error message.
	 *
	 * @param message the message
	 * @param className the class name
	 */
	public void LogErrorMessage(String message, String className) {
		log = LogManager.getLogger(className);
		log.error(message);
		array.add(message);
		for (String data : array) {
			System.out.println(data);
		}

	}

	/**
	 * Logfatal message.
	 *
	 * @param message the message
	 * @param className the class name
	 */
	public void LogfatalMessage(String message, String className) {
		log = LogManager.getLogger(className);
		log.fatal(message);
		array.add(message);
		for (String data : array) {
			System.out.println(data);
		}
	}

	/**
	 * Log warn message.
	 *
	 * @param message the message
	 * @param className the class name
	 */
	public void LogWarnMessage(String message, String className) {

		log = LogManager.getLogger(className);
		log.warn(message);
		array.add(message);
		for (String data : array) {
			System.out.println(data);
		}
	}

	/**
	 * Log debug message.
	 *
	 * @param message the message
	 * @param className the class name
	 */
	public void LogDebugMessage(String message, String className) {

		log = LogManager.getLogger(className);
		log.debug(message);
		array.add(message);
		for (String data : array) {
			System.out.println(data);
		}
	}

}
