package com.parallel.forestrymanagement.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contractdetails")
public class ContractBean {
	@Id
	@Column
	@GeneratedValue
	private int contractno;
	@Column
	private int customerid;
	@Column
	private int productId;
	@Column
	private int qty;
	@Column
	private int haulierId;
	@Column
	private LocalDate date;
	@Column
	private String day;
	@Column
	private String orderStatus;
	public int getContractno() {
		return contractno;
	}
	public void setContractno(int contractno) {
		this.contractno = contractno;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getHaulierId() {
		return haulierId;
	}
	public void setHaulierId(int haulierId) {
		this.haulierId = haulierId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
}