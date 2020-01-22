package com.parallelproject.hibernate.controller;

import java.util.Scanner;

import com.parallelproject.hibernate.forestrybean.ProductBean;
import com.parallelproject.hibernate.forestrydao.ProductDAOImpl;
public class Test {
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		while(true) {
		String name=sc.next();
		ProductDAOImpl p=new ProductDAOImpl();
		ProductBean product=p.findProduct1(name);
		System.out.println(product);
		}
	}

}
