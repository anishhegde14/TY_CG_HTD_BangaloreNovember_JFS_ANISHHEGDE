package com.parallelproject.hibernate.forestrybean;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="contractdetails")
public class ContractBean {
	@Id
	@Column(name="contract_no")
	private long contractno;
	@Column(name="customer_id")
	private long customerid;
	@Column(name="product_id")
	private long prodid;
	@Column(name="haulier_id")
	private long haulid;
	@Column(name="delivery_date")
	private LocalDate date;
	@Column(name="day")
	private String day;
	@Column
	private String orderStatus;
	
	
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public LocalDate getDate() {
		return date;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String string) {
		this.day = string;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Column(name="Quantity")
	private int qty;
	public long getContractno() {
		return contractno;
	}
	public void setContractno(long contractno) {
		this.contractno = contractno;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public long getProdid() {
		return prodid;
	}
	public void setProdid(long prodid) {
		this.prodid = prodid;
	}
	public long getHaulid() {
		return haulid;
	}
	public void setHaulid(long haulid) {
		this.haulid = haulid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "ContractBean [contractno=" + contractno + ", customerid=" + customerid + ", prodid=" + prodid
				+ ", haulid=" + haulid + ", date=" + date + ", day=" + day + ", qty=" + qty + "]";
	}

}
