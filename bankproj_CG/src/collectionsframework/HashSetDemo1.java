package collectionsframework;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo1 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(4);
		set.add(3);
		set.add(1);
		set.add(1);  //ignores this.
		set.add(null); //takes null
		System.out.println(set);
		
		Set<Employee> myset = new HashSet<>();
		Employee e1 = new Employee(1, "Harry Potter", 75000, "Magic");
		Employee e2 = new Employee(3, "Ronald Weasly", 65000, "Study");
		Employee e3 = new Employee(3, "Harmione Greanger", 125000, "Magic");
		Employee e4 = new Employee(4, "Draco Malfoy", 110000, "Study");
		Employee e5 = new Employee(1, "Harmione Greanger", 125000, "Magic");
		Employee e6 = new Employee(2, "Harmione Greanger", 125000, "Magic");
		
		myset.add(e1);myset.add(e2);myset.add(e3);myset.add(e4);
		
		
		for(Employee e: myset) {
			System.out.println(e);
		}
			
	}
}
