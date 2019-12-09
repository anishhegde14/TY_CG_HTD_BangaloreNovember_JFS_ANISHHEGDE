package com.caps.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserEmailUpdate {

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
			String query = "UPDATE users_info SET email=? WHERE userid=? and password=? ";

			pstmt = conn.prepareStatement(query);

			System.out.println("enter userid:  ");
			pstmt.setInt(2, Integer.parseInt(sc.nextLine()));
			System.out.println("enter password:  ");
			pstmt.setString(3, sc.nextLine());
			System.out.println("enter new email to change:  ");
			pstmt.setString(1, sc.nextLine());


			int count = pstmt.executeUpdate();
			if(count>0) {
				System.out.println("email updated");
			}else
			{
				System.err.println("something went wrong...");
			}
			sc.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		//close all JDBC object
		finally {
			try {
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt!=null)
					pstmt.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
