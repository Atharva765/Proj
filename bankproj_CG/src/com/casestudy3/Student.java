package com.casestudy3;

public class Student {
	
	private String name;
	private int marks;
	
	Student(String name, int marks){
		this.name = name;
		this.marks = marks;
		
	}
	
	//getter
	public int getMarks() {
		return marks;
	}
	
	public String getName() {
		return name;
	}
	
	//setters
	
	public void setName(String name) {
		this.name = name;
		
	}
	
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public String toString() {
		return "[Name : " + name + "Marks :" + marks + "]";
		
	}
	
}
