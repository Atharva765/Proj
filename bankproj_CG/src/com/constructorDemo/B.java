package com.constructorDemo;

public class B extends A {

	@Override
	public void withdraw(Customer c, int amount) {
		c.setBal(c.getBal() - amount );
		
	}

}
