package com.capgemini.stockmanagement.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.capgemini.stockmanagement.dto.StockInfoBean;

public interface StockServices {

	public boolean addStock(StockInfoBean bean);

	public boolean deleteStock(int id) throws LoginException;

	public boolean updateStock(StockInfoBean bean) throws LoginException;

	public StockInfoBean findStock(int beanId);

	public StockInfoBean findStockByName(String name);

	public List<StockInfoBean> findAllStocks() throws LoginException;

}
