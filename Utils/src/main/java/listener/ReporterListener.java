package listener;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import selenium_utls.baseClass;
import Helper.PropertiesReader;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReporterListener extends baseClass implements IReporter {
	private ExtentReports extent;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {
		extent = new ExtentReports(System.getProperty("user.dir")
				+ PropertiesReader.readProperty("report_path"), true);

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}

		for (String s : Reporter.getOutput()) {
			extent.setTestRunnerOutput(s);
		}

		extent.flush();
		extent.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				String method_name = result.getMethod().getMethodName();
						String class_name = result.getMethod().getTestClass().getName() ;
				test = extent.startTest(result.getMethod().getMethodName());
				
				if (listen_map.containsKey(class_name.substring(class_name.lastIndexOf(".")+1,class_name.length()) + method_name))
				{for(String details : listen_map.get(class_name.substring(class_name.lastIndexOf(".")+1,class_name.length()) + method_name))
				test.log(LogStatus.PASS, details);
				}
			
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				if (result.getThrowable() != null) {
					String img = test
							.addScreenCapture((System.getProperty("user.dir")
									+ PropertiesReader
									.readProperty("screenshots") + result
									.getMethod().getMethodName()) + ".jpg");
					test.log(LogStatus.FAIL, result.getThrowable());
					test.log(LogStatus.FAIL, img);
				} else {
					test.log(status, "Test " + status.toString().toLowerCase()
							+ "ed");
				}
				extent.endTest(test);
			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}
