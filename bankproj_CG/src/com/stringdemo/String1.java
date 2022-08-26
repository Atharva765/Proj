package com.stringdemo;

public class String1 {
	public static void main(String[] args) {
		
		/*
		 * String can be created in two ways:
		 * 1. Literal : goes in string-pool (Special memory)
		 * 2. Object : Goes in heap.
		 */
		
		//String Literal
		String s1 = "hello java";
		
		//String Object
		String s2 = new String ("hello java");
		
		//Literal
		String s3 = "hello java";
		
		//String object
		String s4 = new String("hello java");
		
		/*
		 * Note : String pool does not eccept duplicate values.
		 */
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		
		/* COMPARISION 
		 * 1. equals()
		 * 2. == operator.
		 */
		
		
		/*
		 * RULE: equals() in String Compare values.
		 * 		 == operator compares locations.
		 */
		
		System.out.println(s1.equals(s2));  //true
		System.out.println(s1 == s2);  //false
		
		System.out.println(s1.equals(s3));  //true
		System.out.println(s1 = s3);  //true  -> as values are same , string pool will not create another memory location.
		
		System.out.println(s2.equals(s4)); // true
		System.out.println(s2 == s4);   //false.
		
	}
}


















