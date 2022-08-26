package com.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMap1 {
	public static void main(String[] args) {
		
		ConcurrentHashMap<Integer, String>	map = new ConcurrentHashMap<>();
		
		map.put(4, "Harry");
		map.put(2,"Ron");
		map.put(5, "draco");
		/*
		 *  input sequence doesn't matter it will always givr output sorted on basis of key.
		 */
		System.out.println(map);    //{2=Ron, 4=Harry, 5=draco}
		
		
		
		map.putIfAbsent(2, "Hermoine");
		
		map.putIfAbsent(3, "Ginny");
		/*
		 * map.putIfAbsent will check if key is already present and then only it will add it to map.
		 */
		System.out.println(map);   // {2=Ron, 3=Ginny, 4=Harry, 5=draco}
		
		
		
		
		map.replace(5, "draco", "Snape");  //map.replace(key, oldValue, newValue)
		
		System.out.println(map);  //{2=Ron, 3=Ginny, 4=Harry, 5=Snape}
		
		
		map.put(2, "RONALD"); // put will forcefully replace the existing value with new value.
		System.out.println(map);  //{2=RONALD, 3=Ginny, 4=Harry, 5=Snape}
	
		
		map.remove(3); // will remove the key with value 3
		
		
		map.clear();  // removeAll is not availabe int concurrentHashMap 
		//remove all the values from the map
		System.out.println(map);  //{}
		
	}
}
