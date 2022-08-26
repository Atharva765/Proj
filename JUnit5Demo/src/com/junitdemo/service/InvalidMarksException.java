package com.junitdemo.service;

public class InvalidMarksException extends Exception{

	String message;
	
	public InvalidMarksException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}


