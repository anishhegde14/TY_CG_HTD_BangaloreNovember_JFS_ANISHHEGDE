package com.capgemini.stockmanagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagement.dto.StockInfoBean;
import com.capgemini.stockmanagement.dto.TransactionBean;

@Repository
public interface TransactionDao {

	public boolean addTransaction(TransactionBean bean);

	public boolean deleteTransaction(int id);

	public boolean updateTransaction(TransactionBean bean);

	public TransactionBean findTransaction(int id);

	public TransactionBean findTransactionOfInvestor(int id);

	public List<TransactionBean> getAllTranscation();

	public List<TransactionBean> getAllTransactionOfInvestor(int id);

	public List<TransactionBean> getAllTransactionOfCompany(int id);

	public TransactionBean findTransactionOfCompany(int id, int investorId);
}
