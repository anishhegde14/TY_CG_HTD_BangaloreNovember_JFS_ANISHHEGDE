package com.caps.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserLogin {
	public static void main(String[] args) {
		PreparedStatement pstmt=null;
		Connection conn=null;
		ResultSet rs=null;
		Statement stmt=null;
		Scanner sc=new Scanner(System.in);
		try {
			//load the driver
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			System.out.println("driver loaded.....");
			
			//get the db connection via driver
			String dbUrl="jdbc:mysql://127.0.0.1:3306/ty_cg_nov6";
			System.out.println("Enter the username and password");
			String dbUser= sc.nextLine();
			String dbPass=sc.nextLine();
			conn=DriverManager.getConnection(dbUrl, dbUser, dbPass);
			System.out.println("Connection established...");
			
			//issue the SQL queries via connection
			String query="SELECT * FROM users_info where userid= ? AND password = ?";
			pstmt= conn.prepareStatement(query);
			
			System.out.println("enter userId:  ");
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));
			System.out.println("enter password:  ");
			pstmt.setString(2, sc.nextLine());
			
			rs= pstmt.executeQuery();

			System.out.println("Query issued and executed");
			System.out.println("********************");
			
			//process the results returned
			if(rs.next()) {
				System.out.println("Userid: "+rs.getInt(1));
				System.out.println("UserName: "+ rs.getString(2));
				System.out.println("Email: " + rs.getString(3));
				System.out.println("**************************************");
			}
			
		
		} catch (SQLException e) {
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
