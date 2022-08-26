package collectionsframework;

import java.util.HashMap;
import java.util.Map;

public class Map1 {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("harry","potter");
		map.put("ron","weaasly");
		map.put("hermoine","granger");
		
		String psw = map.get("harry");
		System.out.println(psw);    //potter
		System.out.println("==========FETCHING AND ITERATING THRU KEYS");
		for( String key: map.keySet()) {
			System.out.println(key);
		}	
		System.out.println("========FETCHING AND ITERATING THRU VALUES");
		for(String val : map.values()) {
			System.out.println(val);
		
		}
		
		System.out.println("==========ITERATING THRU MAP ENTRYSET");
		for(Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
		
		System.out.println("==========SEARCHING==========");
		String username = "ron";
		boolean status = map.containsKey(username);
		System.out.println(status? "Username Present":"Not Present");
		
		String password ="granger";
		status = map.containsValue(password);
		System.out.println(status? "Password Present": "Password Not Present");
	}
}



