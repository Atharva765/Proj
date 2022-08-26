package com.assign10practice;


import org.junit.Assert;
import org.junit.Test;

public class SourceTest {
	
	@Test
	public void handleException() {
		Source s = new Source();
		Activity a= new Activity(null, "world", "+");
		
		try {
			s.handleException(a);
		} catch (Exception e) {
			Assert.assertEquals("Null values found", e.getMessage());
		}
		
		a= new Activity("hello", null, "+");
		try {
			s.handleException(a);
		} catch (Exception e) {
			Assert.assertEquals("Null values found", e.getMessage());
		}
		
		a = a= new Activity("hello", "world", "*");
		try {
			s.handleException(a);
		} catch (Exception e) {
			Assert.assertEquals("*", e.getMessage());
		}
		
		a = a= new Activity("hello", "world", "+");
		try {
			s.handleException(a);
		} catch (Exception e) {
			Assert.assertEquals("No Exception Found", e.getMessage());
		}
	}
	
	
	@Test
	public void doOperationTest() {
		
		Source s = new Source();
		Activity a= new Activity("hello", "world", "+");
		Assert.assertEquals("helloworld", s.doOperation(a));
		
		a= new Activity("helloworld", "world", "-");
		Assert.assertEquals("hello", s.doOperation(a));
		
	}
	
	
	
	
}
