package com.exception;

public class Exception2 {
	public static void main(String[] args) {
		B b = new B();
		
		
		try {
			int ans =  b.m1(10,0);       //new ArithmaticException();
			System.out.println("Ans is :" + ans);
			
		}
		catch(ArithmeticException c) {
			System.out.println("Invalid Input: / by 0 not possible!!"); 
		}
		catch(ArrayIndexOutOfBoundsException a) {
			System.out.println("Check the index of the array!");
		}
		System.out.println("THANKS");
	}
}


class B{

	public int m1(int n1, int n2) throws ArithmeticException, ArrayIndexOutOfBoundsException {
		if(n2 == 0) {
			throw new ArithmeticException(); // manually throwing exception.
		}
		return n1/n2;
	}
	
}
