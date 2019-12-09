package com.capgemini.jdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.jdbc.bean.UserBean;

public class UserDAOImpl implements UserDAO {
	FileReader reader;
	Properties prop;
	UserBean user;
	public UserDAOImpl() {

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
	public List<UserBean> getAllUsers() {
		List<UserBean> list=new ArrayList<UserBean>();
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbpassword"));
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(prop.getProperty("query1"))){

			while(rs.next()) {
				user=new UserBean();
				user.setUserid(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setEmail(rs.getString(3));
				list.add(user);
			}
			return list;
		}catch(Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	@Override
	public UserBean userLogin(String username, String password) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbuser"),
				prop.getProperty("dbpassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("queryLogin"))){
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				user=new UserBean();
				user.setUserid(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setEmail(rs.getString(3));
			}
			return user;
		}catch(Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateUser(int userId, String password, String email) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("queryUpdate"));){
			pstmt.setInt(2, userId);
			pstmt.setString(1, email);
			pstmt.setString(3, password);

			int count=pstmt.executeUpdate();
			if(count>0) {
				return true;
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(int userId, String password) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("queryDelete"));){
			pstmt.setInt(1, userId);
			pstmt.setString(2, password);

			int count=pstmt.executeUpdate();
			if(count>0) {
				return true;
			}

		}catch(Exception e) {
			e.getStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertUser(UserBean user) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbpassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("queryInsert"));){
			pstmt.setInt(1, user.getUserid());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());

			int count=pstmt.executeUpdate();

			if(count > 0) {
				return true;
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		return false;
	}


}
