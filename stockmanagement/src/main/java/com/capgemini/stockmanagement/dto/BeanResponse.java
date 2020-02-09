package com.capgemini.stockmanagement.dto;

import java.util.List;

public class BeanResponse {

	private int statusCode;
	private String message;
	private String description;
	private LoginBean bean;
	private InvestorBean bean1;
	private ManagerBean managerBean;
	private ManagerDetails managerDetails;
	private List<TransactionHistory> list;

	public List<TransactionHistory> getList() {
		return list;
	}

	public void setList(List<TransactionHistory> list) {
		this.list = list;
	}

	public ManagerDetails getManagerDetails() {
		return managerDetails;
	}

	public void setManagerDetails(ManagerDetails managerDetails) {
		this.managerDetails = managerDetails;
	}

	public ManagerBean getManagerBean() {
		return managerBean;
	}

	public void setManagerBean(ManagerBean managerBean) {
		this.managerBean = managerBean;
	}

	public InvestorBean getBean1() {
		return bean1;
	}

	public void setBean1(InvestorBean bean1) {
		this.bean1 = bean1;
	}

	private List<TransactionBean> listTransaction;
	private int id;

	public int getId() {
		return id;
	}

	public List<TransactionBean> getListTransaction() {
		return listTransaction;
	}

	public void setListTransaction(List<TransactionBean> listTransaction) {
		this.listTransaction = listTransaction;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<InvestorBean> getInvestorList() {
		return investorList;
	}

	public void setInvestorList(List<InvestorBean> investorList) {
		this.investorList = investorList;
	}

	private List<ManagerBean> managerList;
	private List<StockInfoBean> stockList;
	private List<CompanyBean> companyList;
	private List<InvestorBean> investorList;

	public List<ManagerBean> getManagerList() {
		return managerList;
	}

	public List<CompanyBean> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<CompanyBean> companyList) {
		this.companyList = companyList;
	}

	public void setManagerList(List<ManagerBean> managerList) {
		this.managerList = managerList;
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

	public List<StockInfoBean> getStockList() {
		return stockList;
	}

	public void setStockList(List<StockInfoBean> stockList) {
		this.stockList = stockList;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LoginBean getBean() {
		return bean;
	}

	public void setBean(LoginBean bean) {
		this.bean = bean;
	}

}
