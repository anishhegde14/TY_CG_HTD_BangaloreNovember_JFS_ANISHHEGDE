package com.parallelproject.jdbc.forestrybean;

import java.util.Date;

public class OrderBean {

	
	private int order_no;
	private String customer_name;
	private String product_name;
	private int qty;
	private Date delivery_date;
	private String haulier_name;
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Date getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getHaulier_name() {
		return haulier_name;
	}
	public void setHaulier_name(String haulier_name) {
		this.haulier_name = haulier_name;
	}
	
}
