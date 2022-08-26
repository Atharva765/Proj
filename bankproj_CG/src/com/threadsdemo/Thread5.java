package com.threadsdemo;

class E extends Thread{
	int count =0;
	
	void compute () {
		synchronized ("") {
			for(long i=0;i<10000000;i++) {
				count++;
			}
		}
	}
	@Override
	public void run() {
		compute();
	}
}


public class Thread5 {
	public static void main(String[] args) throws InterruptedException {
		
		E e = new E();
		Thread t1 = new Thread(e,"T1");
		Thread t2 = new Thread(e,"T2");
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println("Count = "+ e.count);
	}
}
