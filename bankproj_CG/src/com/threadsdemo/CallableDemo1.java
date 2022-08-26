package com.threadsdemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo1 {
	public static void main(String[] args) throws Exception, ExecutionException {
		/*
		 * 2 Nos. Divide and return the result
		 */
		
		//Executor Service - One - Start Thread- run() - task()
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		One one = new One();
		
		Future<Integer> res = executorService.submit(one); 
		/*
		 * To catch the returned value we use Future
		 * <Integer> - is the return type of the value . and must always be class i.e Integer 
		 * and not primitive-datatype "int".
		 */
		
		
		System.out.println(res.get());
		
		executorService.shutdown();
	}
}

class One implements Callable<Integer> {
	/*
	 * We use "Callable" as Runnable cannot return a value as it is of type void .
	 * Also it cannot throw exceptions
	 * i.e original run method is of type void and Doesn't contain exceptions
	 * so we cannot override the method according to rules.
	 */
	
	private Integer task(int i, int j) throws Exception{

		return i/j;
	}
	
	
	@Override
	public Integer call() throws Exception {
		
		return task(20,10);
	}

	
}

	