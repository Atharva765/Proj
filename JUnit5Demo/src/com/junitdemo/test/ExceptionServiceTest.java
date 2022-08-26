package com.junitdemo.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.junitdemo.service.ExceptionService;
import com.junitdemo.service.InvalidMarksException;

public class ExceptionServiceTest {
	
	ExceptionService exs;
	
	@Before
	public void init() {
		exs = new ExceptionService();
	}
	
	@Test(expected = ArithmeticException.class)
	public void computeTest() {
		Assert.assertEquals(2, exs.compute(10, 5));
		Assert.assertEquals(2, exs.compute(10, 0));
	}
	
	@Test
	public void computeGradeTest() throws InvalidMarksException {
		Assert.assertEquals("A", exs.computeGrade(80));
		Assert.assertEquals("B", exs.computeGrade(65));
		Assert.assertEquals("C", exs.computeGrade(55));
		
		try {
			exs.computeGrade(101);
		}
		catch(InvalidMarksException e) {
			Assert.assertEquals("marks should be less than 100", e.getMessage());
		}
		
		try {
			exs.computeGrade(-1);
		}
		catch(InvalidMarksException e) {
			Assert.assertEquals("marks should be greater than 0", e.getMessage());
		}
	}
	
	
	@After
	public void after() {
		exs = null;
	}
}
