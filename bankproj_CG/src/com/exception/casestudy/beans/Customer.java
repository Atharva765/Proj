package com.exception.casestudy.beans;

public class Customer {
	private String name;
	private double bal;
	
	public Customer(String name, int bal){
		this.name = name;
		this.bal = bal;
	}
	
	//getters
	
	public double getBalance() {
		return bal;
		
	}
	
	public String getName() {
		return name;
	}
	
	//setters
	
	public void setBalance(double bal) {
		this.bal = bal; 
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String toString() {
		return "[Name : " + name + "Balance : " + bal + "]";
		
	}
}
