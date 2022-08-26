package com.casestudy3;

public class App {
	public static void main(String[] args) {
		
		Student s1 = new Student("Harry Potter", 250);
		Student s2 = new Student("Ronald Weasly", 200);
		A a = new A();
		
		try {
			a.computeResult(s1);
			a.computeResult(s2);
			}
		catch(IllegalMarksException e) {
			System.out.println("Marks cannot be more than 300.");
		}
		catch(InvalidMarksException e) {
			System.out.println("Marks cannot be less than 0.");
		}
	}
}
