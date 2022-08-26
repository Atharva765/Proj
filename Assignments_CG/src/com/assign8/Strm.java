package com.assign8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



public class Strm {
	public static void main(String[] args) {
		
		
		
	}
}

class Employee{
	private String name;
	private int salary;
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public Employee() {
		
	}
	
	public String getName() {
		return this.name;
	}
	public int getSalary() {
		return this.salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Candidate [name=");
		builder.append(name);
		builder.append(", salary=");
		builder.append(salary);
		builder.append("]");
		return builder.toString();
	}
	

	
	
	
	
}

class EmployeeInfo{
	
	enum SortMethod{
		BYNAME, BYSALARY;
	}
	
	
	public List<Employee> sort(List<Employee> emps, final SortMethod method){

        if(method.equals(SortMethod.BYNAME)){
            emps = emps.stream().sorted( new A()).collect(Collectors.toList());
        }
        else{
            //emps = emps.stream().sorted( new B()).collect(Collectors.toList());
            Collections.sort(emps, new B());
        
        }

        return emps;
    }
	
	/*
	 * public List<Employee> sort(List<Employee> emps, final SortMethod method){
		
		List<Employee> sortedList = new ArrayList<>();
		
		if(method.toString().equals("BYSALARY")) {
			 sortedList = emps.stream()
					.sorted(Comparator.comparingInt(Employee :: getSalary))
					.collect(Collectors.toList());
			
		}
		else if(method.toString().equals("BYNAME")) {
			
			sortedList = emps.stream()
						.sorted(Comparator
						.comparing(Employee :: getName))
						.collect(Collectors.toList());
			
		}
		
		return sortedList;
	}
	 */
	
	
	
	public boolean  isCharacterPresentInAllNames(Collection<Employee> entities, String character){
        
        return entities.stream().allMatch(e->e.getName().toLowerCase().contains(character.toLowerCase()));
         
    }
	
	
}

class A implements Comparator<Employee>{
    @Override
    public int compare(Employee e1, Employee e2){
        return (e1.getName().compareTo(e2.getName()) );
    }
}

class B implements Comparator<Employee>{
    @Override
    public int compare(Employee e1, Employee e2){

        if(e1.getSalary() < e2.getSalary()){
            return -1;
        }
        if(e1.getSalary() == e2.getSalary()){
            return -1;
        }
        return 1;
        
    }
}
