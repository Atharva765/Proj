package com.assign5;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class JobTest {
	
	
	@Test
	public void searchForJobTest() {
		Source s = new Source();
		
		try {
			s.searchForJob(0, "BE");
		} catch (NotEligibleException e) {
			assertEquals("The age entered is not typical for a human being", e.getMessage());
		}
	
		try {
			s.searchForJob(201, "BE");
		} catch (NotEligibleException e) {
			assertEquals("The age entered is not typical for a human being", e.getMessage());
		}
		
		try {
			s.searchForJob(18, "BE");
		} catch (NotEligibleException e) {
			assertEquals("Your are underage for any job", e.getMessage());
		}
		
		try {
			s.searchForJob(21, "BE");
		} catch (NotEligibleException e) {
			assertEquals("We have openings for junior developer", e.getMessage());
		}
		
		try {
			s.searchForJob(26, "MS");
		} catch (NotEligibleException e) {
			assertEquals("We have openings for senior developer", e.getMessage());
		}
		
		try {
			s.searchForJob(19, "ME");
		} catch (NotEligibleException e) {
			assertEquals("We do not have any job that matches your qualification", e.getMessage());
		}
		
		try {
			s.searchForJob(22, "MS");
		} catch (NotEligibleException e) {
			assertEquals("Sorry we have no openings for now", e.getMessage());
		}
		
	}
}
