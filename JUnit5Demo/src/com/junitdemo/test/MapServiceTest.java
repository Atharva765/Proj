package com.junitdemo.test;

import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.junitdemo.service.MapService;

public class MapServiceTest {
	
	MapService mservice;
	
	@Before
	public void init() {
		
		mservice = new MapService();
	}
	
	@Test
	public void addPlayerTest() {
		
		Assert.assertEquals("Player and team added", mservice.addPlayer("CSK", "M S Dhoni"));
		Assert.assertEquals("player added", mservice.addPlayer("CSK", "R Jadeja"));
		Assert.assertEquals("Player and team added", mservice.addPlayer("MI", "Rohit S"));
		//System.out.println(MapService.ipl);
	}
	
	
	@Test
	public void removePlayerTest() {
		
		Assert.assertEquals("team not present", mservice.removePlayer("CSK", "M S Dhoni"));
		mservice.addPlayer("CSK", "M S Dhoni");
		mservice.addPlayer("CSK", "R Jadeja");
		mservice.addPlayer("MI", "Rohit S");
		
		Assert.assertEquals("Player removed", mservice.removePlayer("CSK", "R Jadeja"));
		Assert.assertEquals("Player removed", mservice.removePlayer("MI", "Rohit S"));
		Assert.assertEquals("player not present", mservice.removePlayer("CSK", "R Jadeja"));
		 
	}
	
	@Test
	public void count() {
		HashMap<String, Integer> map = new HashMap<>();
		Assert.assertEquals(map, mservice.countPlayers());
		System.out.println(map.size()+ "  "+ mservice.ipl.size());
		
		mservice.addPlayer("RCB", "Abd");
		mservice.addPlayer("CSK", "MSD");
		mservice.addPlayer("RCB", "VK");
		map.put("RCB", 2);
		map.put("CSK", 1);
		Assert.assertEquals(map, mservice.countPlayers());
		System.out.println(map.size()+ " "+ mservice.ipl.size());
	}

	
	@After
	public void after() {
		mservice = null;
	}
	
}
