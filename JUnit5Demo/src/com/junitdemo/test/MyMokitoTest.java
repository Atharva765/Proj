package com.junitdemo.test;

import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.junitdemo.service.MyMokitoService;

public class MyMokitoTest {
	MyMokitoService  mms;
	
	@Before
	public void init() {
		mms = Mockito.mock(MyMokitoService.class);
	}
	
	@Test
	public void computeGradeTest() {
		
		when(mms.computeGrade(80)).thenReturn("A");
		when(mms.computeGrade(65)).thenReturn("B");
		when(mms.computeGrade(55)).thenReturn("C");
		when(mms.computeGrade(105)).thenReturn("Invalid marks");
		when(mms.computeGrade(-1)).thenReturn("Invalid marks");
	}
	
	@After
	public void after() {
		mms = null;
	}
}
