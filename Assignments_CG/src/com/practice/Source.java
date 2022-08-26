package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



class Travel{
	
	HashMap<String , Integer> holidayPkg = new HashMap<>();
	// String  = name of place
	// integer = cost to travel
	public int cheapestPackage(int numberOfPlaces) {
		
		List<Integer> list = new ArrayList<>();
		
		for(Map.Entry<String, Integer> i : holidayPkg.entrySet() ) {
			int val = i.getValue();
			list.add(val);
		}
		
		Collections.sort(list);
		int sum=0;
		for(int a=0; a<numberOfPlaces;a++) {
			
			int f =list.get(a);
		
			sum = sum+f;
		}
		
		return sum;
	}
	
	/*
	 * for(Map.Entry<String,List<Candidate>> entry: list1.entrySet()) {
			String key = entry.getKey();
			long val = entry.getValue().size();
			map1.put(key, val);
		}
	 */
	
	public int maximumPlace(int budget) {
		
		List<Integer> list = new ArrayList<>();
		
		for(Map.Entry<String, Integer> i : holidayPkg.entrySet() ) {
			int val = i.getValue();
			list.add(val);
		}
		
		Collections.sort(list);
		
		int count =0;
		
		for(Integer a : list) {
			if( a<budget) {
				count++;
			}
			else {
				count=2;
			}
		}
		
		return count;
	}
	
	
}


public class Source {
	public static void main(String[] args) {
		Travel t = new Travel();
		t.holidayPkg.put("Delhi", 5000);
		t.holidayPkg.put("Jaipur", 4000);
		t.holidayPkg.put("Agra", 2500);
		t.holidayPkg.put("Goa", 7000);
		
		System.out.println(t.cheapestPackage(3));
		System.out.println(t.maximumPlace(3000));
	}
}









