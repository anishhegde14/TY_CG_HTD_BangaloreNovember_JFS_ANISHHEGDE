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

import com.parallelproject.jdbc.forestrybean.HaulierBean;

public class HaulierDAOImpl implements HaulierDAO{
	FileReader f ;
	Properties prop;
public HaulierDAOImpl() {
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
	public List<HaulierBean> getAllHaulier() {
		List<HaulierBean> li=new ArrayList<HaulierBean>();
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"), prop);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(prop.getProperty("queryhaul2"))){
			while(rs.next())
			{
				
				HaulierBean haulier=new HaulierBean();
				
				haulier.setHaulierid(rs.getLong(1));
				haulier.setHauliername(rs.getString(2));
				haulier.setAddress1(rs.getString(3));
				haulier.setAddress2(rs.getString(4));
				haulier.setTown(rs.getString(5));
				haulier.setPostalcode(rs.getLong(6));
				haulier.setEmail(rs.getString(7));
				haulier.setNo(rs.getLong(8));
				
				li.add(haulier);
				
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	
	
	}

	@Override
	public boolean updateHaulier(HaulierBean haulier) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"), prop);
									PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("queryhaul5"))){
		
			pstmt.setLong(8, haulier.getHaulierid());
			pstmt.setString(1, haulier.getHauliername());
			pstmt.setString(2, haulier.getAddress1());
			pstmt.setString(3, haulier.getAddress2());
			pstmt.setString(4, haulier.getTown());
			pstmt.setLong(5, haulier.getPostalcode());
			pstmt.setString(6,haulier.getEmail());
			pstmt.setLong(7,haulier.getNo());
		int isUpdated=pstmt.executeUpdate();
		if(isUpdated!=0)
		{
			return true;
		}
	
		return false;
		
		}
		catch(Exception e)
		{
			System.out.println("Haulier not updated");
		}
		return false;
	}

	@Override
	public boolean addHaulier(HaulierBean haulier) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"), prop);
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("queryhaul1"))){
			
			pstmt.setLong(1, haulier.getHaulierid());
			pstmt.setString(2, haulier.getHauliername());
			pstmt.setString(3, haulier.getAddress1());
			pstmt.setString(4, haulier.getAddress2());
			pstmt.setString(5, haulier.getTown());
			pstmt.setLong(6, haulier.getPostalcode());
			pstmt.setString(7,haulier.getEmail());
			pstmt.setLong(8,haulier.getNo());
			
			
			int isAdded=pstmt.executeUpdate();
			if(isAdded!=0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("haulier not added");
		}
		return false;
	}

	@Override
	public boolean deleteHaulier(int haulierId) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"), prop);
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("queryhaul3"))){
			
			pstmt.setLong(1, haulierId);
		int isDeleted=pstmt.executeUpdate();
		if(isDeleted!=0)
		{
			return true;
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
			
		}
		return false;
	}

	@Override
	public HaulierBean findHaulier(int haulierId) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"), prop);
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("queryhaul4"))){
			pstmt.setInt(1, haulierId);	
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				HaulierBean haulier=new HaulierBean();
				haulier.setHaulierid((int)rs.getLong(1));
				haulier.setHauliername(rs.getString(2));
				haulier.setAddress1(rs.getString(3));
				haulier.setAddress2(rs.getString(4));
				haulier.setTown(rs.getString(5));
				haulier.setPostalcode(rs.getLong(6));
				haulier.setEmail(rs.getString(7));
				haulier.setNo(rs.getLong(8));
				
			return haulier;
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return null;
	}

}
