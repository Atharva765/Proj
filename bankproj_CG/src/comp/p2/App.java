package comp.p2;
//import comp.p1.A;
//import comp.p1.C;
//import comp.p2.B;
import comp.p3.Customer;


public class App {
	public static void main(String[] args) {
		/*A a = new A();
		a.display();
		
		a.sum(12,5);
		
		int result = a.compute(5);
		System.out.println("Result is" + result);
		
		a.m1(12,4);
		int val = a.m2();
		System.out.println("Sum is " + val);
		
		
		int percent = a.computeResult(83,100);
		System.out.println("You secured " + percent);*/
		
		
		/*B b = new B();
		B b1 = new B();
		
		System.out.println(b.i);
		b.i = 10;
		System.out.println(b.i);
		System.out.println(b1.i);
		b1 = b;
		System.out.println(b1.i);*/
		
		
		Customer c1 = new Customer();
		c1.balance = 1000;
		c1.balance = c1.deposit(5000);
		System.out.println(c1.balance);
		
		Customer c2 = new Customer();
		c2.balance =  c2.deposit(3000);
		System.out.println(c2.balance);
		
		
		
	}
}



 