package com.parallelproject.jdbc.forestrydao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.parallelproject.jdbc.forestrybean.ContractBean;

public class ContractDAOImpl implements ContractorDAO {
	FileReader f;
	Properties prop;

	public ContractDAOImpl() {
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
	public List<ContractBean> getAllContract() {
		List<ContractBean> li = new ArrayList<ContractBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl"), prop);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("query1"))) {
			while (rs.next()) {
				ContractBean contract = new ContractBean();
				System.out.println("hi");
				contract.setContractno(rs.getLong(1));
				contract.setCustomerid(rs.getLong(2));
				contract.setDate(rs.getDate(3).toLocalDate());
				contract.setDay(rs.getString(4));
				contract.setHaulid(rs.getLong(5));
				contract.setProdid(rs.getLong(6));
				contract.setQty(rs.getInt(7));
				li.add(contract);

			}
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateContract(ContractBean bean) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("dburl"), prop.getProperty("dbuser"),
				prop.getProperty("dbpassword"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("query4"));) {

			pstmt.setInt(6, (int) bean.getContractno());
			pstmt.setInt(1, (int) bean.getCustomerid());
			pstmt.setInt(2, (int) bean.getProdid());
			pstmt.setInt(3, (int) bean.getHaulid());
			pstmt.setDate(4, java.sql.Date.valueOf(bean.getDate()));
			pstmt.setInt(5, bean.getQty());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("CONTRACT-ID: " + bean + " UPDATED SUCCESFULLY..!");
				return true;

			} else {
				System.err.println("something went wrong check data and please try again..!");
				return false;
			}

		} catch (SQLException e) {
			String msg = e.getMessage();
			System.err.println("Problem in updating..: " + msg);
			return false;
		}
	}

	@Override
	public boolean addContract(ContractBean contract) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl"), prop);
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query3"))) {

			pstmt.setLong(1, contract.getContractno());
			pstmt.setLong(2, contract.getCustomerid());
			pstmt.setDate(3, java.sql.Date.valueOf(contract.getDate()));
			pstmt.setString(4, contract.getDay());
			pstmt.setLong(5, contract.getHaulid());
			pstmt.setLong(6, contract.getProdid());
			pstmt.setInt(7, contract.getQty());
			int a = pstmt.executeUpdate();
			if (a != 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deleteContract(int contractId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl"), prop);
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query5"))) {
			pstmt.setInt(1, contractId);
			int a = pstmt.executeUpdate();
			if (a != 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public ContractBean findContract(int contractId) {

		ContractBean contract = new ContractBean();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl"), prop);
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query2"))) {

			pstmt.setLong(1, contractId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				contract.setContractno(rs.getLong(1));
				contract.setCustomerid(rs.getLong(2));
				contract.setDate(rs.getDate(3).toLocalDate());
				contract.setDay(rs.getString(4));
				contract.setHaulid(rs.getLong(5));
				contract.setProdid(rs.getLong(6));
				contract.setQty(rs.getInt(7));
			}
			return contract;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ContractBean> getAllContractOfCustomer(int customerId) {
		List<ContractBean> li = new ArrayList<ContractBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl"), prop);
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("queryco2"))) {
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ContractBean contract = new ContractBean();
				contract.setContractno(rs.getLong(1));
				contract.setCustomerid(rs.getLong(2));
				contract.setDate(rs.getDate(3).toLocalDate());
				contract.setDay(rs.getString(4));
				contract.setHaulid(rs.getLong(5));
				contract.setProdid(rs.getLong(6));
				contract.setQty(rs.getInt(7));
				li.add(contract);

			}
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ContractBean> getAllContractOfHaulier(int haulierId) {
		List<ContractBean> li = new ArrayList<ContractBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dburl"), prop);
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("queryco"))) {
			pstmt.setInt(1, haulierId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ContractBean contract = new ContractBean();
				contract.setContractno(rs.getLong(1));
				contract.setCustomerid(rs.getLong(2));
				contract.setDate(rs.getDate(3).toLocalDate());
				contract.setDay(rs.getString(4));
				contract.setHaulid(rs.getLong(5));
				contract.setProdid(rs.getLong(6));
				contract.setQty(rs.getInt(7));
				li.add(contract);

			}
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateContractid(int id) {

		try (Connection con = DriverManager.getConnection(prop.getProperty("dburl"), prop.getProperty("dbuser"),
				prop.getProperty("dbpassword"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("uQuery"));) {

			pstmt.setInt(1, id);
			pstmt.setString(2, "Delivered");
			int result = pstmt.executeUpdate();
			if (result > 0) {
				return true;

			} else {
				return false;
			}

		} catch (SQLException e) {
			return false;
		}

	}
}