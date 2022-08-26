package comp.staticdemo;
import static comp.staticdemo.C.display;
import static comp.staticdemo.C.x;


public class Test {
	public static void main(String[] args) {
		
		//Way 1: using object
		C c = new C();
		System.out.println(c.x);
		c.display();
		
		//Way 2 : using class name
		System.out.println(C.x);
		C.display();
		
		//way 3: directly
		System.out.println(x);
		display();
	}
}

