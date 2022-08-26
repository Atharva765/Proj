package com.stringdemo;

public class Regexp1 {
	public static void main(String[] args) {
		String str = "91 india 44 UK 566 USA";
		String[] sarry = str.split("\\s");
		
		for(String temp: sarry) {
			System.out.println(temp);	
		}
		
		System.out.println("\n=======countries========");
		sarry = str.split("\\d+\\s");
		
		for(String temp : sarry) {
			System.out.println(temp);
		}
		
		System.out.println("\n=======country codes========");
		sarry = str.split("\\s[a-zA-Z]+");
		for(String temp : sarry) {
			System.out.println(temp.trim());
		}
		
		
		
	}
}
/*
 * -------REGULAR EXPRESSION----------
 * 
 * \w : word[a-zA-Z0-9]
 * \d : number[0-9]
 * +  : one or more
 * *  : zero or more
 * ^  : starts with
 * $  : ends with
 * \s : space
 * " ": space
 */










