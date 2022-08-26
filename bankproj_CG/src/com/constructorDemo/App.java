package com.constructorDemo;

public class App {
	public static void main(String[] args) {
		Person p = new Person("Harry Potter ", 18);
		
		System.out.println(p.name);
		System.out.println(p.age);
	}
}

class Person extends Object{
	String name;
	int age;
	
	public Person(){
		super();
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

