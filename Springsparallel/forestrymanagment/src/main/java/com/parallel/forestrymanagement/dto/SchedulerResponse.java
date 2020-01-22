package com.parallel.forestrymanagement.dto;

import java.util.List;

public class SchedulerResponse {

	
	private int statusCode;
	private String message;
	private String discription;
	private List<HaulierBean> beans;
	private List<ContractBean> contractbean;
	public List<ContractBean> getContractbean() {
		return contractbean;
	}
	public void setContractbean(List<ContractBean> contractbean) {
		this.contractbean = contractbean;
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



