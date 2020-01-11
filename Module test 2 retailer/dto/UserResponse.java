package com.capgemini.retailer.dto;

import java.util.List;

public class UserResponse {

	private int statusCode;
	private String message;
	private String discription;
	private List<UserInfoBean> beans;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public List<UserInfoBean> getBeans() {
		return beans;
	}
	public void setBeans(List<UserInfoBean> beans) {
		this.beans = beans;
	}
	
}
