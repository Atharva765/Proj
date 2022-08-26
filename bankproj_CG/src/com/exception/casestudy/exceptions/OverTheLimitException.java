package com.exception.casestudy.exceptions;

import com.exception.casestudy.main.Ops;

public class OverTheLimitException extends Exception{
	
	private double amt;
	private double bal;
	
	public OverTheLimitException(double amt, double bal) {
		
		this.amt = amt;
		this.bal = bal;
	
	}
	
	public String getmessage() {
		
		String msg = "Withdrawal could not be processed\n"
				+ "Current Balance : INR." + bal + "\n"
				+ "Requested Amount : INR." + amt + "\n"
				+ "Amount exceeding the limit : INR."+ (amt-Ops.limit);
				
				
		return msg;
	}

}
