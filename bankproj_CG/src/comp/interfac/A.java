package comp.interfac;

abstract public class A implements Ops{
	
	@Override 
	public  int computePercent(int marks, int total) {
		int percent = (marks*100)/total;
		
		return percent;
		
	}

}
