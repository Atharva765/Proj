package com.exception.casestudy.service;

import com.exception.casestudy.beans.Customer;
import com.exception.casestudy.exceptions.InsufficientFundsException;
import com.exception.casestudy.exceptions.OverTheLimitException;
import com.exception.casestudy.main.Ops;

public class Withdraw extends Deposit {

	@Override
	public void withdraw(Customer c, double amt) throws OverTheLimitException , InsufficientFundsException{
		// TODO Auto-generated method stub
		if(amt > Ops.limit) {
			throw new OverTheLimitException(amt, c.getBalance());
		}
		
		if(amt > c.getBalance()) {
			throw new InsufficientFundsException(amt, c.getBalance());
		}
		
		c.setBalance(c.getBalance() - amt);
		
	}

}
