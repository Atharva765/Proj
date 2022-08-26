package collectionsframework;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Arraylist1 {
	public static void main(String[] args) {
		/*
		 * ArrayList : Alternative to arrays
		 */
		
		//Type 1: PURE
		ArrayList list1 = new ArrayList();
		
		//list list1 = new List(); //CF - List is an interface, cannot instantiate.
		
		//Type 2: Polymorphic
		List list = new ArrayList();  //preffered - Raw
		
		/*
		 * Note: Always make list restricted to a particular type.
		 */
		
		list.add(1);
		list.add(1.0F);
		list.add(1.0);
		list.add("abc");
		
		
		
		System.out.println(list);
		
		
		List<Integer> lst = new ArrayList<>();  //genereic implementation
		lst.add(1);
		lst.add(2);
		
		//lst.add(""); -- CF-> cannot add anything other than int in the list as list is of type Interger.
		
		System.out.println(lst);
		
	}
}
