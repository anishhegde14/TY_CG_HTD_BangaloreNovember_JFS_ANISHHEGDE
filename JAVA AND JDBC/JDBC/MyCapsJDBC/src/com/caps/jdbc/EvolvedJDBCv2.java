package com.caps.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class EvolvedJDBCv2 {
	
	public static void main(String[] args) {
		FileReader reader=null;
		Properties prop=null;
		try {
			reader=new FileReader("C:\\Users\\Vivek\\Desktop\\db.properties");
			prop=new Properties();
			prop.load(reader);
			
			Class.forName(prop.getProperty("driverClass"));
			System.err.println("Driver loaded....");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbpassword"));
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(prop.getProperty("query1"))){
			while(rs.next()) {
				System.out.println("Userid: "+rs.getInt(1));
				System.out.println("UserName: "+ rs.getString("username"));
				System.out.println("Email: " + rs.getString(3));
				System.out.println("**************************************");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
