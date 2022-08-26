package com.constructorDemo;

abstract public class A implements Ops{

	@Override
	public void deposit(Customer c, int amount) {
		// TODO Auto-generated method stub
		c.setBal(c.getBal() + amount );  //5000 +3000 = 8000
		
	}
}
	
