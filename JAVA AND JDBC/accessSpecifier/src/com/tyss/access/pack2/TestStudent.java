package com.tyss.access.pack2;
import com.tyss.access.pack1.*;

public class TestStudent extends Student {

	protected TestStudent(String studName) {
		super(studName);
	}
	protected void studentName() {
		System.out.println("student name is "+studName);
	}
	public static void main(String[] args) {
		TestStudent ts=new TestStudent("John");
		ts.studDetails();
		ts.studentName();
	}

}
