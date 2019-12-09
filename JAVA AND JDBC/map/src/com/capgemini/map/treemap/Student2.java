package com.capgemini.map.treemap;

import java.util.Comparator;

public class Student2 {
	
	int age;
	String name;
	public Student2(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student2 [age=" + age + ", " + (name != null ? "name=" + name : "") + "]";
	}
	

}
