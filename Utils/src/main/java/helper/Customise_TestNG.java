package helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.verify.*;

import selenium_utls.ExcelLib;
import selenium_utls.ReportLog;
import selenium_utls.ReportLog.log;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Customise_TestNG {

	//Declare OR Initialise 
	LinkedList data = new LinkedList();
	Iterator iter = data.iterator();
	Multimap<String, String> map_data = ArrayListMultimap.create();
	Map<String, String> param_data = new HashMap<String, String>();
	String classes_name = null;
	String pack_name = null;
	String param_level = null;
	public ReportLog reportLog = new ReportLog("Customise_TestNG");

	/**
	 * Creating TestNG XML.
	 */
	public void run() {
		// Declare OR Initialise
		List<XmlTest> tests = new ArrayList<XmlTest>();
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		XmlSuite suite = set_suite_details();
		//suite = addListner(suite);
		XmlTest test = new XmlTest(suite);
		// Set tests parameter , add class , package , methods.
		tests = add_Test(suite, tests, test);
		// Add suite .
		suites.add(suite);
		
		// Running Tests.
		TestNG testNG = new TestNG();
		testNG.setXmlSuites(suites);
		testNG.run();
	}

	/**
	 * Set tests parameter and add class , package , methods.
	 * 
	 * @param suite
	 * @param tests
	 * @param test
	 * @return
	 */
	private List<XmlTest> add_Test(XmlSuite suite, List<XmlTest> tests,	XmlTest test) {
//Declare and Initialise .
		Multimap<Integer, String> map_data = ArrayListMultimap.create();
		String test_name;
		map_data = ExcelLib.getCellData("GenerateXMLdata", "Test Case Name");
//Looping through test cases.
		for (Map.Entry s : map_data.entries()) {
//Fetching and set test name 
			test_name = s.getValue().toString();
//If null set test name to random value.			
			if (test_name == null || test_name == "") {
				reportLog.LOG(log.DEBUG, "Test Name is Null or not present","add_Test");
				test_name = "temp" + Helper.generateRandomAlphabetsString(5) + "auto";
			}
			test.setName(test_name);
//Fetch classes.
			classes_name = ExcelLib.getCellData("GenerateXMLdata","Class Name", (int) s.getKey());
//Fetch packages.
			pack_name = ExcelLib.getCellData("GenerateXMLdata", "Package Name",	(int) s.getKey());
//Add class to test if not null or empty .
			if (classes_name != null || classes_name != "") {
				test.setXmlClasses(getXmlClasses((int) s.getKey(), test,classes_name));
				test.setIncludedGroups(set_groups((int) s.getKey()));
			} 
//Add Package to test if not null or empty .
			else if (pack_name != null || pack_name != "") {
				test.setPackages(getXmlPackages((int) s.getKey()));
				test.setIncludedGroups(set_groups((int) s.getKey()));
			} 
//Throw error if both class and package are null or empty.
			else {
				Verify.verifyEquals("Throw Error", "Do not throw error");
			}
//Set parameters for tests and add to test list.
			test.setParameters((Map<String, String>) set_params((int) s	.getKey()));
			tests.add(test);
		}

		return tests;
	}

	/**
	 * Set paramaters of test_cases.
	 * @param row_num
	 * @return parameters.
	 */
	private Map<String, String> set_params(int row_num) {
		// TODO Auto-generated method stub
		String params_name = ExcelLib.getCellData("GenerateXMLdata"	,"Parameters", row_num);
		param_data = Helper.generate_key_value(params_name, param_data);

		return param_data;
	}

	/**
	 * Setting Classes for testing.
	 * 
	 * @param row_num
	 * @param test
	 * @return XmlClass list
	 */
	private List<XmlClass> getXmlClasses(int row_num, XmlTest test,
			String classes_name) {
// Initilaize class names variables.
		String class_name = "";
		data = Helper.remove_comma_delimeter(classes_name);
		List<XmlClass> classes = new ArrayList<XmlClass>();

// Initilaize Method names variables.
		String methods_name = ExcelLib.getCellData("GenerateXMLdata",
				"Method Name", row_num);
		LinkedList<String> method_list = new LinkedList<String>();
		method_list = Helper.remove_comma_delimeter(methods_name);
//Iterate through method names.
		for (int i = 0; i < data.size(); i++) {
			class_name = data.get(i).toString();
			if (class_name != "" && class_name != null) {
				XmlClass clas = new XmlClass(class_name);
//Add method(s) to classes if not empty.
				if (!method_list.isEmpty())
					clas = getXmlIncludes(class_name, clas, method_list);
//Adding class to list of classes.
				classes.add(clas);
			} else {
//Class is not present or null.
				reportLog.LOG(log.DEBUG, "Class Name is Null or not present","getXmlClasses");
			}
		}
		return classes;
	}
/**
 * Include methods in class.
 * @param class_name
 * @param clas
 * @param temp
 * @return XmlClass with methods in it.
 */
	private XmlClass getXmlIncludes(String class_name, XmlClass clas,List<String> temp) {
		List<XmlInclude> i_methods = new ArrayList<XmlInclude>();
//Iterate through method list and add to classes.
		for (String temp_str : temp) {
			if (temp_str.contains(class_name)) {
				i_methods.add(new XmlInclude(temp_str.substring(
						temp_str.lastIndexOf(".") + 1, temp_str.length())));
			}
		}
		clas.setIncludedMethods(i_methods);
		
		return clas;
	}

	/**
	 * Add package name in package list 
	 * @param row_num
	 * @return XmlPackage list.
	 */
	private List<XmlPackage> getXmlPackages(int row_num) {
//Declare and Initialise .
		List<XmlPackage> packages = new ArrayList<XmlPackage>();
		String package_name = "";
		data = Helper.remove_comma_delimeter(pack_name);
		Iterator iter = data.iterator();
//	Add package name in package list 	
		while (iter.hasNext()) {
			package_name = iter.next().toString();
			if (package_name != "" && package_name != null) {
				XmlPackage pack = new XmlPackage(package_name);
				packages.add(pack);
//	Throw Error.	
			} else {
				Verify.verifyEquals(package_name, "","Package Name is not present");
				Verify.verifyEquals(package_name, null, "Package Name is null");
			}
		}
		return packages;
	}

	/**
	 * Set suite details like name , params etc.
	 * @return XmlSuite
	 */
	public XmlSuite set_suite_details() {
		XmlSuite suite = new XmlSuite();
		String suite_name = ExcelLib.getCellData("GenerateXMLdata", 0, 0);
		suite.setVerbose(2);
		suite.setParallel("tests");
		suite.setThreadCount(5);
		
		if (suite_name.equals("") || suite_name.equals(null))
			suite.setName("Temp_Suite");
		else
			suite.setName(suite_name);

		return suite;
	}
	
	private XmlSuite addListner(XmlSuite suite) {
		String listeners  = ExcelLib.getCellData("GenerateXMLdata", 1, 0);
		List<String> datas = Helper.remove_comma_delimeter(listeners);
		for (String listener : datas)
			suite.addListener(listener);
		return suite;
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * Get group   names.
	 * @param row_num
	 * @return List of group names.
	 */
	public List<String> set_groups(int row_num) {
		String groups_name = ExcelLib.getCellData("GenerateXMLdata",
				"Group Name", row_num);

		List<String> datas = Helper.remove_comma_delimeter(groups_name);

		return datas;
	}

	/*public static void main(String[] args) {
		Customise_TestNG program = new Customise_TestNG();
		program.run();
		
	}*/

	@Test(groups = "Group1")
	public void testOne() {
		Assert.assertTrue(true);
		System.out.println("Pass Test case - testOne Test3");
	}

	@Test(groups = "Group1")
	public void testTwo() {
		Assert.assertEquals("AutomationgTesting", "AutomationgTesting ");
		System.out.println("Pass Test case - testOne Test3");
	}

	@Test(groups = "Test2")
	public void testThree() {
		Assert.assertTrue(true);
		System.out.println("Pass Test case - testThree Test3 ");
	}

	@Test()
	public void testThre() {
		Assert.assertTrue(true);
		System.out.println("Pass Test case - testThree Test3");
	}
}