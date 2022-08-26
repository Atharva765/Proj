package com.exception;

public class Exception1 {
	public static void main(String[] args) {
		A a = new A();
		try {
			int z = a.m1(10, 2);
			System.out.println("Ans is : " + z);
		}
		catch(ArithmeticException c) {
			System.out.println("Invalid input : / by zero not allowed.");
		}
		
		System.out.println("THANKS.");
	}
}


class A{
	public int m1(int x , int y) {
		return x/y;
	}
}

/*
 * Thread (main) : Handle the exception.
*/
