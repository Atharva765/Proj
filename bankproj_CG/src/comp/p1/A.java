package comp.p1;

public class A {
	
	int i,j;
	public void display() {
		System.out.println("A");
		
	}

	public void sum(int i, int j) {
		// TODO Auto-generated method stub
		int temp = i+j;
		System.out.println(temp);
		
	}

	public int compute(int i) {
		// TODO Auto-generated method stub
		
		return i*10;
	}

	public void m1(int i, int j) {
		// TODO Auto-generated method stub
		this.i = i;
		this.j = j;
		
	}

	public int m2() {
		// TODO Auto-generated method stub
		return i+j;
		
	}

	public int computeResult(int k, int l) {
		// TODO Auto-generated method stub
		int tot = (k*100)/l ; 
		return tot;
	}
	
	
}
