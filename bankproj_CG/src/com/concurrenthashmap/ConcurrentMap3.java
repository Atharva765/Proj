package com.concurrenthashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ConcurrentMap3 {
	public static void main(String[] args) {
		
		Student s1 = new Student(1,"harry", "mumbai");
		Student s2 = new Student(2,"rony", "mumbai");
		Student s3 = new Student(3,"draco", "pune");
		Student s4 = new Student(4,"abc", "mumbai");
		Student s5 = new Student(5,"xyz", "pune");
		Student s6 = new Student(6,"pqr", "mumbai");
		Student s7 = new Student(7,"tuv", "pune");
	
		List<Student> list = new ArrayList<>(Arrays.asList(s1,s2,s3,s4,s5,s6,s7));
		
		System.out.println(list);
		
		ConcurrentHashMap<String, List<Student>> map = new ConcurrentHashMap<>();
		ConcurrentHashMap<String, Long> m = new ConcurrentHashMap<>();
		
		
		List<String> listcity = list.stream().map(a->a.getCity()).distinct().collect(Collectors.toList());
		System.out.println(list);
		
		
		
		listcity.forEach(c->{
			
			map.compute(c, (k,v)-> list.stream().filter(p->p.getCity().equals(c)).collect(Collectors.toList())	);
		
		});
		
		System.out.println(map);
		
		listcity.forEach(c->{
			m.compute(c, (k,v) -> list.stream().filter(p->p.getCity().equals(c)).count() );
			});
		
	}
}

class Student{
	
	int id;
	String name;
	String city;
	
	public Student(int id, String name, String city){
		this.id = id;
		this.name = name;
		this.city = city;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
	
}