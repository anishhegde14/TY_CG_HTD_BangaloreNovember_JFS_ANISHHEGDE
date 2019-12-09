package com.caps.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUser {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		Scanner sc = new Scanner(System.in);
		try {
			//Load the Driver
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			System.out.println("driver loaded....");

			//Get the DBConnection
			String dbUrl="jdbc:mysql://127.0.0.1:3306/ty_cg_nov6";
			System.out.println("Enter the username and password");
			String dbUser= sc.nextLine();
			String dbPass=sc.nextLine();
			conn=DriverManager.getConnection(dbUrl, dbUser, dbPass);
			System.out.println("Connection established...");

			//Issue SQL QueRY
			String query = "INSERT into users_info values(?,?,?,?)";

			pstmt = conn.prepareStatement(query);

			System.out.println("enter userId:  ");
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));
			System.out.println("enter username:  ");
			pstmt.setString(2, sc.nextLine());
			System.out.println("enter email:  ");
			pstmt.setString(3, sc.nextLine());
			System.out.println("enter password:  ");
			pstmt.setString(4, sc.nextLine());

			int count = pstmt.executeUpdate();
			if(count>0) {
				System.out.println("User inserted");
			}else
			{
				System.err.println("something went wrong");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(conn != null) {
					conn.close();
				} 
			}catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt != null) {
					conn.close();
				} 
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
