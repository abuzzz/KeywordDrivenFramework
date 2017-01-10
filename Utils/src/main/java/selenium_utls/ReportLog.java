package selenium_utls;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.bcel.util.ClassPath.ClassFile;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.Connection.Method;

import com.xavient.scripts.Login;

public class ReportLog {

	static Logger log;

	static ArrayList<String> array = new ArrayList<String>();

	public static void LogInfoMessage(String message, String className) {
		log = LogManager.getLogger(className);
		log.info(message);
		array.add(message);
		for (String data : array) {
			System.out.println(data);
		}

	}

	public void LogErrorMessage(String message, String className) {
		log = LogManager.getLogger(className);
		log.error(message);
		array.add(message);
		for (String data : array) {
			System.out.println(data);
		}

	}

	public void LogfatalMessage(String message, String className) {
		log = LogManager.getLogger(className);
		log.fatal(message);
		array.add(message);
		for (String data : array) {
			System.out.println(data);
		}
	}

	public void LogWarnMessage(String message, String className) {

		log = LogManager.getLogger(className);
		log.warn(message);
		array.add(message);
		for (String data : array) {
			System.out.println(data);
		}
	}

	public void LogDebugMessage(String message, String className) {

		log = LogManager.getLogger(className);
		log.debug(message);
		array.add(message);
		for (String data : array) {
			System.out.println(data);
		}
	}

}
