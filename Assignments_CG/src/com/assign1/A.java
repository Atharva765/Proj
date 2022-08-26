package com.assign1;


import java.util.HashMap;
import java.util.List;



public class A {
	public HashMap<String, Long> getCount(List<Candidate> list){
		
		long MCount = 0;
		long FCount = 0;
		
		HashMap<String, Long> hm = new HashMap<>();
		//id name age gender dept 
		for(Candidate c : list) {
			if( c.getGender().toLowerCase().equalsIgnoreCase("male")) { 
				MCount++;
			}
			else if(c.getGender().toLowerCase().equalsIgnoreCase("female")) {
				FCount++;
			}
		}
		
		hm.put("Male", MCount);
		hm.put("Female", FCount);
		
		return hm;
	}
	
	
	public HashMap<String, Long> getAvgAge(List<Candidate> list){
		
		
		int MAge = 0;
		int FAge = 0;
		int MCount = 0;
		int FCount = 0;		
		
		
		for(Candidate c :list) {
			if(c.getGender().toLowerCase().equals("male")) {
				MAge += c.getAge();
				MCount++;
			}
			else if(c.getGender().toLowerCase().equalsIgnoreCase("female")) {
				FAge += c.getAge();
				FCount++;
			}
		}
		long avgM = MAge/MCount;
		long avgF = FAge/FCount;
		
		
		HashMap<String, Long> map = new HashMap<>();
		
		map.put("Male", avgM);
		map.put("Female", avgF);
		
		return map;
	}
	
	public HashMap<String, Long> getDept(List<Candidate> list){
		
		long PdeptC = 0;
		long HRdeptC = 0;
		
		HashMap<String, Long> hm1 = new HashMap<>();
		
		for(Candidate c : list) {
			if( c.getDepartment().toLowerCase().equalsIgnoreCase("Product Development")) {
				PdeptC++;
			}
			else if(c.getDepartment().toLowerCase().equalsIgnoreCase("HR department")) {
				HRdeptC++;
			}
		}
		
		hm1.put("Product Development", PdeptC);
		hm1.put("HR department", HRdeptC);
		
		return hm1;
	}
	
	
	public Candidate getYoungestCandidate(List<Candidate> list) {
		
		int young = Integer.MAX_VALUE;
		
		Candidate result = new Candidate();
		
		
		
		for(Candidate c : list) {
			
			if(young>c.getAge()) {
				young = c.getAge();
				result = c;
			}

		}

		return result;
	}
	
}










