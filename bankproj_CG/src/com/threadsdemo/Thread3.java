package com.threadsdemo;

class C implements Runnable{
	
	
	
	public void run() {
		System.out.println("A");
		
	}
}


public class Thread3 {
	public static void main(String[] args) {
		C t1 = new C();
		
		System.out.println("B");
				
	}
}
