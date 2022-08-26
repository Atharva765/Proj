package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Employee{
	public static void main(String[] args) {
		Employee1 emp = new Employee1("doselect","hack",30);
		System.out.println(emp.setBonus());
		System.out.println(emp.generateId());
	}
}


class Employee1 {
	String name;
	String projectName;
	int workingHrs;
	int bonus;
	public Employee1(String name, String projectName, int workingHrs) {
		super();
		this.name = name;
		this.projectName = projectName;
		this.workingHrs = workingHrs;
		this.bonus = 0;
	}
	
	
		
	public String setBonus() {
		if((this.projectName == "web" ||
				this.projectName == "tech"||
				this.projectName == "hack"||
				this.projectName == "SD"||
				this.projectName == "PD") && this.workingHrs>=30 ) {
			this.bonus = this.workingHrs/10;
			return "Congrats";
		}
		else {
			return "Work hard";
		}
	}
	
	public String generateId() {
		String str="";
		if(this.name.length() > this.projectName.length()) {
			for(int i=0;i< this.projectName.length()-1;i++) {
				 String str1 = this.name.charAt(i) +""+ this.projectName.charAt(i);
				 str = str + str1 + this.bonus;
			}
		}
		else if(this.name.length() < this.projectName.length()) {
			for(int i=0;i< this.name.length()-1;i++) {
				String str1 = this.name.charAt(i) +""+ this.projectName.charAt(i);
				 str = str + str1 + this.bonus;
			}
		}
			
		
		return str;
	}
}












