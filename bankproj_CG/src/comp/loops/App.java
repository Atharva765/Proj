package comp.loops;
import java.util.Scanner;


public class App {
	public static void main(String[] args) {
		
		System.out.println("Enter Marks: ");
		Scanner sc = new Scanner(System.in);
		int marks = sc.nextInt();
		
		System.out.println("Enter college : ");
		String college = sc.next();
		
		if (marks < 60) {
			System.out.println("Oops u didn't PASS ");
		}
		else {
			System.out.println("Great u PASSED");
			
		}
		
		System.out.println( (marks<60)? "Oops u didn't pass ":"Great u paased");
		
		
		String grade = marks>60? "A" : college.equals("VJTI")?"A+":"B";
		System.out.println("Your grade is " + grade);
	}
}
