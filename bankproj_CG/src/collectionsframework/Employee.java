package collectionsframework;

public class Employee implements Comparable<Employee>{
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}

	private int id;
	private String name;
	private double salary;
	private String department;
	
	public Employee(int id, String name, double salary, String department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department= department;
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id =id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary =salary;
	}
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String toString() {
		return "[Id :" + id + ":" + name + ":" + salary + ":" + department + "]" ;
	}

	@Override
	public int compareTo(Employee e2) {
		// TODO Auto-generated method stub
		return this.id - e2.id;
		
	}

	

	
	
}
