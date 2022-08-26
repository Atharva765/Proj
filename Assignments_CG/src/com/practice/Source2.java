package com.practice;

class Speed {

	String speed;

	
}

class SpeedImplementation {

	public String setSpeed(Speed s, int spd) throws Exception {
		
		if ((spd < 30) || (spd > 90)) {
				
				throw new SpeedInvalidException("SpeedInvalidException");
			}
		else {
			s.speed = "Valid Speed";
		}

		return s.speed;
	}
}

class SpeedInvalidException extends Exception {

	

	public SpeedInvalidException(String s) {
		super(s);

	}

	
}

public class Source2 {
	public static void main(String[] args)  {
		
		Speed s = new Speed();
		SpeedImplementation si = new SpeedImplementation();
		
		try {
			System.out.println(si.setSpeed(s, 25));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
