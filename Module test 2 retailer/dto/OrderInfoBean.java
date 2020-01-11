package com.capgemini.retailer.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class OrderInfoBean {

	@Id
	@Column
	@GeneratedValue
	private int order_id;
	@Column
	private int user_id;
	@Column
	private int product_id;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id" , referencedColumnName = "user_id")
	private UserInfoBean user_bean;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "product_id" , referencedColumnName = "product_id")
	private List<ProductInfoBean> product;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public UserInfoBean getUser_bean() {
		return user_bean;
	}
	public void setUser_bean(UserInfoBean user_bean) {
		this.user_bean = user_bean;
	}
	public List<ProductInfoBean> getProduct() {
		return product;
	}
	public void setProduct(List<ProductInfoBean> product) {
		this.product = product;
	}




}
