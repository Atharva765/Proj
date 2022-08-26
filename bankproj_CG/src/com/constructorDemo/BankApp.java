package com.constructorDemo;

public class BankApp {
	public static void main(String[] args) {
		
		Customer c1 = new Customer(5000);
		
		
//		c1.setBal(5000);
//		System.out.println(c1);
		
		B b = new B();  //object
		System.out.println(c1);
		

		
		b.deposit(c1, 3000 );
		System.out.println(c1);
		
		b.withdraw(c1, 2000);  
		System.out.println(c1);
		
		Customer c2 = new Customer(10000);
		b.deposit(c2, 2000);
		System.out.println(c2);
		
		
	}
}
