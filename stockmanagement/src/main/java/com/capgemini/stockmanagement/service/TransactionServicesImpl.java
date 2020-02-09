package com.capgemini.stockmanagement.service;

import java.util.Date;
import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagement.dao.InvestorDao;
import com.capgemini.stockmanagement.dao.StocksDao;
import com.capgemini.stockmanagement.dao.TransactionDao;
import com.capgemini.stockmanagement.dao.TransactionHistoryDao;
import com.capgemini.stockmanagement.dto.InvestorBean;
import com.capgemini.stockmanagement.dto.StockInfoBean;
import com.capgemini.stockmanagement.dto.TransactionBean;
import com.capgemini.stockmanagement.dto.TransactionDetails;
import com.capgemini.stockmanagement.dto.TransactionHistory;
import com.capgemini.stockmanagement.exception.CompanyException;

@Service
public class TransactionServicesImpl implements TransactionServices {

	@Autowired
	TransactionDao dao;
	@Autowired
	StocksDao stockDao;
	@Autowired
	TransactionHistoryDao transactionHistoryDao;
	@Autowired
	InvestorDao investorDao;

	@Override
	public boolean addTransaction(StockInfoBean bean, int id) throws LoginException {

		try {
			List<TransactionBean> list = dao.getAllTransactionOfInvestor(id);
			double invest = 0;
			for (TransactionBean transactionBean : list) {
				invest = invest + transactionBean.getAmount();
			}

			TransactionBean transactionBean = new TransactionBean();
			transactionBean.setAmount(bean.getCurrentPrice() * bean.getNoOfStocks());
			transactionBean.setCompanyId(bean.getCompanyId());
			transactionBean.setDate(new Date());
			transactionBean.setInvestorId(id);
			transactionBean.setNoOfShares(bean.getNoOfStocks());
			InvestorBean investorBean = investorDao.searchInvestorById(id);
			System.out.println("investor Bean" + investorBean);
			if ((invest + transactionBean.getAmount()) > investorBean.getMaxInvest()) {
				throw new LoginException(
						"You Have reached your max invest Limit!!!Please sell some stocks to reduce it...");
			}
			if (bean.getNoOfStocks() > stockDao.findStockByCompanyId(bean.getCompanyId()).getAvailableStocks()) {
				throw new LoginException("Stocks entered is greater than available Stocks!!!!Enter valid Number....");
			}
			System.out.println("tcid is " + dao.findTransactionOfCompany(bean.getCompanyId(), id).getCompanyId());
			System.out.println("bcid is " + bean.getCompanyId());
			if (dao.findTransactionOfCompany(bean.getCompanyId(), id).getCompanyId() == bean.getCompanyId()) {
				System.out.println("entering if");
				TransactionBean bean3 = dao.findTransactionOfCompany(bean.getCompanyId(), id);
				transactionBean.setTransactionId(bean3.getTransactionId());
				transactionBean.setNoOfShares(bean3.getNoOfShares() + bean.getNoOfStocks());
				/* Change code here */ dao.updateTransaction(transactionBean);
			} else {
				dao.addTransaction(transactionBean);
			}
			TransactionHistory history = new TransactionHistory();
			history.setAmount(transactionBean.getAmount());
			history.setCompanyId(transactionBean.getCompanyId());
			history.setDate(transactionBean.getDate());
			history.setInvestorId(transactionBean.getInvestorId());
			history.setNoOfShares(transactionBean.getNoOfShares());
			history.setTypeOfTransaction("Buy");
			transactionHistoryDao.addTransaction(history);
			bean.setAvailableStocks(bean.getAvailableStocks() - bean.getNoOfStocks());
			bean.setNoOfStocks(0);
			stockDao.updateStock(bean);
			System.out.println("new Stock is " + bean);

			return true;

		} catch (Exception e) {
			throw new LoginException(e.getMessage());
		}
	}

	@Override
	public List<TransactionBean> getAllTranscation() throws LoginException {

		try {
			List<TransactionBean> beans = dao.getAllTranscation();
			return beans;
		} catch (Exception e) {
			throw new LoginException("No Entries Found!!!");
		}
	}

	@Override
	public List<TransactionBean> getAllTransactionOfInvestor(int id) throws LoginException {
		try {
			List<TransactionBean> beans = dao.getAllTransactionOfInvestor(id);
			return beans;
		} catch (Exception e) {
			throw new LoginException("No Entries Found!!!");
		}
	}

	@Override
	public List<TransactionBean> getAllTransactionOfCompany(int id) throws LoginException {
		try {
			List<TransactionBean> beans = dao.getAllTransactionOfCompany(id);
			return beans;
		} catch (Exception e) {
			throw new LoginException("No Entries Found!!!");
		}
	}

	@Override
	public TransactionBean findTransaction(int id) throws LoginException {
		try {
			TransactionBean beans = dao.findTransaction(id);
			return beans;
		} catch (Exception e) {
			throw new LoginException("No Entries Found!!!");
		}
	}

	@Override
	public boolean deleteTransaction(TransactionDetails details) throws LoginException {
		try {
			TransactionBean bean = dao.findTransaction(details.getTransactionId());
			if (dao.deleteTransaction(details.getTransactionId())) {
				StockInfoBean stockBean = stockDao.findStockByCompanyId(details.getCompanyId());
				stockBean.setAvailableStocks(stockBean.getAvailableStocks() + details.getSellShares());
				details.setNoOfShares(details.getNoOfShares() - details.getSellShares());
				stockDao.updateStock(stockBean);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			throw new LoginException(e.getMessage());
		}

	}

	@Override
	public boolean sellTransaction(TransactionDetails details) throws LoginException {
		try {
			TransactionBean bean = new TransactionBean();
			StockInfoBean stockInfoBean = stockDao.findStockByCompanyId(details.getCompanyId());
			bean = dao.findTransaction(details.getTransactionId());
			if (details.getSellShares() > details.getNoOfShares() || details.getSellShares() < 0) {
				throw new LoginException("Entered No Of Shares is greater than You Have");
			}
			bean.setDate(new Date());
			bean.setInvestorId(details.getInvestorId());
			bean.setCompanyId(details.getCompanyId());
			bean.setNoOfShares(details.getNoOfShares() - details.getSellShares());
			bean.setAmount(details.getSellShares() * stockInfoBean.getCurrentPrice());
			if (dao.updateTransaction(bean)) {

				stockInfoBean.setAvailableStocks(stockInfoBean.getAvailableStocks() + details.getSellShares());
				if (stockDao.updateStock(stockInfoBean)) {
					TransactionHistory history=new TransactionHistory();
					history.setAmount(bean.getAmount());
					history.setCompanyId(bean.getCompanyId());
					history.setDate(bean.getDate());
					history.setInvestorId(bean.getInvestorId());
					history.setNoOfShares(details.getSellShares());
					history.setTypeOfTransaction("sell");
					transactionHistoryDao.addTransaction(history);
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new LoginException(e.getMessage());
		}

	}

	@Override
	public List<TransactionHistory> getAllTransactionHistory() {
		try {
		List<TransactionHistory> history=transactionHistoryDao.viewAllTransaction();
		return history;
		}
		catch (Exception e) {
			throw new CompanyException("No transactions Found");
		}
	}

}
