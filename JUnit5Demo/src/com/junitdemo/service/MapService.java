package com.junitdemo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapService {
	
	public Map<String, ArrayList<String>> ipl = new HashMap<>();
	
	public String addPlayer(String team, String playerName) {
		/*
		 * Step 1:
		 * Check if the team is present in the Map.
		 * if(present): add player name to the list of players of that team.
		 * if(not present): add team in the map and add the player to the list of players of that team.
		 */
		
		boolean isPresent = ipl.containsKey(team);
		if(isPresent) {
			//fetch the list of that team players
			ArrayList<String> playerlist = ipl.get(team);
			playerlist.add(playerName);
			return "player added";
		}
		
		else {
			ArrayList<String> playerlist = new ArrayList<>();
			playerlist.add(playerName);
			ipl.put(team, playerlist);
			return "Player and team added";
		}
		
		//Structure : - {CSK=[M S Dhoni, R Jadeja], MI=[Rohit Sharma]}
		//ipl : <K,V> = <"CSK" , ["MSDHONI", "R JADEJA"]>
	}
	
	public String removePlayer(String team, String playerName) {
		/*
		 * Check if team is present
		 * if(present) check if player is present in the team
		 * if(not present) give msg not present.
		 */
		
		boolean isPresent = ipl.containsKey(team);
		if(isPresent) {
			ArrayList<String> players = ipl.get(team);
			if(players.remove(playerName)) {
				return "Player removed";
			}
			else {
				return "player not present";
			}
		}
		else {
			return "team not present";
			
		}
	}
	
	public Map<String, Integer> countPlayers(){
		Map<String,Integer> map = new HashMap<>();
		
		/*
		 * for(String key : ipl.keyset()){
		 * 		ArrayList<String> list = ipl.get(key);
		 * 		int num = list.size();
		 * 		map.put(key,num);
		 * }
		 * 
		 */
		
		for(Map.Entry<String, ArrayList<String>> entry: ipl.entrySet()) {
			map.put(entry.getKey(), entry.getValue().size());
		}
		
		return map;
	}
	
}








