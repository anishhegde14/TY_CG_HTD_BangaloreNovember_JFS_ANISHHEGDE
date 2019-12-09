package com.tyss.access.pack1;

public class Person {
	public String name;
	public static int age=23;
	public Person(String name) {
		this.name=name;
	}
	public void personName() {
		System.out.println("the name is:"+name);
	}
	public static void personName2() {
		System.out.println("the name is:"+age);
	}

}
