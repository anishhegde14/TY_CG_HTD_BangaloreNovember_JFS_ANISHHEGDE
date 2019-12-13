package com.capgemini.mpt.control;

import java.util.List;
import java.util.Scanner;

import com.capgemini.mpt.bean.Contact;
import com.capgemini.mpt.dao.Dao;
import com.capgemini.mpt.factory.Factory;

public class MainClass {

	
	public static void main(String[] args) {
		
		
		Dao dao=Factory.getDaoImpl();
		Contact c1=new Contact();
		Scanner sc=new Scanner(System.in);
		while(true) {
		System.out.println("Welcome to Nokia 1100");
		System.out.println("Press 1 to Show all contacts");
		System.out.println("Press 2 to Search for contact (using name)");
		System.out.println("Press 3 to Operate on contact");
		System.out.println("Enter Your Choice");
		int choice =sc.nextInt();
		switch(choice)
		{
		case 1:List<Contact> lsh=dao.showAllContact();
		for (Contact contacts : lsh) {
			System.out.println(contacts);
		}
			break;
			
		case 2:System.out.println("Please Enter the Name");
				String name=sc.next();
				Contact cf=dao.findContact(name);
				
				System.out.println("Name="+cf.getName());
				System.out.println("Number="+cf.getNumber());
				System.out.println("Group="+cf.getGroup());
				System.out.println("Enter Your Choice");
				System.out.println("Press 1 to call");
				System.out.println("Press 2 to message");
				System.out.println("Press 3 to go back to main menu");
				int choice2 =sc.nextInt();
				switch(choice2)
				{
				case 1:System.out.println("Calling.....");
				
						System.out.println("Connected");
						break;
				
				case 2:System.out.println("Enter your message");
						String msg=sc.nextLine();
						System.out.println("Sending.....");
						break;
				case 3:break;
				case 4:System.out.println("Wrong Input!!!!");
					break;
				
				
				
				}
				break;
		case 3:System.out.println("Please Enter Your Choice");
				System.out.println("Press 1 to add contact");
				System.out.println("Press 2 to delete contact");
				System.out.println("Press 3 to edit contact");
				int choice1=sc.nextInt();
				switch(choice1)
				{
				case 1:System.out.println("Enter Name");
						String n1=sc.next();
						System.out.println("Enter Number");
						String l1=sc.next();
						System.out.println("Enter Group");
						String s1=sc.next();
						Contact cadd=new Contact();
						cadd.setName(n1);
						cadd.setNumber(l1);
						cadd.setGroup(s1);
						boolean ba=dao.addContact(cadd);
						if(ba) {
							System.out.println("Contact Added");
							}
							else
							{
								System.out.println("Contact not Added");
							}
							break;
						
				case 2:System.out.println("Enter the name you want to delete");
						String nd=sc.next();
						boolean b1=dao.deleteContact(nd);
						if(b1) {
						System.out.println("Contact deleted");
						}
						else
						{
							System.out.println("Contact not deleted");
						}
						break;
						
				case 3:System.out.println("Enter the contact that needs to be updated");
						String nu=sc.next();
						Contact c9=new Contact();
						System.out.println("Enter new no");
						c9.setNumber(sc.next());
						System.out.println("Enter new group");
						c9.setGroup(sc.next());
						boolean bu=dao.updateContact(c9,nu);
						if(bu) {
							System.out.println("Contact Updated");
							}
							else
							{
								System.out.println("Contact not Updated");
							}
							break;
				
				
				}
				
		break;
		default: System.out.println("Enter Valid Choice");
		}
		
		}
		
	}
}
