package com.capgemini.queue.priorityqueue;

public class Student implements Comparable {
	int studAge;
	String studName;
	public Student(int studAge, String studName) {
		super();
		this.studAge = studAge;
		this.studName = studName;
	}
	@Override
	public int compareTo(Object o) {
		return 1;
	}
	@Override
	public String toString() {
		return "Student [studAge=" + studAge + ", studName=" + studName + "]";
	}
	
	

}
