package com.capgemini.map.treemap;

public class Student implements Comparable<Student>{

	int age;
	String name;
	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public int compareTo(Student o) {
		
		return this.name.compareTo(o.name);
//		if(this.age>o.age)
//			return 1;
//		else if(this.age<o.age)
//			return -1;
//		else
//			return 0;
	}
	@Override
	public String toString() {
		return "Student [age=" + age + ", " + (name != null ? "name=" + name : "") + "]";
	}
	


}
