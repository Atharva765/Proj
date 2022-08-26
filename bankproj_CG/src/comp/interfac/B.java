package comp.interfac;

public class B extends A {

	@Override
	public String computeGrade(int percent) {
		
		String grade = percent>75? "A+ ": (percent<75 && percent>60)? "A" : (percent<60 && percent>40)? "B": "C";
		return grade;
		
	}

}

//String grade = marks>60? "A" : college.equals("VJTI")?"A+":"B";