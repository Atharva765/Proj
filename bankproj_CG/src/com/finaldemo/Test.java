package com.finaldemo;

public class Test {
	public static void main(String[] args) {
		A a = new B();
		a.m1();
		a.m2();
		
	}
}

class A {
	void m1() {
		System.out.println("M1 in A");
	}
	final void m2() {
		System.out.println("M2 in A");
	}
		
}

class B extends A{
	void m1() {
		System.out.println("m1 in B");
	}
/*	
	void m2() {
		System.out.println("m2 in B");
	} */
	
}