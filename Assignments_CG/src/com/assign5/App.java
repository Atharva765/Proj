package com.assign5;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		
		
		String temp = "Oppo+23400+4*Samsung+27500+7";
		
		String[] s = temp.split("\\*");
		
		List<Order> list = new ArrayList<>();
		
		for(String a : s) {
			String[] s1 =  a.split("\\+");
			Order o = new Order();
			o.setName(s1[0]);
			o.setPrice(Integer.parseInt(s1[1]));
			o.setQuan(Integer.parseInt(s1[2]));
			list.add(o);
		}
		
		Product p = new Product();
		p.displaylist(list);
	}
}

class Product {
	
	public void displaylist(List<Order> list) {
		
		for(Order e : list) {
			System.out.println(e.getName());
			System.out.println(e.getPrice());
			System.out.println(e.getQuan());
		}
	}
	
}

class Order {
	
	String name;
	int price;
	int quan;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuan() {
		return quan;
	}
	public void setQuan(int quan) {
		this.quan = quan;
	}
	
	@Override
	public String toString() {
		return "Order [name=" + name + ", price=" + price + ", quan=" + quan + "]";
	}
	
	
	
}
