package com.assign9practice;

public class App {
	public static void main(String[] args) {
		
		A a = new A();
		try {
			double per = a.compute(1000, 200);
			System.out.println(per);
		}
		catch(InvalidMarksException e) {
			System.out.println(e.getMessage());
		}
		
	}
}

class A{
	public double compute(double marks, double total) throws InvalidMarksException{
		
		if(marks>total) {
			throw new InvalidMarksException("marks cannot be > total");
		}
		if(marks < 0) {
			throw new InvalidMarksException("marks cannot be less than 0");
		}
		double percent = (marks*100)/total;
		return percent;
		
	}
}


class InvalidMarksException extends Exception{
	
	String message;
	
	InvalidMarksException(String message){
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}