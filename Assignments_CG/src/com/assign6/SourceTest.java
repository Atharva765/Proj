package com.assign6;

import org.junit.Assert;
import org.junit.Test;

public class SourceTest {
	
	@Test
	public void emailVerifyTest() {
		EmailOperations e = new EmailOperations();
		
		Header h = new Header("atharva@gmail.com", "nihal@gmail.com");
		Email e1 = new Email(h,"Hi There Hows you","Regards");
		
		Assert.assertEquals(2, e.emailVerify(e1));
		
		Header h1 = new Header("atharva@", "nihal@gmail.com");
		Email e2 = new Email(h1,"Hi There Hows you","Regards");
		
		Assert.assertEquals(1, e.emailVerify(e2));
		
		Header h2 = new Header("atharva@", "nihal@");
		Email e3 = new Email(h2,"Hi There Hows you","Regards");
		
		Assert.assertEquals(0, e.emailVerify(e3));
	}
	
	@Test
	public void bodyEncryption() {
		EmailOperations e = new EmailOperations();
		
		Header h = new Header("atharva@gmail.com", "nihal@gmail.com");
		Email e1 = new Email(h,"Hi There Hows you","Regards");
		
		Assert.assertEquals("Kl Wkhuh Krzv brx", e.bodyEncryption(e1));
		
	}
	
	@Test		
	public void greetingMessageTest() {
		
		EmailOperations e = new EmailOperations();
		
		Header h = new Header("atharva@gmail.com", "nihal@gmail.com");
		Email e1 = new Email(h,"Hi There Hows you","Thank You");
		
		Assert.assertEquals("Thank You atharva", e.greetingMessage(e1));
	}
	
	
}
