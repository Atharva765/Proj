package com.assign10practice;

class Activity{
	
	private String string1;
	private String string2;
	private String operator;
	
	public Activity(String string1, String string2, String operator) {
		this.operator = operator;
		this.string1 = string1;
		this.string2 = string2;
	}
	
	public Activity() {
		
	}
	
	
	public String getString1() {
		return string1;
	}
	
	public String getString2() {
		return string2;
	}
	
	public String getOperator() {
		return operator;
	}
}


public class Source {
	
	
	
	public static void main(String[] args) {
		
		Activity a = new Activity("HelloWORLD", "world", "+");
		
		Source s = new Source();
		try {
			System.out.println(s.handleException(a));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(s.doOperation(a));
	}
	
	
	public String handleException(Activity a) throws Exception{
		
		if(a.getString1().equalsIgnoreCase(null)) {
			throw new NullPointerException("Null values found");
		}
		
		else if(a.getString2().equalsIgnoreCase(null)) {
			throw new NullPointerException("Null values found"); 
		}
		else if( a.getOperator() != "+" && a.getOperator() != "-" ){
			throw new Exception(a.getOperator());
		}
		else {
			return "No Exception Found";
		}
		
	}
	
	public String doOperation(Activity a) {
		
		String res = null;
		
		switch(a.getOperator()) {
		
		case "+": 
			 res =  a.getString1().concat(a.getString2());
			 
			 break;

		case "-" :
			
			if(a.getString1().toLowerCase().contains(a.getString2())) {
				 res = a.getString1().toLowerCase().replaceAll(a.getString2(), "");
				
			}
			break;
		}
		
		return res;
		
	}
	
	
}
