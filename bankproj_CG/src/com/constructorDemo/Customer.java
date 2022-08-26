package com.constructorDemo;

public class Customer {
	
	private int balance;  //5000 -> 8000 -> 6000

	public Customer() {
		
	}
	
	Customer(int balance){
		this.balance = balance;
	}

	//getters
	public int getBal() {
		return balance;
	}
		
	//setters
	
	public void setBal(int amount) {   //8000
		balance = amount;
		
	}

	public String toString(){
		return "[Balance : " + balance + " ]";
		

	}
}
