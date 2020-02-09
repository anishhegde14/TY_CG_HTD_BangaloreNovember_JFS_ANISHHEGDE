package com.capgemini.stockmanagement.dao;

import java.util.List;

import com.capgemini.stockmanagement.dto.TransactionHistory;

public interface TransactionHistoryDao {

	public boolean addTransaction(TransactionHistory bean);

	public List<TransactionHistory> viewAllTransaction();

}
