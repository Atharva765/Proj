package com.concurrenthashmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMap2 {
	public static void main(String[] args) {
		
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>(); 
		
		map.put(2, "Harry");
		map.put(3,"Ron");
		map.put(1, "draco");
		map.putIfAbsent(4, "Hermoine");
		
		System.out.println(map);
		
		for(Map.Entry<Integer, String> m : map.entrySet()) {
			
			System.out.println(m.getKey() + " ----- " + m.getValue());
			
		}
		
		System.out.println("*******************************************************");
		
		map.forEach( (k,v)-> System.out.println(k + "------" + v) );
		
		/*
		 * map.forEach( (k,v)-> System.out.println(k + "------" + v)/*can' use ; here);
		 */
		
		System.out.println("*******************************************************");
		
		map.forEach( (k,v)->
			{
				System.out.println(k + "-------" + v );
				// here we can add more statements if needed.
			}
			);
		
		System.out.println("*********************************************************");
		
		
		map.compute(5, (k,v)-> k>4? "Dumbledor": null );
		// for key 5 , in k,v - if k>4 then give "Dumbledor" the value else give null 
		
		map.compute(5, (k,v) -> k> map.size()? "Snape" : v );
		// for key 5 , in k,v - if k> size of map then give "Dumbledor" the value else give null
		
		map.compute(5, (k,v) -> k> map.size()? "Ginny": v);
		//ginny will not be added as key is not greater then size of map
		

		System.out.println(map);
		//{1=draco, 2=Harry, 3=Ron, 4=Hermoine, 5=Dumbledor}

	}
}
