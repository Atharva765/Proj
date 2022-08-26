package com.exception.casestudy.service;

import com.exception.casestudy.beans.Customer;
import com.exception.casestudy.main.Ops;

public abstract class Deposit implements Ops {

	@Override
	public void deposit(Customer c, double amt) {
		c.setBalance(c.getBalance() + amt);
		
	}

	
}
