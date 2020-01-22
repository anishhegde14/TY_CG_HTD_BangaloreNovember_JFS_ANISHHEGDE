package com.parallelproject.jdbc.forestrybean;

import java.time.LocalDate;
import java.util.Date;

public class ContractBean {

	private long contractno;
	private long customerid;
	private long prodid;
	private long haulid;
	private LocalDate date;
	private String day;
	private String orderStatus;
	
	
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
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
