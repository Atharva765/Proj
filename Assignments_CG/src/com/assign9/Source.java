package com.assign9;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.*;

class Candidate{
  //Write Your Code Here..

  int id; String name; int age; String gender; String department; int yearOfJoining; double salary;

  public Candidate() {
		super();
	}
	
	Candidate(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getYearOfJoining() {
		return yearOfJoining;
	}
	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
     @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
                + department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
    }
}

class Implementation{
  //Write Your Code Here..
  
  public static  Map<String, Long> getCount(List<Candidate> list){

    Map<String,Long> map = new LinkedHashMap<>();

   long MCount =  list.stream().filter(c->c.getGender().toLowerCase().equals("male")).count();
   
   long FCount = list.stream().filter(c->c.getGender().toLowerCase().equals("female")).count();

   if(FCount > 0){
     map.put("Female",FCount);
   }
   if(MCount > 0){
     map.put("Male",MCount);
   }
   

    return map;
  }

  public static  Map<String, Double>  getAverageAge(List<Candidate> list){

    Map<String,Double> map = new LinkedHashMap<>();

    double Msum = list.stream().filter(c->c.getGender().equals("Male")).map(c->c.getAge()).reduce(0, Integer :: sum);    
    
    double Fsum = list.stream().filter(c->c.getGender().equals("Female")).map(c->c.getAge()).reduce(0, Integer :: sum);
  
    double MCount =  list.stream().filter(c->c.getGender().toLowerCase().equals("male")).count();
  
    double FCount = list.stream().filter(c->c.getGender().toLowerCase().equals("female")).count();

  double Mavg = Msum/MCount;
  double Favg = Fsum/FCount;

  if(FCount > 0){
     map.put("Female",Favg);
   }
   if(MCount > 0){
     map.put("Male",Mavg);
   }

    return map;
  }

  public static  Map<String, Long> countCandidatesDepartmentWise(List<Candidate> list){


    Map<String,List<Candidate>> list1 = list.stream().collect(Collectors.groupingBy(Candidate :: getDepartment));
    
    HashMap<String,Long> map1=new LinkedHashMap<>(); 
		
		for(Map.Entry<String,List<Candidate>> entry: list1.entrySet()) {
			String key = entry.getKey();
			long val = entry.getValue().size();
			map1.put(key, val);
		}
		return map1;
  }

  public static Optional<Candidate> getYoungestCandidateDetails(List<Candidate> list){

    list = list.stream().filter(c->c.getGender().equals("Male"))
    		.filter(c->c.getDepartment().equals("Product Development"))
    		.sorted( new A()).collect(Collectors.toList());
   

    return Optional.of(list.get(0));

  }

}
class A implements Comparator<Candidate>{

  @Override
  public int compare(Candidate c1, Candidate c2){
    return c1.getAge() - c2.getAge();
  }
}

public class Source {
	public static void main(String args[] ) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
	}
}



