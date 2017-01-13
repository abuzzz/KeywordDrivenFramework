package selenium_utls;

import java.util.LinkedList;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportLog.
 */
public class ReportLog extends baseClass {

	// Enum for different log status.
	public enum log {
		INFO, DEBUG, ERROR, FATAL
	};

	// Initalizing Objects.
	Logger logger;
	String map_key = "";
	/**
	 * Constructor for initializing log object.
	 * @param map_key, This is Name of Class.
	 */
	public ReportLog(String class_name) {
		map_key = class_name;
		logger = Logger.getLogger(class_name);

	}

	/**
	 * Method for printing logs in console , file and Report.
	 * 
	 * @param status
	 *            , Type of Log.
	 * @param message
	 *            , Message to print.
	 * @param methods_name
	 *            , Name of Method.
	 */
	public void LOG(log status, String message, String methods_name) {
		// Adding Values to Map for Listener to read.
		if (!listen_map.containsKey(map_key + methods_name))
			listen_map.put(map_key + methods_name, new LinkedList<String>());

		listen_map.get(map_key + methods_name).add(message);
		// Printing Logs in file and console.
		switch (status) {
		case INFO:
			logger.info(message);
			break;

		case DEBUG:
			logger.debug(message);
			break;

		case ERROR:
			logger.error(message);
			break;

		case FATAL:
			logger.fatal(message);
			break;

		default:
			logger.error("NOT A VALID TYPE");
		}
	}
}