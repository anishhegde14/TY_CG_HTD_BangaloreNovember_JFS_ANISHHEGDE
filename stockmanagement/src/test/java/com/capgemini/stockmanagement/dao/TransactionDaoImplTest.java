package com.capgemini.stockmanagement.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.stockmanagement.dto.TransactionBean;

@SpringBootTest
class TransactionDaoImplTest {

	@Autowired
	TransactionDao dao;
	
	@Test
	void testAddTransaction() {
		TransactionBean bean = new TransactionBean();
		bean.setCompanyId(67);
		bean.setAmount(5678);
		bean.setInvestorId(567);
		bean.setNoOfShares(678);
		assertTrue(dao.addTransaction(bean));
		dao.deleteTransaction(bean.getTransactionId());
	}

	@Test
	void testDeleteTransaction() {
		TransactionBean bean = new TransactionBean();
		bean.setCompanyId(67);
		bean.setAmount(5678);
		bean.setInvestorId(567);
		bean.setNoOfShares(678);
		assertTrue(dao.addTransaction(bean));
		assertTrue(dao.deleteTransaction(bean.getTransactionId()));
	}

	@Test
	void testGetAllTranscation() {
		assertNotNull(dao.getAllTranscation());
	}

}
