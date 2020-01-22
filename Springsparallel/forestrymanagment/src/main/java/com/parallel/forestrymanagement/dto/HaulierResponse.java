package com.parallel.forestrymanagement.dto;

import java.util.List;

public class HaulierResponse {
	private int statusCode;
	private String message;
	private String discription;
	private List<HaulierBean> beans;
	private HaulierBean bean;
	public HaulierBean getBean() {
		return bean;
	}
	public void setBean(HaulierBean bean) {
		this.bean = bean;
	}
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
	public List<HaulierBean> getBeans() {
		return beans;
	}
	public void setBeans(List<HaulierBean> beans) {
		this.beans = beans;
	}

}
