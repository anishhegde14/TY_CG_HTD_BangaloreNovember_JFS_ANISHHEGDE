package com.parallelproject.hibernate.forestrybean;


public class OrderBean {

	
	private int order_no;
	private String customer_name;
	private String product_name;
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
	public String getHaulier_name() {
		return haulier_name;
	}
	public void setHaulier_name(String haulier_name) {
		this.haulier_name = haulier_name;
	}
	
	
}