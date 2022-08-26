package com.junitdemo.test;


import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.junitdemo.main.MyService;
import com.junitdemo.main.Product;

public class MyServiceTest {
	
	MyService service;
	Product p;
	Product p1;
	
	
	@BeforeClass
	public static void beforeClass() {
		
	}
	
	@Before
	public void init() {
		 service = new MyService();
		 p = new Product("Oppo", 23000);
		 p1 = new Product("Samsung", 15000);
	}
	
	@Test
	public void sumTest() {
		//MyService service = new MyService();
		
		Assert.assertEquals(4,service.sum(2, 2));
		Assert.assertEquals(10, service.sum(5, 5));
		Assert.assertEquals(0, service.sum(-2, 2));
		Assert.assertEquals(-4, service.sum(-2, -2));
	}
	
	@Test
	public void computeGrade() {
		
		//MyService service = new MyService();
		
		Assert.assertEquals("A", service.computeGrade(80));
		Assert.assertEquals("B", service.computeGrade(65));
		Assert.assertEquals("C", service.computeGrade(55));
		Assert.assertEquals("Invalid Marks", service.computeGrade(101));
		Assert.assertEquals("Invalid Marks", service.computeGrade(-1));
	}
	@Test
	public void addProduct() {
		
		//MyService service = new MyService();
		
		//Product p = new Product("Oppo", 23000);
		Assert.assertEquals(0, service.list.size());
		Assert.assertEquals("Product added", service.addProduct(p));
		Assert.assertEquals(1, service.list.size());
		Assert.assertEquals("Product already present", service.addProduct(p));
		//Product p1 = new Product("Samsung", 13000);
		Assert.assertEquals("Product added", service.addProduct(p1));
		Assert.assertEquals(2, service.list.size());
		
	}
	@Test
	public void removeProduct() {
		
	//	MyService service = new MyService();
		
		//Product p = new Product("Oppo", 25000);
		Assert.assertEquals(0, service.list.size());
		service.addProduct(p);
		Assert.assertEquals(1, service.list.size());
		Assert.assertEquals("Removed", service.removeProduct(p));
		Assert.assertEquals("product does not exist", service.removeProduct(p));
		
	
	}
	@Test
	public void listSize() {
		
		Assert.assertEquals(0, service.listSize());
		service.addProduct(p);
		Assert.assertEquals(1, service.listSize());
		service.addProduct(p1);
		Assert.assertEquals(2, service.listSize());
	}
	
	@Test
	public void testM() {
		assumeFalse(10>0);
		fail("not ");
	}
	
	@After
	public void after() {
		service = null;
		p =  null;
		p1 = null;
	}
	
	@AfterClass
	public static void afterClass() {
		
	}
	
	
	
}
