package com.threadsdemo;

class A extends Thread{
	void display() {
		System.out.println(Thread.currentThread().getName());
	}
	
	@Override
	public void run() {
		display();
	}
	
}



public class Threads1 {
	public static void main(String[] args) {
		A a = new A();
		a.setName("MyThread");
		a.start();
		
		A a1 = new A();
		a1.setName("MyNewThread");
		a1.start();
	}
}

/*
 * When a program is executed JVM starts a thread with name "main".
 * 
 * Thread 
 * extends
 * A
 * 
 * A is a Thread
 * 
 * Thread class has notable methods : Start(), run().
 * */
