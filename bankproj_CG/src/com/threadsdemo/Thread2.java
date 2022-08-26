package com.threadsdemo;

class B extends Thread{
	void display() {
		System.out.println(Thread.currentThread().getName());
	}
	@Override
	public void run() {
		display();
	}
}


public class Thread2 {
	public static void main(String[] args) {
		B b = new B();
		Thread t1 = new Thread(b,"MyThread");
		t1.start();
	}
}
