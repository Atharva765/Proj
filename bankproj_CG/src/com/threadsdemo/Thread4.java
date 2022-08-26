package com.threadsdemo;

class D extends Thread{
	void display() {
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {}
		
		System.out.println(Thread.currentThread().getName());
	}
	@Override
	public void run() {
		display();
	}
}

public class Thread4 {
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new D(),"T1");
		Thread t2 = new Thread(new D(), "T2");
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Thanx");
	}
}
