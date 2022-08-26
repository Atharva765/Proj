package com.junitdemo.main;

import java.util.ArrayList;
import java.util.List;

public class MyService {
	
	public List<Product> list = new ArrayList<>();
	
	public int sum(int i, int j) {
		// TODO Auto-generated method stub
		return i+j;
	}
	
	public String computeGrade(int marks) {
		if(marks>100 || marks<0) {
			return "Invalid Marks";
		}
		return marks>70? "A":marks>60?"B":"C";
	}
	
	public String addProduct(Product p) {
		if(list.contains(p)) {
			return "Product already present";
		}
		
		list.add(p);
		return "Product added";
			
		
	}
	
	public String removeProduct(Product p) {
		if(list.remove(p)) {
			return "Removed";
		}
		else
			return "product does not exist";
	}
	
	public int listSize() {
		return list.size();
	}
}
