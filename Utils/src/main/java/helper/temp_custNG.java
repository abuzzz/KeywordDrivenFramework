package helper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class temp_custNG {



		@Test(testName = "Nishant")
		public void testOne() {
			Assert.assertTrue(true);
			System.out.println("Pass Test case - testOne");
		}

		@Test(groups = { "Group1" })
		public void testTwo() {
			Assert.assertEquals("AutomationgTesting", "AutomationgTesting");
			System.out.println("Pass Test case - testOne");
		}

		@Test(groups = "Test2")
		public void testThree() {
			Assert.assertTrue(true);
			System.out.println("Pass Test case - testThree");
		}

		@Test()
		public void testThre() {
			Assert.assertTrue(true);
			System.out.println("Pass Test case - testThree");
		}
		public static void main(String[] args) {
			
			List<XmlTest> tests = new ArrayList<XmlTest>();
				List<XmlSuite> suites = new ArrayList<XmlSuite>();
				List<XmlClass> cla = new ArrayList<XmlClass> ();
				/*List <XmlInclude> i_methods  = new  ArrayList<XmlInclude> ();
				
				XmlInclude im = new XmlInclude("test.SQL.Test_custTestNG.testThre");
				
				i_methods.add(im);*/
				
				XmlClass c = new XmlClass("helper.temp_custNG");
				//c.setIncludedMethods(i_methods);
				cla.add(c);
				LinkedList<String> g = new LinkedList<String>();
				g.add("Group1");
				XmlSuite suite = new XmlSuite();
				suite.setName("temp");
				
				XmlTest test = new XmlTest(suite);
				//test.addIncludedGroup("Group1");
				//test.setIncludedGroups(g);
				test.setXmlClasses(cla);
				test.setName("tesmptest");

				suites.add(suite);

				TestNG testNG = new TestNG();
				testNG.setXmlSuites(suites);
				testNG.run();
				
			}		
	}