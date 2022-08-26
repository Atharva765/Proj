package com.exception.casestudy.main;

import com.exception.casestudy.beans.Customer;
import com.exception.casestudy.exceptions.OverTheLimitException;
import com.exception.casestudy.exceptions.InsufficientFundsException;

public interface Ops {
	int limit = 50000;
	void deposit(Customer c, double amt);
	void withdraw(Customer c, double amt) throws InsufficientFundsException , OverTheLimitException;
	
}
