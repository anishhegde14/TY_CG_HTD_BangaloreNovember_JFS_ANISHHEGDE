package com.capgemini.stockmanagement.service;

import java.util.Date;
import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagement.dao.StocksDao;
import com.capgemini.stockmanagement.dto.StockInfoBean;
import com.capgemini.stockmanagement.exception.StockException;

@Service
public class StockServicesImpl implements StockServices {

	@Autowired
	StocksDao dao;

	@Override
	public boolean addStock(StockInfoBean bean) {
		try {
			bean.setDate(new Date());
			if (dao.findStockByName(bean.getCompanyName()).getCompanyId() == 0) {
				try {
					if (dao.addStock(bean)) {
						return true;
					}
				} catch (Exception e) {
					throw new StockException("Something Went Wrong!!!");
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public boolean deleteStock(int id) throws LoginException {

		try {
			if (dao.deleteStock(id)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new LoginException("Exception!!!");
		}
	}

	@Override
	public boolean updateStock(StockInfoBean bean) throws LoginException {
		try {
			if (dao.updateStock(bean)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new LoginException("Exception!!!");
		}

	}

	@Override
	public StockInfoBean findStock(int beanId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockInfoBean findStockByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StockInfoBean> findAllStocks() throws LoginException {

		try {

			return dao.findAllStocks();
		} catch (Exception e) {

			throw new LoginException("NO records found!!!");
		}
	}

}
