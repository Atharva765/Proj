package comp.loops;



public class Varargs {
	public static void main(String[] args) {
		A a = new A();
		a.m1(1,2,4);
		a.m1();
		a.m1(1, 2,3);
		a.m1(1,2,3,4,5,6);
		a.m1(3);
		
	}
}


class A{
	public void m1(int... arr) {
		for(int temp : arr) {
			System.out.println(temp + " ");
		}
		System.out.println("\n*********\n");
	}
}