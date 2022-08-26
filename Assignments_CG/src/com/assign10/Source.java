package com.assign10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;



class Mobile{
    // Write your code here..
	 HashMap<String, ArrayList<String>> map = new HashMap<>();

		
	public String addMobile(String company, String model){
			/*If company exists in the map , given at line 9 then i
			i will fetch the value for that company from the map which is a list and add the model
			 in that list.
			IF company doesnot exist then i will add company in the map. For adding values for this 
			company i will create array list , add model to it and add list to map.
			*/
		
		
		if(!map.containsKey(company)){
			ArrayList<String> list = new ArrayList<>();
			list.add(model);
			map.put(company, list);

		}
		else{
			ArrayList<String> list = map.get(company);
			list.add(model);

		}


		return "model successfully added";
	}

	public ArrayList<String>  getModels(String company){

		if(map.containsKey(company)){
			ArrayList<String> list = map.get(company);
			if(list.isEmpty()){
				return null;
			}
			return list;
		}
		else{
			return null;
		}
		
	}

	public String buyMobile(String company, String model){

		if(!map.containsKey(company)){
			return "item not available";
		}
		if(! (map.get(company).contains(model) ) ){
			return "item not available";
		}
		
		ArrayList<String> list = map.get(company);
		list.remove(model);

		return "mobile sold successfully";
	}

}

public class Source {
	public static void main(String args[] ) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Mobile m = new Mobile();
		
		HashMap<String, ArrayList<String>> map1 = new HashMap<>();
		ArrayList<String> list = new ArrayList<>(Arrays.asList("OppoA10"));
		
		m.map.put("Oppo", list);
		System.out.println(m.buyMobile("Oppo", "OpoA10"));
		System.out.println(m.map);
		
		m.addMobile("Vivo", "A20");
		m.addMobile("Vivo", "A21");
		System.out.println(m.map);
		System.out.println(m.getModels("Vivo"));
	}
}
