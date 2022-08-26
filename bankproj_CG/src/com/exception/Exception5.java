package com.exception;

public class Exception5 {
	public static void main(String[] args) {
		
		E e = new E();
		
		try {
			e.m1();
		}
		catch(ArithmeticException a) {
			System.out.println("AE"); 
		}
		catch(RuntimeException a) {  //RuntimeException a = new ArithmaticException();  -> Polymorphic object 
			System.out.println("RE");
		}
		
		catch(Exception a) {     //Exception e = new RuntimeException();  -> -> Polymorphic object
			System.out.println("Ex");
		}
		System.out.println("Thanks");
	}
}


class E{

	public void m1() {
		throw new ArithmeticException();
	}
	
}

/*
* in multiple catch block follow the hierarchy i.e small->high
*/