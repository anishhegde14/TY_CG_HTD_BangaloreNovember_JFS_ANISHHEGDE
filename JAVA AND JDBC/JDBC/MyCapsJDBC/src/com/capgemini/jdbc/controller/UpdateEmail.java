package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;
import com.capgemini.jdbc.services.UserServices;

public class UpdateEmail {
	
	public static void main(String[] args) {
		
		UserServices services=UserFactory.instanceOfUserServices();
		
		UserBean user=new UserBean();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter userId...");
		user.setUserid(sc.nextInt());
		System.out.println("Enter Email to update");
		user.setEmail(sc.next());
		System.out.println("Enter the password to confirm...");
		user.setPassword(sc.next());
		
		if(services.updateUser(user.getUserid(), user.getPassword(), user.getEmail())) {
			System.out.println("email updated succesfully");
		}
		else
			System.err.println("error");
	}

}
