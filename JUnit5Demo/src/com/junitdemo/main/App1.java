package com.junitdemo.main;

public class App1 {
	public static void main(String[] args) {
		MyService a = new MyService();
		int res = a.sum(2,2);
		
		String res1 = a.computeGrade(75);
	}
}
