package Helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlGroups;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

/*

*/

public class TestNgXmlUsingCode{

public void testNgXmlSuite() {

       List<XmlSuite> suites = new ArrayList<XmlSuite>();
       List<XmlClass> classes = new ArrayList<XmlClass>();
       List<Class> listenerClasses = new ArrayList<Class>();
       //List<XmlGroups>  groupee = new ArrayList<XmlGroups>();
       List<Class<? extends ITestNGListener>> clsListener = new ArrayList<>();
       List<String>ingrp = new ArrayList<String>();
       List<? extends XmlPackage> pkg = new ArrayList<>();

       XmlSuite suite = new XmlSuite();
       suite.setName("ProgramSuite");
       
       XmlTest test = new XmlTest(suite);
       test.setName("ProgramTest");
       
       //XmlGroups group1 = new XmlGroups();.
       ingrp.add("Group1");	
       test.addMetaGroup("Integration", ingrp);
       test.addIncludedGroup("Group1");
       
     /*  pkg.add("com.xavient.scripts");
       test.setPackages(sspkg);*/
       
      

		XmlClass class1 = new XmlClass("Helper.FactoryMethod");
		
       classes.add(class1);
       
       
       

    /*  XmlClass clss2 = new 
       classes.add(clss2);*/

       clsListener.add(ListenerTest.class);

       test.setXmlClasses(classes);
       suites.add(suite);

       TestNG tng = new TestNG();

       tng.setXmlSuites(suites);
       tng.setListenerClasses(clsListener);
       tng.run();
   }

   public static void main(String[] args) {
   TestNgXmlUsingCode tnxuc = new TestNgXmlUsingCode();
       tnxuc.testNgXmlSuite();
   }

}
