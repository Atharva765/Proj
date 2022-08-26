package com.threadsdemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorModelDemo1 {
	public static void main(String[] args) throws Exception, ExecutionException{
		ExecutorService executorService = Executors.newSingleThreadExecutor() ;
		
		StudentService studentService = new StudentService();
		
		Future<Student> res = executorService.submit(studentService);
		System.out.println(res.get());
		
		
		executorService.shutdown();
	}
}

class StudentService implements Callable<Student>{

	
	public Student getStudent() throws Exception {
		return new Student("Harry Potter", 89);
	}
	
	@Override
	public Student call() throws Exception {
		return getStudent();
	}
	
}


class Student{
	private String name;
	private int marks;
	
	Student(String name, int marks){
		this.name = name;
		this.marks = marks;
			
	}
	
	public int getmarks() {
		return marks;
	}
	
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public String getname() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + "]";
	}
	
	
}