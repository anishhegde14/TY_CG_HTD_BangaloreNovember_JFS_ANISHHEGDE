package com.capgemini.stockmanagement.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_history")
public class TransactionHistory {

	@Id
	@Column
	@GeneratedValue
	private int transactionId;
	@Column
	private double amount;
	@Column
	private Date date;
	@Column
	private int companyId;
	@Column
	private int investorId;
	@Column
	private int noOfShares;
	@Column
	private String typeOfTransaction;

	public String getTypeOfTransaction() {
		return typeOfTransaction;
	}

	public void setTypeOfTransaction(String typeOfTransaction) {
		this.typeOfTransaction = typeOfTransaction;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getInvestorId() {
		return investorId;
	}

	public void setInvestorId(int investorId) {
		this.investorId = investorId;
	}

	public int getNoOfShares() {
		return noOfShares;
	}

	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}

	@Override
	public String toString() {
		return "TransactionHistory [transactionId=" + transactionId + ", amount=" + amount + ", date=" + date
				+ ", companyId=" + companyId + ", investorId=" + investorId + ", noOfShares=" + noOfShares
				+ ", typeOfTransaction=" + typeOfTransaction + "]";
	}

}
