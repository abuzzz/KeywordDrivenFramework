package test_verify;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.verify.Verify;

@Listeners ({org.verify.TestMethodListener.class})
public class testverify {
	
	@Test 
	public void test1()
	{
		Verify.verifyEquals("test", "test");
	}
	
	@Test 
	public void test2()
	{
		Verify.verifyEquals(1, 2);
		System.out.println("Here is o/p");
	}


}
