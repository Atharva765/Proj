package com.assign5;


class CompanyJobRepository{
	
	
	static String getJobPrediction(int age, String highQ) throws NotEligibleException {
		
		if(age<19) {
			throw new NotEligibleException("Your are underage for any job");
		}
		else if(age>=21 && highQ.equalsIgnoreCase("BE")) {
			//System.out.println("JD");
			return "We have openings for junior developer";
		}
		else if(age >= 26 && (highQ.equalsIgnoreCase("MS") || highQ.equalsIgnoreCase("PhD") )){
			//System.out.println("SD");
			return "We have openings for senior developer";
		}
		else if(age >=19 && !(highQ.equalsIgnoreCase("BE") || highQ.equalsIgnoreCase("MS") || highQ.equalsIgnoreCase("PhD"))){
			throw new NotEligibleException("We do not have any job that matches your qualification");
		}
		else {
			return "Sorry we have no openings for now";
		}
		
	}
	
}

public class Source {

	public static void main(String[] args) {
		
		//CompanyJobRepository cr = new CompanyJobRepository();
		Source s = new Source();
		try {
			System.out.println(s.searchForJob(22, "MS"));
			
		} catch (NotEligibleException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String searchForJob(int age, String highQ) throws NotEligibleException {
		
		if(age>=200 || age<=0) {
			throw new NotEligibleException("The age entered is not typical for a human being");
		}
		else {
			return CompanyJobRepository.getJobPrediction(age, highQ);
			
		}
	
	}
	
}

class NotEligibleException extends Exception{
	
	String message;
	
	NotEligibleException(String message){
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
