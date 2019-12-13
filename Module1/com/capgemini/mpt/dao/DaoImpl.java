package com.capgemini.mpt.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.capgemini.mpt.bean.Contact;
import com.capgemini.mpt.dao.Dao;

public class DaoImpl implements Dao {
	FileReader reader;
	Properties prop;
	public DaoImpl() {

		try {
			reader=new FileReader("db.properties");
			prop=new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Contact> showAllContact() {
		List<Contact> list=new ArrayList<Contact>();
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("user"),prop.getProperty("password"));
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(prop.getProperty("query1"))){

			while(rs.next()) {
				Contact c1=new Contact();
				c1.setName(rs.getNString(1));
				c1.setNumber(rs.getString(2));
				c1.setGroup(rs.getNString(3));
				
				
				list.add(c1);
			}
			return list;
		}catch(Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	@Override
	public boolean addContact(Contact c1) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("query3"))){
			pstmt.setString(1, c1.getName());
			pstmt.setString(2, c1.getNumber());
			pstmt.setString(3, c1.getGroup());
			int ad=pstmt.executeUpdate();
		if(ad==1)
		{
			return true;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	
	}

	@Override
	public boolean deleteContact(String name) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("query5"))){
			pstmt.setString(1, name);
			int ad=pstmt.executeUpdate();
		if(ad==1)
		{
			return true;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	
	}

	@Override
	public boolean updateContact(Contact c9,String name) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("query4"))){
			pstmt.setString(1, c9.getNumber());
			//pstmt.setString(2, c9.getGroup());
			pstmt.setString(2, name);
			int ad=pstmt.executeUpdate();
		if(ad==1)
		{
			return true;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	
	}

	@Override
	public Contact findContact(String name) {
		Contact c2=new Contact();

		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("query2"))){
			pstmt.setString(1, name);

			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				c2.setName(rs.getNString(1));
				c2.setNumber(rs.getString(2));
				c2.setGroup(rs.getNString(3));
			}
			return c2;
		}catch(Exception e) {
			e.getStackTrace();
		}
		return null;
	}


}
