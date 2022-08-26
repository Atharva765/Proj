package com.junitdemo.service;

public class MyMokitoService {
	public String computeGrade(int marks) {
		
		if(marks>100 || marks<0)
			return "Invalid marks";
		return marks>70? "A":marks>60?"B":"C";
	}
}
