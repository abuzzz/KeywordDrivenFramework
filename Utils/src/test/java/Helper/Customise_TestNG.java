package Helper;



import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
public class Customise_TestNG {

   

    private void testRunner() {
        TestNG testNG = new TestNG();
        XmlSuite suite =  new XmlSuite();
        suite = getXmlSuite(suite);
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

    private XmlSuite getXmlSuite(XmlSuite suite) {
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
        XmlClass clas = new XmlClass("Helper.Test2"); 
        classez.add(clas);
        
        System.out.println(classez.size());
        return classez;
    }

    private XmlPackage getXmlPackagesss(){
    	XmlPackage pkg = new XmlPackage();
    	pkg.setName("com.xavient.scripts");
    	pkg.getInclude();
    	return pkg;
    }
    private List<XmlPackage> getXmlPackagess(){
    	XmlPackage pkg = new XmlPackage("Helper");
    	List<XmlPackage>pkgs = new ArrayList<XmlPackage>();
    	pkgs.add(pkg);
    	return pkgs;
    }
    //Method to return total number  of classes in a package
    
    private List<XmlClass> getClassesForPackages (List<XmlPackage>pk){
    	 List<XmlClass> cls = null;
    	pk = getXmlPackagess();
    	for(XmlPackage pack : pk){
    		cls=pack.getXmlClasses();
    	    	}
		return cls;
		
    	
    }
    public static void main(String args[]) {

    /*	Customise_TestNG program = new Customise_TestNG();
       
        program.testRunner();*/
    	
    	XmlPackage pkg = new XmlPackage("Helper");
    	
    
    	List <XmlClass> classes = pkg.getXmlClasses();
    	System.out.println(classes.size());
    }
}