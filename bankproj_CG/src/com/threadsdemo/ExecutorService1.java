package com.threadsdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorService1 {
	public static void main(String[] args) {
		/*
		 * Iniatializing Executor as a Single Thread Executor
		 */
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		MyClass myc = new MyClass();
		/*
		 * Submit out class to executor
		 */
		
		executorService.submit(myc);
		/*
		 * Shutdown the executor to stop memory leakage
		 */
		executorService.shutdown();
		
	}
}

class MyClass implements Runnable{

	public void task() {
		System.out.println("My Task");
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		task();
	}
	
}