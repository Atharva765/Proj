package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Product{
	private int id;
	private String name;
	private float price;
	
	public Product(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}

class ProductImplementation{
	
	public double sumOfPrices(List<Product> productsList) {
		
		double s = productsList.stream().map(p->p.getPrice()).reduce(0F, Float::sum);
		return s;
	}
	
	public float maxPrice(List<Product> productsList) {
		
		float c = productsList.stream().map(p->p.getPrice()).reduce(0F, Float :: max);
		return c;
	}
	
	public List<String> getProductName(List<Product> productsList){
		
		List<String> list = new ArrayList<>();
		
		list = productsList.stream().filter(p->p.getPrice()>25000).map(p->p.getName())
				.collect(Collectors.toList());
		
		return list;
	}
	
}



public class Source3 {
	public static void main(String[] args) {
		
		List<Product> productsList = new ArrayList<>();
		productsList.add(new Product(100,"P1",10000f));
		productsList.add(new Product(200,"P2",20000f));
		productsList.add(new Product(300,"P3",30000f));
		productsList.add(new Product(400,"P4",40000f));
		productsList.add(new Product(500,"P5",50000f));
		
		ProductImplementation p = new ProductImplementation();
		System.out.println(p.sumOfPrices(productsList));
		System.out.println(p.maxPrice(productsList));
		System.out.println(p.getProductName(productsList));
		
	}
}
