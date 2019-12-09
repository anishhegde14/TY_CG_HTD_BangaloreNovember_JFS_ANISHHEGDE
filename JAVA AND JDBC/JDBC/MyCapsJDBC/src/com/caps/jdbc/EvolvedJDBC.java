package com.caps.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EvolvedJDBC {
	
	public static void main(String[] args) {
		String dbUrl="jdbc:mysql://127.0.0.1:3306/ty_cg_nov6";
		String query="SELECT * from users_info";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your db user and pass");
		String user=sc.nextLine();
		String pass=sc.nextLine();
		//try with resource... in this we don't need to close JDBC objects explicitly.
		try(Connection conn=DriverManager.getConnection(dbUrl, user, pass);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(query)){
			while(rs.next()) {
				System.out.println("Userid: "+rs.getInt(1));
				System.out.println("UserName: "+ rs.getString("username"));
				System.out.println("Email: " + rs.getString(3));
				System.out.println("**************************************");
			}
			sc.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
