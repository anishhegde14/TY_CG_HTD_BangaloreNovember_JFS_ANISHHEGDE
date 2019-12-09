package com.tyss.typecasting.pack1;

public class Primitive {
	byte b=10;
	short s=b;
	int i=b;
	float f=b;
	double d=b;
	double d1=3.123;
	int i1=(int)d1;
	
	void values() {
		System.out.println("the value of byte is"+b);
		System.out.println("the value of int is"+i);
		System.out.println("the value of short is"+s);
		System.out.println("the value of float is"+f);
		System.out.println("the value of double is"+d);
	}
	void details() {
		System.out.println("the value of double d1 is "+d1);
		System.out.println("the value of int i1 is "+i1);
	}

}
