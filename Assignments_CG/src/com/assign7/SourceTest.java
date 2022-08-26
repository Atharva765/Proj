package com.assign7;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SourceTest {

	GenerateReceipt g ;
	Receipt r;
	TransactionParty t;
	
	@Before
	public void init() {
		g = new GenerateReceipt();
		r= new Receipt();
		t = new TransactionParty();
	}
	
	@Test
	public void verifyTest() {
		
		TransactionParty t = new TransactionParty("Daniel D'Cruz" , "Giselle Dawn-Wright");
		Receipt r = new Receipt(t,"250,10@100,3@50,7" );
		Assert.assertEquals(2, g.verify(r));
		
		TransactionParty t1 = new TransactionParty("-Daniel D'Cruz" , "Giselle Dawn-Wright");
		Receipt r1 = new Receipt(t1,"250,10@100,3@50,7" );
		Assert.assertEquals(1, g.verify(r1));
		
		TransactionParty t2 = new TransactionParty("-Daniel D'Cruz" , "-Giselle Dawn-Wright");
		Receipt r2 = new Receipt(t2,"250,10@100,3@50,7" );
		Assert.assertEquals(0, g.verify(r2));
	}
	
	
	@Test
	public void calcGST() {
		
		TransactionParty t = new TransactionParty("Daniel D'Cruz" , "Giselle Dawn-Wright");
		Receipt r = new Receipt(t,"250,10@100,3@50,7" );
		Assert.assertEquals("GeneratedReceipt [GST = INR.37800/-]", g.calcGST(r));
		
		
		TransactionParty t1 = new TransactionParty("Daniel D'Cruz" , "Giselle Dawn-Wright");
		Receipt r1 = new Receipt(t1,"150,10@200,3@150,10" );
		Assert.assertEquals("GeneratedReceipt [GST = INR.43200/-]", g.calcGST(r1));
	}
	
	@After
	public void after() {
		g = null;
		r= null;
		t=null;
	}
}
