package com.threadsdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadModelDemo {
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		executorService.submit(new Player1());
		executorService.submit(new Player2());
		executorService.submit(new Player3());
		
		executorService.shutdown();
	}
}


class Player1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
		System.out.println("Player 1 has Started...");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Player 1 ends..");
	}
	
}

class Player2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
		System.out.println("Player 2 has Started...");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Player 2 ends..");
	}
	
}
class Player3 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
		System.out.println("Player 3 has Started...");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Player 3 ends..");
	}
	
}