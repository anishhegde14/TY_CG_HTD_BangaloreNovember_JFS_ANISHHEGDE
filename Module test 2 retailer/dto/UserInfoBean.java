package com.capgemini.retailer.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
public class UserInfoBean {

	
	
	@Id
	@GeneratedValue
	@Column
	private int user_id;
	@Column
	private String name;
	@Column(unique = true , nullable = false )
	private String email;
	@Column
	private String password;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user_bean")
	private List<OrderInfoBean> orders;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<OrderInfoBean> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderInfoBean> orders) {
		this.orders = orders;
	}
	
	
}
