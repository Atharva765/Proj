package com.exception;

import java.io.IOException;

public class Exception3 {
	public static void main(String[] args) {
		C c = new C();
		
		try {
			c.m1(99);
			
		}
		catch(IOException e) { //handling of exception
			System.out.println("IOException Thrown");
		}
		
		System.out.println("Thanks");
	}
}

class C{

	public void m1(int marks) throws IOException {  //warning the exception
		if(marks > 100) {
			throw new IOException();  //checked exception
		}
		System.out.println("Processed.");
	}
	
}

/*
 * When a checked exception is thrown, the programmer has to:
 * 1. Warn about exception.
 * 2. handle exception in main method. 
 * */

/*
 * in Unchecked exception it is the choice of programmer weather to warn/handle about the exception or not. 
 */
