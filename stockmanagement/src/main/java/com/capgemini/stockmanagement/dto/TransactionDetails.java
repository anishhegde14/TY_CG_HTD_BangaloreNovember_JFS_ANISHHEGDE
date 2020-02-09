package com.capgemini.stockmanagement.dto;

public class TransactionDetails {

	private int transactionId;
	private int companyId;
	private int noOfShares;
	private int investorId;
	private int sellShares;

	public int getSellShares() {
		return sellShares;
	}

	public void setSellShares(int sellShares) {
		this.sellShares = sellShares;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getNoOfShares() {
		return noOfShares;
	}

	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}

	public int getInvestorId() {
		return investorId;
	}

	public void setInvestorId(int investorId) {
		this.investorId = investorId;
	}

}
