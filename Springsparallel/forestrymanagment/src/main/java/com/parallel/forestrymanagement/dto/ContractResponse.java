package com.parallel.forestrymanagement.dto;

import java.util.List;
//POJO CLASS
public class ContractResponse {
private int statusCode;
private String message;
private String discription;
private List<ContractBean> beans;
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
public List<ContractBean> getBeans() {
	return beans;
}
public void setBeans(List<ContractBean> beans) {
	this.beans = beans;
}
}
