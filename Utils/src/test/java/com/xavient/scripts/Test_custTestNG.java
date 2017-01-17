package com.xavient.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
 
public class Test_custTestNG {
    @Test(groups="Group1")
    public void testOne() {
        Assert.assertTrue(true);
        System.out.println("Pass Test case - testOne");
    }
 
    @Test(groups="Group1")
    public void testTwo() {
        Assert.assertEquals("AutomationgTesting", "AutomationgTest");
        System.out.println("Pass Test case - testOne");
    }
 
    @Test(groups="Test2")
    public void testThree() {
        Assert.assertTrue(true);
        System.out.println("Pass Test case - testThree");
    }
    
    @Test()
    public void testThre() {
        Assert.assertTrue(true);
        System.out.println("Pass Test case - testThree");
    }
}