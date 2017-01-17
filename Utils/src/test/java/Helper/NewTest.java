package Helper;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest {
  @Test()
  public void f() {
	  Assert.assertTrue(true);
  }
  
  @Test
  public void f2(){
	  Assert.assertEquals("test", "tester");
  }
}
