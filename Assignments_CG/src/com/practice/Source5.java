package com.practice;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.net.ssl.SSLEngineResult.Status;

class Task{
	private final Status status;
	private final Integer points;
	
	
	
	public Task(Status status, Integer points) {
		super();
		this.status = status;
		this.points = points;
	}

	public Status getStatus() {
		return status;
	}

	public Integer getPoints() {
		return points;
	}
	
	

	@Override
	public String toString() {
		return String.format("[%s,%d]",status,points);
	}
}

class Implementation{
	
	public double totalPoints(Collection<Task> tasks) {
		
		double sum = tasks.stream().map(p->p.getPoints()).reduce(0, Integer::sum);		
		return sum;
	}
	
	public Collection<String> weightOffEachTask(Collection<Task> tasks) {
		
		return null; 
	}
	
	
}

public class Source5 {
	public static void main(String[] args) {
		
	}
}
