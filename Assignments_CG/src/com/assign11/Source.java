package com.assign11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;



class Mobile{
	
	HashMap<String, ArrayList<String>> mobiles = new HashMap<>();
	
	
	public String addMobile(String company, String model) {
		
		if(  !(mobiles.containsKey(company) ) ) {
			ArrayList<String> list = new ArrayList<>();
			
			list.add(model);
			mobiles.put(company, list);
		}
		else {
			ArrayList<String> list = mobiles.get(company); //map.get(company) will recieve the list of models with company
			list.add(model);
			
		}
		
		return "Model succesfully added";
	}
	
	public ArrayList<String> getModels(String company){
		
		
		ArrayList<String> list = mobiles.get(company);

		return list;
	}
	
	public String  buyMobile(String company, String model) {
		
		if(mobiles.containsKey(company)) {
		
			ArrayList<String> list = mobiles.get(company);
			if(list.contains(model)) {
				list.remove(model);
			}
			else {
				return "model not available";
			}
			
		}
		else {
			return "company not available";
		}
		
		
		return "Mobile sold succesfully";
	}
	
}


public class Source {
	public static void main(String[] args) {
		
		/*Mobile m = new Mobile();
		
		HashMap<String, ArrayList<String>> map1 = new HashMap<>();
		ArrayList<String> list = new ArrayList<>(Arrays.asList("OppoA10"));
		
		m.mobiles.put("Oppo", list);
		System.out.println(m.buyMobile("Oppo", "OpoA10"));
		System.out.println(m.mobiles);
		
		m.addMobile("Vivo", "A20");
		m.addMobile("Vivo", "A21");
		System.out.println(m.mobiles);
		System.out.println(m.getModels("Vivo"));*/
		
		Mobile m = new Mobile();
		System.out.println(m.addMobile("Oppo", "A20"));
		System.out.println(m.addMobile("Oppo", "A21"));
		System.out.println(m.addMobile("Oppo", "A20"));
		
		
		System.out.println(m.getModels("Oppo"));
		System.out.println(m.addMobile("Vivo", "V"));
		System.out.println(m.addMobile("Apple", "13"));
		System.out.println(m.mobiles);
		System.out.println(m.buyMobile("Oppo", "A20"));
		System.out.println(m.mobiles);
		System.out.println(m.buyMobile("Apple", "m"));
	}
}








