package com.assign4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

class Candidate{
	  //Write Your Code Here..

	  private String name;
	  private int id;
	  private int age;
	  private String gender;
	  private String department;
	  private int yearOfJoining;
	  private double salary;

	  public Candidate(int id,String name, int age, String gender, String department, int yearOfJoining, double salary){
	    this.name = name;
	    this.id =id;
	    this.age =age;
	    this.gender = gender;
	    this.department = department;
	    this.yearOfJoining = yearOfJoining;
	    this.salary = salary;

	  }

	  public String getName(){
	    return this.name;
	  }

	  public String getGender(){
	    return this.gender;
	  }

	  public int getAge(){
	    return this.age;
	  }

	  public String getDepartment(){
	    return this.department;
	  }






	     @Override
	    public String toString() {
	        return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
	                + department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
	    }
	}

	class Implementation{
	  //Write Your Code Here..

	  static public Map<String,Long> getCount(List<Candidate> list){
	    
	    ConcurrentMap<String, Long> map = new ConcurrentHashMap<>();
	    long MCount = 0;
	    long FCount = 0;
	    MCount = list.stream().filter(c->c.getGender().toLowerCase().equals("male")).count();
	   FCount = list.stream().filter(c->c.getGender().toLowerCase().equals("female")).count();
	    if(FCount > 0){
	      map.put("Female",FCount);
	    }
	    if(MCount > 0){
	      map.put("Male", MCount);
	    }
	      return map;
	  }  

	  static public Map<String,Double> getAverageAge(List<Candidate> list){
	    
	    Map<String,Double> map = new HashMap<>();


	   double mAge =  list.stream().filter(c->c.getGender().toLowerCase().equals("male")).map(p->p.getAge()).reduce(0 , Integer :: sum);

	double fAge = list.stream().filter(c->c.getGender().toLowerCase().toLowerCase().equals("female")).map(p->p.getAge()).reduce(0, Integer :: sum);

	double mCount = list.stream().filter(c->c.getGender().toLowerCase().equals("male")).count();

	double fCount = list.stream().filter(c->c.getGender().toLowerCase().equals("female")).count();

	double Fres = fAge/fCount;
	double Mres = mAge/mCount;

	if(fCount > 0){
	      map.put("Female",Fres);
	    }
	    if(mCount > 0){
	      map.put("Male", Mres);
	    }
	      
	    return map;

}

	  
	  static public Map<String,Long> countCandidatesDepartmentWise(List<Candidate> list){
	    
	    
	    return null;
	  }
	  
	  
	  
	  
	  static public Optional<Candidate> getYoungestCandidateDetails(List<Candidate> list){

	 
	  List<Candidate> list1 =  list.stream().filter(c->c.getGender().equals("Male"))
			  					.filter(p->p.getDepartment().equals("Product Development"))
			  					.sorted(new A()).collect(Collectors.toList());


	    return Optional.of(list1.get(0));
	    //Product Development
	  
	  }

}

class A implements Comparator<Candidate>{

	  @Override
	  public int compare(Candidate c1 , Candidate c2){
	    return c1.getAge() - c2.getAge();
	  }

}

	public class Source {
		public static void main(String args[] ) throws Exception {
			/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		}
	}
