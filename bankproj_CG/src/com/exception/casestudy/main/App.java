package com.exception.casestudy.main;

import com.exception.casestudy.beans.Customer;
import com.exception.casestudy.exceptions.InsufficientFundsException;
import com.exception.casestudy.exceptions.OverTheLimitException;
import com.exception.casestudy.service.Withdraw;

public class App {
	public static void main(String[] args) {
		Customer c1= new Customer("Harry Potter", 40000);
		Customer c2 = new Customer("Ronald Weasly", 30000);
		
		Withdraw w = new Withdraw();
		
		w.deposit(c1, 20000); //60000
		w.deposit(c2, 10000);//40000
		
		
		
		try {
			w.withdraw(c1, 70000); //0
			w.withdraw(c2, 50000); //-10000
		}
		catch(InsufficientFundsException a) {
			
			System.out.println("Exception");
			System.out.println(a.getmessage1());
		}
		catch(OverTheLimitException a) {
			
			System.out.println("Exception 1");
			System.out.println(a.getmessage());
		}
		catch(RuntimeException a) {
			
			a.getMessage();
		} 
		
		
//		
//		finally {
//			w =null;
//		}
		
		System.out.println(c1);
		System.out.println(c2);

	}
}




/*
 * catch(OverTheLimitException a) {
			System.out.println("Exception");
		}
		catch(InsufficientFundsException a) {
			System.out.println("Exception");
		}
		catch(RuntimeException a) {
			System.out.println("Exception");
		}
 */
