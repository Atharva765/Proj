package com.assign1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {
	
	@Test
	public void getCountTest() {
		A a = new A();
		List<Candidate> list = new ArrayList<>();
		
		list.add(new Candidate(1, "Harry", 25, "male", "Product Development", new Date() , 75000));
		list.add(new Candidate(2, "Ron", 24, "Male", "Product Development", new Date() , 80000));
		list.add(new Candidate(3, "Hermoine", 28, "Female", "HR Department", new Date() , 65000));
		
		HashMap<String, Long> map = new HashMap<>();
		map.put("Male", 2L);
		map.put("Female", 1L);
		
		Assert.assertEquals(map, a.getCount(list));
		
	}
	
	@Test
	public void getAvgAgeTest() {
		
		A a = new A();
		
		List<Candidate> list = new ArrayList<>();
		
		list.add(new Candidate(1, "Harry", 25, "male", "Product Development", new Date() , 75000));
		list.add(new Candidate(2, "Ron", 24, "Male", "Product Development", new Date() , 80000));
		list.add(new Candidate(3, "Hermoine", 28, "Female", "HR Department", new Date() , 65000));
		list.add(new Candidate(4, "Ginny", 23, "Female", "Product Development", new Date() , 95000));
		
		HashMap<String, Long> map = new HashMap<>();
		map.put("Male", 24L);
		map.put("Female", 25L);
		
		Assert.assertEquals(map, a.getAvgAge(list));
	}
}
