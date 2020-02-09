package com.capgemini.stockmanagement.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.stockmanagement.dto.StockInfoBean;

@SpringBootTest
class StocksDaoImplTest {

	@Autowired
	StocksDao stockDao;
	
	@Test
	void testAddStock() {
		StockInfoBean stockBean = new StockInfoBean();
		stockBean.setCompanyId(89);
		stockBean.setCompanyName("abc");
		stockBean.setAvailableStocks(32);
		stockBean.setCurrentPrice(6979);
		stockBean.setHighPrice(67898);
		stockBean.setLowPrice(68979);
		stockBean.setNoOfStocks(678);
		stockBean.setVolume(678);
		assertTrue(stockDao.addStock(stockBean));
		stockDao.deleteStock(stockBean.getId());
	}

	@Test
	void testDeleteStock() {
		StockInfoBean stockBean = new StockInfoBean();
		stockBean.setCompanyId(89);
		stockBean.setCompanyName("abc");
		stockBean.setAvailableStocks(32);
		stockBean.setCurrentPrice(6979);
		stockBean.setHighPrice(67898);
		stockBean.setLowPrice(68979);
		stockBean.setNoOfStocks(678);
		stockBean.setVolume(678);
		stockDao.addStock(stockBean);
	}

	@Test
	void testUpdateStock() {
		StockInfoBean stockBean = new StockInfoBean();
		stockBean.setCompanyId(89);
		stockBean.setCompanyName("abc");
		stockBean.setAvailableStocks(32);
		stockBean.setCurrentPrice(6979);
		stockBean.setHighPrice(67898);
		stockBean.setLowPrice(68979);
		stockBean.setNoOfStocks(678);
		stockBean.setVolume(678);
		stockDao.addStock(stockBean);
		assertTrue(stockDao.updateStock(stockBean));
	}


	@Test
	void testFindAllStocks() {
		assertNotNull(stockDao.findAllStocks());
	}

}
