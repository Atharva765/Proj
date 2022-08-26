package com.assign1;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class App {
	public static void main(String[] args) {
		
		Date ld = new Date();
		
		ArrayList<Candidate> c = new ArrayList<>();
		
		Candidate c1 = new Candidate(1, "Harry", 25, "male", "Product Development", ld , 75000);
		Candidate c2 = new Candidate(2, "Ron", 24, "Male", "Product Development", ld, 80000);
		Candidate c3 = new Candidate(3, "Hermoine", 28, "Female", "HR Department", ld, 65000);
		Candidate c4 = new Candidate(4, "Ginny", 23, "Female", "Product Development", ld, 95000);
		Candidate c5 = new Candidate(5, "Draco", 26, "Male", "HR Department", ld, 85000);
		
		
		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(c4);
		c.add(c5);
		
		
		A a = new A();
		
		System.out.println(a.getCount(c));
		System.out.println(a.getAvgAge(c));
		
		System.out.println(a.getDept(c));
		
		Candidate a2 = a.getYoungestCandidate(c);
		
		System.out.println(a2);
		
	}
}
