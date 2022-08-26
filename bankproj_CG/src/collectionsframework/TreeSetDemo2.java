package collectionsframework;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo2 {
	public static void main(String[] args) {
		Employee e1 = new Employee(1, "Harry Potter", 75000, "Magic");
		Employee e2 = new Employee(2, "Ronald Weasly", 65000, "Study");
		Employee e3 = new Employee(3, "Harmione Greanger", 125000, "Magic");
		Employee e4 = new Employee(4, "Draco Malfoy", 110000, "Study");
		
		Set<Employee> set = new TreeSet<>();
		set.add(e1);set.add(e2);set.add(e3);set.add(e4);
		
		for(Employee e : set) {
			System.out.println(e);
		}
	}
}
