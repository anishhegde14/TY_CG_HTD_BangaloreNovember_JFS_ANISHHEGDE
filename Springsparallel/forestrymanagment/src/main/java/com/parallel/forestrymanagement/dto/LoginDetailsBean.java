package com.parallel.forestrymanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class LoginDetailsBean {
	@Id
	@Column(nullable = false)
	@GeneratedValue
	private int id;
	@Column(unique = true)
	private String email;
	@Override
	public String toString() {
		return "LoginDetailsBean [id=" + id + ", email=" + email + ", type=" + type + ", password=" + password + "]";
	}
	@Column
	private int type;
	@Column
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}