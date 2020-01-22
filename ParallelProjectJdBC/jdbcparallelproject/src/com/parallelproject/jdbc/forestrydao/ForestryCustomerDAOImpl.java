package com.parallelproject.jdbc.forestrydao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.parallelproject.jdbc.forestrybean.CustomerBean;

public class ForestryCustomerDAOImpl implements ForestryCustomerDao{
	FileReader f ;
	Properties prop;
public ForestryCustomerDAOImpl() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		f=new FileReader("db.properties");
		prop=new Properties();
		prop.load(f);
		
		
	} catch (ClassNotFoundException  | IOException e) {
		e.printStackTrace();
	}
	
	

}
	@Override
	public List<CustomerBean> getAllCustomer() {
		List<CustomerBean> li=new ArrayList<CustomerBean>();
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"), prop);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(prop.getProperty("query6"))){
			while(rs.next())
			{
				
				CustomerBean customer=new CustomerBean();
				
				customer.setCustomerid(rs.getLong(1));
				customer.setCustomername(rs.getString(2));
				customer.setAddress1(rs.getString(3));
				customer.setAddress2(rs.getString(4));
				customer.setTown(rs.getString(5));
				customer.setPostalcode(rs.getLong(6));
				customer.setEmail(rs.getString(7));
				customer.setNo(rs.getLong(8));
				
				li.add(customer);
				
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	
	
	}

	@Override
	public boolean updateCustomer(CustomerBean customer) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"), prop);
									PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("querycusu"))){
		
			pstmt.setLong(8, customer.getCustomerid());
			pstmt.setString(1, customer.getCustomername());
			pstmt.setString(2, customer.getAddress1());
			pstmt.setString(3, customer.getAddress2());
			pstmt.setString(4, customer.getTown());
			pstmt.setLong(5, customer.getPostalcode());
			pstmt.setString(6,customer.getEmail());
			pstmt.setLong(7,customer.getNo());
		int isUpdated=pstmt.executeUpdate();
		if(isUpdated!=0)
		{
			return true;
		}
	
		return false;
		
		}
		catch(Exception e)
		{
			System.out.println("Customer not updated");
		}
		return false;
	}

	@Override
	public boolean addCustomer(CustomerBean customer) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"), prop);
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("querycust1"))){
			
			pstmt.setLong(1, customer.getCustomerid());
			pstmt.setString(2, customer.getCustomername());
			pstmt.setString(3, customer.getAddress1());
			pstmt.setString(4, customer.getAddress2());
			pstmt.setString(5, customer.getTown());
			pstmt.setLong(6, customer.getPostalcode());
			pstmt.setString(7,customer.getEmail());
			pstmt.setLong(8,customer.getNo());
			
			
			int isAdded=pstmt.executeUpdate();
			if(isAdded!=0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Customer not added");
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"), prop);
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("querycust2"))){
			
			pstmt.setLong(1,customerId);
		int isDeleted=pstmt.executeUpdate();
		if(isDeleted!=0)
		{
			return true;
		}
		
		}
		catch(Exception e)
		{	e.printStackTrace();
			return false;
			
		}
		return false;
	}

	@Override
	public CustomerBean findCustomer(int customerId) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"), prop);
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("queryc1"))){
				pstmt.setLong(1, customerId);
				ResultSet rs = pstmt.executeQuery();
				CustomerBean customer=new CustomerBean();
				while(rs.next()) {
				customer.setCustomerid(rs.getLong(1));
				customer.setCustomername(rs.getString(2));
				customer.setAddress1(rs.getString(3));
				customer.setAddress2(rs.getString(4));
				customer.setTown(rs.getString(5));
				customer.setPostalcode(rs.getLong(6));
				customer.setEmail(rs.getString(7));
				customer.setNo(rs.getLong(8));
				}
				
			return customer;
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return null;
	}

}
