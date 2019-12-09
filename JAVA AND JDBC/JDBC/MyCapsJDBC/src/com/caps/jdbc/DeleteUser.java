package com.caps.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteUser {
	
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		//ResultSet rs=null;
		PreparedStatement pstmt=null;
		Scanner sc = new Scanner(System.in);
		try {
			//Load the Driver
			//Driver driver = new com.mysql.jdbc.Driver();
			//DriverManager.registerDriver(driver);
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded....");
			
			//Get the DBConnection
			String dbUrl="jdbc:mysql://127.0.0.1:3306/ty_cg_nov6";
			System.out.println("Enter the username and password");
			String dbUser= sc.nextLine();
			String dbPass=sc.nextLine();
			conn=DriverManager.getConnection(dbUrl, dbUser, dbPass);
			System.out.println("Connection established...");
			
			//Issue SQL QueRY
			String query = "DELETE from users_info where userid=? and password =?";
			
			pstmt = conn.prepareStatement(query);
			
			System.out.println("enter userId:  ");
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));
			System.out.println("enter password:  ");
			pstmt.setString(2, sc.nextLine());
			
			//rs= pstmt.executeQuery();
			
			int count = pstmt.executeUpdate();
			if(count>0) {
				System.out.println("User deleted");
			}else
			{
				System.err.println("wrong password or username");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//process the Results returned
		//close all JDBC object
	}

}
