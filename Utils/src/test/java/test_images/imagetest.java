package test_images;

import java.io.File;

import helper.VerifyImage_UI;

import org.testng.annotations.Test;

import com.google.common.base.Verify;

public class imagetest {
	
	@Test
	public void test_images()
	{
		Verify.verify(VerifyImage_UI.verify_image(System.getProperty("user.dir")+ File.separator + "icon200.png", System.getProperty("user.dir") + File.separator + "201.png"));
		
	}

}
