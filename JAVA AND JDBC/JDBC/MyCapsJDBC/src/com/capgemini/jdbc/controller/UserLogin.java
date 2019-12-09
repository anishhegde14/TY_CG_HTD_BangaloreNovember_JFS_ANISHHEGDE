package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;
import com.capgemini.jdbc.services.UserServices;

public class UserLogin {
	public static void main(String[] args) {
		UserServices services=UserFactory.instanceOfUserServices();
		
		UserBean user=new UserBean();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter username...");
		user.setUsername(sc.next());
		System.out.println("Enter the password...");
		user.setPassword(sc.next());
		
		if((services.userLogin(user.getUsername(), user.getPassword())) != null) {
			System.out.println("username is "+user.getUsername());
			System.out.println("userId is "+user.getUserid());
			System.out.println("email is "+user.getEmail());
		}
		else
			System.err.println("something went wrong....");
	}

}
