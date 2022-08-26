package com.practice;

class Student{
	String name;
	String usn;
	String college;
	int cgpa;
	
	public Student(String name, String usn, String college, int cgpa) {
		super();
		this.name = name;
		this.usn = usn;
		this.college = college;
		this.cgpa = cgpa;
	}
	
	public Student() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public int getCgpa() {
		return cgpa;
	}

	public void setCgpa(int cgpa) {
		this.cgpa = cgpa;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", usn=" + usn + ", college=" + college + ", cgpa=" + cgpa + "]";
	}
	
}

class StudentImplementation{
	
	Student s = new Student();
	
	public Student getStudentInfo(String str) {
		
		String[] str1 = str.split("@");
		s.setName(str1[0]);
		
		String[] str2 = str1[1].split("-");
		s.setUsn(str2[0]);
		
		String[] str3 = str2[1].split("#");
		s.setCollege(str3[0]);
		
		s.setCgpa(Integer.parseInt(str3[1]));
		
		return s;
	}
	
	public String getStudentSection(Student s) {
		
		int a = s.getUsn().length();
		String str = s.getUsn().substring(a-3, a);
		System.out.println(str);
		
		int n = Integer.parseInt(str);
		
		if(n>=001 && n<=060)
			return "A";
		
		else if(n>=061 && n<=120)
			return "B";
		
		else if(n>=121 && n<=180)
			return "C";
		
		else 
			return "Z";
		
	}
	
}

public class Source4 {
	public static void main(String[] args) {
		Student s = new Student();
		StudentImplementation a = new StudentImplementation();
		System.out.println(a.getStudentInfo("Rishab Jain@1PE16CS046-PESIT#8")); 
		System.out.println(a.getStudentSection(new Student("Vivie","1PE16CS175", "PESIT",7)) );
	}
}
