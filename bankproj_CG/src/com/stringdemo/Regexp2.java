package com.stringdemo;

public class Regexp2 {
	public static void main(String[] args) {
		String email = "a.b.c@gmail.com";
		
		boolean valid = email.matches("\\w+@\\w+\\.\\w+");
		System.out.println("Email Validation : "+ valid);
	}
}
