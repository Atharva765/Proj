package collectionsframework;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Treemap1 {
	public static void main(String[] args) {
	
		NavigableMap<Integer, String> map = new TreeMap<>();
		
		map.put(1352, "ABC");
		map.put(876, "PQR");
		map.put(1572, "LMN");
		map.put(4562, "XYZ");
		map.put(2601, "DEF");
		map.put(9,	 "IJK");
		map.put(5852, "TUV");
		
		/*
		 * Sorts the map by default as per the key in ascending order.
		 */
		
		System.out.println(map);
		
		System.out.println("Descending Map Keys");
		System.out.println(map.descendingKeySet());
		
		System.out.println("Descending Map");
		System.out.println(map.descendingMap());
		
		System.out.println("First Entry in Map");
		System.out.println(map.firstEntry());
		
		System.out.println("Last entry in the map");
		System.out.println(map.lastEntry());
		
		System.out.println("Poll First entry in the Map");
		System.out.println(map.pollFirstEntry());
		
		System.out.println(map);
	}
	
	
}
