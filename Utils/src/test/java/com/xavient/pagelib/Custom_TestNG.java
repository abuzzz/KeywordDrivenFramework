package com.xavient.pagelib;



import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import com.xavient.scripts.*;
public class Custom_TestNG {

   

    private void testRunner() {
        TestNG testNG = new TestNG();
        XmlSuite suite = getXmlSuite();
        XmlTest test = getXmlTest(suite);
     
     /*   test.setPackages(getXmlPackagess());*/
     
        List<XmlClass> classes = getXmlClasses();
        test.setXmlClasses(classes);
        List<XmlTest> tests = new ArrayList<XmlTest>();
        tests.add(test);
        suite.setTests(tests);
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        testNG.setXmlSuites(suites);
        testNG.run();
    }

    private XmlSuite getXmlSuite() {
        XmlSuite suite = new XmlSuite();
        suite.setName("Test Suite");
        return suite;
    }

    private XmlTest getXmlTest(XmlSuite suite) {
        XmlTest test = new XmlTest(suite);
        test.setName("Test1");
        return test;
    }

    private List<XmlClass> getXmlClasses() {
        List<XmlClass> classez = new ArrayList<XmlClass>();
        XmlClass clas = new XmlClass("com.xavient.scripts.NewTest"); 
        classez.add(clas);
        
        System.out.println(classez.size());
        return classez;
    }

   /* private XmlPackage getXmlPackagesss(){
    	XmlPackage pkg = new XmlPackage();
    	pkg.setName("com.xavient.scripts");
    	pkg.getInclude();
    	return pkg;
    }
    private List<XmlPackage> getXmlPackagess(){
    	List<XmlPackage>pkgs = new ArrayList<XmlPackage>();
    	pkgs.add(getXmlPackagesss());
    	return pkgs;
    }*/
    public static void main(String args[]) {

    	Custom_TestNG program = new Custom_TestNG();
       
        program.testRunner();
    }
}