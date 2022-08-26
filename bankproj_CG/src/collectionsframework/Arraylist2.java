package collectionsframework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Arraylist2 {
	public static void main(String[] args) {
		List<Integer> list =new ArrayList<>();
		list.add(3);
		list.add(5);
		list.add(1);
		list.add(2);
		
		System.out.println(list);
		
		System.out.println("====Iteration Using for loop=====");
		
		for( int i : list) {
			System.out.print(i+ " ");
		}
		
		System.out.println("\n=======Iteration using Iterator Interface======");
		Iterator<Integer> itr = list.iterator();  //itr = [3,5,1,2]
		
		while(itr.hasNext()) {
			System.out.print(itr.next()+ " ");  //3 5 1 2
			
		}
		
		System.out.println("\n=====Sorting the list");
		Collections.sort(list);
		
		for(int i : list) {
			System.out.print(i + " ");  //1 2 3 5
			
		}
		
		
		
		//NOTABLE METHODS
		/*
		 * If we go beyond the available index it will show IndexOutOfBoundException
		 */
		//[1,2,3,5]
		int ele = list.get(2);
		System.out.println(ele);//3
		
		//REMOVE METHOD
		list.remove(2);
		System.out.print("\n" + list); //1 2 5
		
		//SUBLIST
		
		List<Integer> list1 = list.subList(1, 3);
		System.out.println("\n" + list1); //[2, 5]
		
		//SEARCHING
		System.out.println();
		int e = 5;
		boolean status = list.contains(e);
		System.out.println(status? "PRESENT":"NOT PRESENT");
		
	}
}

















