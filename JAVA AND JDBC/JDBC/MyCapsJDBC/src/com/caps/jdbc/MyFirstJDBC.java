package com.caps.jdbc;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyFirstJDBC {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//Load the Driver
			//Driver driver = new com.mysql.jdbc.Driver();
			//DriverManager.registerDriver(driver);
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded...");

			//Get the DB connection via driver
			String dbUrl = "jdbc:mysql://localhost:3306/ty_cg_nov6"
					+"?user=root&password=root";
			conn = DriverManager.getConnection(dbUrl);
			System.out.println("Connection established....");

			//Issue SQL query via connection
			String query = "SELECT * FROM users_info";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			System.out.println("query issued...");
			System.out.println("******************************");

			//Process the Result returned by sql queries
			while(rs.next()) {
				System.out.println("Userid: "+rs.getInt("userid"));
				System.out.println("UserName: "+ rs.getString("username"));
				System.out.println("Email: " + rs.getString("email"));
				System.out.println("**************************************");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		//close all JDBC objects
		finally {
			try {
				if(conn != null) {
					conn.close();
				} 
			}catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt != null) {
					stmt.close();
				} 
			}catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(rs != null) {
					rs.close();
				} 
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
