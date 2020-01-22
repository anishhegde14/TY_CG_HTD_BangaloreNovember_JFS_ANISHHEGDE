package com.parallelproject.jdbc.forestrydao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.parallelproject.jdbc.forestrybean.OrderBean;

public class OrderDAOImpl implements OrderDAO {
	FileReader f;
	Properties prop;

	public OrderDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			f = new FileReader("db.properties");
			prop = new Properties();
			prop.load(f);

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderBean> getAllOrder() {
		List<OrderBean> li = new ArrayList<OrderBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl"), prop);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("query1"))) {
			while (rs.next()) {
				OrderBean order = new OrderBean();
				order.setOrder_no(rs.getInt(1));
				order.setCustomer_name(rs.getNString(2));
				order.setProduct_name(rs.getNString(3));
				order.setQty(rs.getInt(4));
				order.setDelivery_date(rs.getDate(5));
				order.setHaulier_name(rs.getNString(6));
				li.add(order);

			}
			return li;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean updateOrder(OrderBean order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addOrder(OrderBean order) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl"), prop);
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query"))) {
			pstmt.setInt(1, order.getOrder_no());
			pstmt.setString(2, order.getCustomer_name());
			pstmt.setString(3, order.getProduct_name());
			pstmt.setInt(4, order.getQty());
			pstmt.setDate(5, (Date) order.getDelivery_date());
			pstmt.setString(6, order.getHaulier_name());
			int a = pstmt.executeUpdate();
			if (a != 0) {
				return true;
			}

		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public boolean deleteOrder(int orderId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl"), prop);
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query5"))) {
			pstmt.setInt(1, orderId);
			int a = pstmt.executeUpdate();
			if (a != 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}

		return false;
	}

	@Override
	public OrderBean findOrder(int orderId) {
		OrderBean order = new OrderBean();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl"), prop);
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query2"))) {

			pstmt.setInt(1, orderId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				order.setOrder_no(rs.getInt(1));
				order.setCustomer_name(rs.getString(2));
				order.setProduct_name(rs.getString(3));
				order.setQty(rs.getInt(4));
				order.setDelivery_date(rs.getDate(5));
				order.setHaulier_name(rs.getString(6));

				return order;

			}
		} catch (Exception e) {
			return null;
		}
		return order;

	}
}