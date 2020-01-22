package com.parallelproject.jdbc.controller;

import java.util.Scanner;

import com.parallelproject.jdbc.forestryservices.ContractServices;
import com.parallelproject.jdbc.forestryservices.ContractServicesImpl;
import com.parallelproject.jdbc.forestryservices.ProductServices;
import com.parallelproject.jdbc.forestryservices.ProductServicesImpl;
import com.parallelproject.jdbc.login.LoginVerify;

public class Admin {
	
	static Scanner sc=new Scanner(System.in);
	static ProductServices productservices = new ProductServicesImpl();
	static ContractServices contractServices = new ContractServicesImpl();
	
	public static long isNoValid() {
		boolean b=true;
		while(b) {
			try {
				Scanner sc=new Scanner(System.in);
				int number=sc.nextInt();
				b=false;
				return number;
			}
			catch(Exception e) {
				System.out.println("Enter valid value!!!");
			}
		}
				
		return 0;
	}
	public static void main(String[] args) {
		while(true) {
		System.out.println("WELCOME TO FORESTRY MANAGEMENT WEBSITE (CREATED USING JDBC)");
		System.out.println("PLEASE LOGIN TO CONTINUE");
		System.out.println("ENTER YOUR CREDENTIALS");
		System.out.println("Enter Your ID");
		int id = (int)isNoValid();
		System.out.println("Enter Your Name");
		String name = sc.next();
		LoginVerify verify = new LoginVerify();
		int key = verify.type(name, id);
		System.out.println(key);
		
		switch (key) {

		case 1:CustomerController control=new CustomerController();
			control.customerControl(id);
			break;
			
		case 2: AdminController adminControl=new AdminController();
				adminControl.admincontrol(id);
				break;
		case 3:HaulierController haulierControl=new HaulierController();
				haulierControl.haulierController(id);
		default:
			break;
		}
		}
	}
}