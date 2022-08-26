package inheritance;

public class Test {
	public static void main(String[] args) {
		AA aa = new AA();
		BB bb = new BB();
		
		AA a1 = new BB();
		
		System.out.println(aa.x); 
		aa.m1(); // M1 in A
		
		
		System.out.println(a1.x);
		a1.m1();
	}
}

class AA{
	int x=5;
	
	void m1() {
		System.out.println("M1 in A");
	}
}

class BB extends AA{
	int x=10;
	void m1() {
		System.out.println("M1 in B");
	}
	
}