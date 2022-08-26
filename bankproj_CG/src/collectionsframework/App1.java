package collectionsframework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class App1 {
	public static void main(String[] args) {
		Employee e1 = new Employee(1, "Harry Potter", 75000, "Magic");
		Employee e2 = new Employee(2, "Ronald Weasly", 65000, "Study");
		Employee e3 = new Employee(3, "Harmione Greanger", 125000, "Magic");
		Employee e4 = new Employee(4, "Draco Malfoy", 110000, "Study");
		
		List<Employee> list = new ArrayList<>();
		list.add(e1);list.add(e2);list.add(e3);list.add(e4);
		
		
		System.out.println("\n=======Collection Sorting=======");
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("\n--------DATASET----------");
			for(Employee e : list) {
				System.out.println(e);
			}
			
		System.out.println("Press 1 for Ascending order");
		System.out.println("Press 2 for Descending order");
		System.out.println("Press 0 to Exit");
		int input = sc.nextInt();
		if(input == 0) {
			System.out.println("Exiting...Bye");
			break;
		}
		switch(input) {
		case 1 :
			Collections.sort(list, new A());
			for(Employee e : list) {
				System.out.println(e);
			}
			break;
		case 2: 
			Collections.sort(list, new B());
			for(Employee e : list) {
				System.out.println(e);
			}
			
			System.out.println("--------------------------------------------------------------");
			break;
		default:
			System.out.println("\n Invalid Input \n");
		}
	 }
		
  }
	
}

class A implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		
		if(e1.getSalary() > e2.getSalary()) {
			return 1;
		}
		else if(e1.getSalary() == e2.getSalary()) {
			return 0;
		}

		return -1;
		
		
		/*
		 *  +ve : SWAP
		 *  0 : do nothing
		 *  -ve : do nothing
		 */
	}
	
}

class B implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		
		if(e1.getSalary() > e2.getSalary()) { //75000 > 65000
			return -1;
		}
		
		else if(e1.getSalary() < e2.getSalary()) {  //75000<65000
			return 1;
		}
		return 0;
	}
	
}




