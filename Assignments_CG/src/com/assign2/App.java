package com.assign2;

import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		
		ArrayList<Employee> e = new ArrayList<>();
		
		Employee e1 = new Employee(1,"Harry", 75000.0);
		Employee e2 = new Employee(2,"Ron", 85000.0);
		Employee e3 = new Employee(3,"Hermoine", 95000.0);
		Employee e4 = new Employee(4,"Ginny", 65000.0);
		Employee e5 = new Employee(5,"Draco", 55000.0);
		
		
		e.add(e1);
		e.add(e2);
		e.add(e3);
		e.add(e4);
		e.add(e5);
		
		
		AA aa = new AA();
		
		
		System.out.println(aa.sortByName(e));
		
		System.out.println(aa.sortBySalary(e));
		
		
		System.out.println(aa.findEmployeeMax(e));
		
		System.out.println(aa.findAvgSalaries(e));
		
		
		System.out.println(aa.listWithChar(e, 'h'));
	}
}
