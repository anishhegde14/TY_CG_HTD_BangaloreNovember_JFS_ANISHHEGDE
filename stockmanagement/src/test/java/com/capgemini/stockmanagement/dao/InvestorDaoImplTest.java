package com.capgemini.stockmanagement.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.stockmanagement.dto.InvestorDetails;

@SpringBootTest
class InvestorDaoImplTest {

	@Autowired
	InvestorDao investorDao;

	@Test
	void testRegisterInvestor() {
		InvestorDetails bean = new InvestorDetails();
		bean.setInvestorName("yuu");
		bean.setEmailId("anu@gmail.com");
		bean.setMaxInvest(567);
		bean.setUrl("fgvbnm");
		bean.setPassword("Anu@1234");
		assertTrue(investorDao.registerInvestor(bean));
		investorDao.deleteInvestor(bean.getId());
	}

	@Test
	void testDeleteInvestor() {
		InvestorDetails bean = new InvestorDetails();
		bean.setInvestorName("a");
		bean.setEmailId("abc@gmail.com");
		bean.setMaxInvest(567);
		bean.setUrl("fgvbnm");
		investorDao.registerInvestor(bean);
		assertTrue(investorDao.deleteInvestor(bean.getId()));
	}

	@Test
	void testUpdateInvestor() {
		InvestorDetails bean = new InvestorDetails();
		bean.setInvestorName("a");
		bean.setEmailId("akk@gmail.com");
		bean.setMaxInvest(567);
		bean.setUrl("fgvbnm");
		investorDao.registerInvestor(bean);
		//assertTrue(investorDao.updateInvestor(bean));
	}
	
	@Test
	void testGetAllInvestor() {
		assertNotNull(investorDao.getAllInvestor());
	}
}
