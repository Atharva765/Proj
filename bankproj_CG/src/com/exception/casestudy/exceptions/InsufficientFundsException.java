package com.exception.casestudy.exceptions;

public class InsufficientFundsException extends Exception {
	private double bal;
	private double amt;
	
	public InsufficientFundsException (double amt, double bal ) {
		this.bal = bal;
		this.amt = amt;
	}
	
	public String getmessage1() {
		
		
		String msg = "Withdrawal could not be processed\n"
					+ "Current Balance : INR." + bal + "\n"
					+ "Requested Amount : INR." + amt + "\n"
					+ "Additional amount needed : INR." + (amt-bal );
		return msg;
	}
}	
