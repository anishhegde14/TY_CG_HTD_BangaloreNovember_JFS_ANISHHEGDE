package com.capgemini.mpt.dao;

import java.util.HashMap;
import java.util.List;

import com.capgemini.mpt.bean.Contact;

public interface Dao {

	Contact con=new Contact();
	
	public List<Contact> showAllContact();
	public  boolean addContact(Contact c1);
	public Contact findContact(String name);
	public boolean deleteContact(String name);
	public boolean updateContact(Contact c9,String name);
}
