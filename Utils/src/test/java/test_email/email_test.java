package test_email;

import org.testng.annotations.Test;

import selenium_utls.SendingEmail;

public class email_test {
	
	@Test
	public void send_email(){
		SendingEmail.execute();
	}

}
