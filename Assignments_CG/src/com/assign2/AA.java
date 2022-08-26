package com.assign2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;





public class AA {
		
	public ArrayList<Employee> sortByName(ArrayList<Employee> list){
		
		Collections.sort(list, new D());
		return list;
	}
	
	
	public ArrayList<Employee> sortBySalary(ArrayList<Employee> list){
		
		Collections.sort(list,  new B()); 
		return list;
	
	} 
	
	//[1 2 3 4 5 6 75 ]
	
	public Optional<Employee> findEmployeeMax(ArrayList<Employee> list) {
		
		int a = list.size() - 1;
		
		Collections.sort(list, new C());
		
		return Optional.of(list.get(a)) ;  // to access any element of list we use get method - >val required = list.get(index)
	}
	
	
	

	public double findAvgSalaries(ArrayList<Employee> list) {
		
		int count = 0;
		double sal = 0;
		
		for(Employee e : list ) {
			
			sal = sal + e.getSalary(); //
			
			count++;  //5
		}
		
		double avgsal = sal/count;   //150000/5
		
			
		return avgsal;
	}
	
	//list letWithChar(list, ch)
	
	public ArrayList<String> listWithChar(ArrayList<Employee> list, char ch) {
		
		ArrayList<String> lst = new ArrayList<>();
		
		
		
		for(Employee e : list) {
			if(e.getName().toLowerCase().startsWith("" + ch)) {
				
				lst.add(e.getName());
			}
		}
		
		return lst;
	}

}
class B implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		 
		if(e1.getSalary() > e2.getSalary()) { 
			return 1;
		}
		
		else if(e1.getSalary() == e2.getSalary()) {
			return 0;
		}
		 
		return -1;	
	}
}




class C implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		
		return (int)(e1.getSalary() - e2.getSalary());  //65 - 55 -> 55 65 
	}	
}
  //e1 & e2

class D implements Comparator<Employee>{
	
	@Override
	public int compare(Employee e1, Employee e2 ) {
		return (int)(e1.getName().compareTo(e2.getName()));
	}
}








