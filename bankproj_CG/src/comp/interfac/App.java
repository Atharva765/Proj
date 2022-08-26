package comp.interfac;

public class App {
	public static void main(String[] args) {
		Student s= new Student();
		s.name = "Harry Potter";
		s.marks = 150;
		
		B b = new B();
		int percent = b.computePercent(s.marks, 300);
		System.out.println("Your percentage :" + percent);
		
		String grade = b.computeGrade(percent);
		System.out.println("Your grade is : " + grade);
	}
}
