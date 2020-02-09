package com.capgemini.stockmanagement.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.stockmanagement.dto.CompanyBean;

@SpringBootTest
public class CompanyDaoImplTest {

	
	@Autowired
	CompanyDao companyDao;
	
	@Test
	void testAddCompany() {
		CompanyBean companyBean = new CompanyBean();
		companyBean.setCompanyName("gjhgkjg");
		companyBean.setCompanyWebsite("www.infosys.com");
		companyBean.setHeadQuarters("Bangalore");
		companyBean.setIndustry("abc");
		companyBean.setLogo("aghjhgjk");
		companyBean.setMaxStock(987);
		companyBean.setRevenue(876);
		companyBean.setVolume(87);
		assertTrue(companyDao.addCompany(companyBean));
		companyDao.deleteCompany(companyBean.getCompanyId());
	}

	@Test
	void testDeleteCompany() {
		CompanyBean companyBean = new CompanyBean();
		companyBean.setCompanyName("gjhgkjg");
		companyBean.setCompanyWebsite("www.infosys.com");
		companyBean.setHeadQuarters("Bangalore");
		companyBean.setIndustry("abc");
		companyBean.setLogo("aghjhgjk");
		companyBean.setMaxStock(987);
		companyBean.setRevenue(876);
		companyBean.setVolume(87);
		companyDao.addCompany(companyBean);
		assertTrue(companyDao.deleteCompany(companyBean.getCompanyId()));
	}


	@Test
	void testGetAllCompany() {
		assertNotNull(companyDao.getAllCompany());
	}


	@Test
	void testUpdateCompany() {
		CompanyBean companyBean = new CompanyBean();
		companyBean.setCompanyName("Infosys");
		companyBean.setCompanyWebsite("www.infosys.com");
		companyBean.setHeadQuarters("Bangalore");
		companyBean.setIndustry("abc");
		companyBean.setLogo("aghjhgjk");
		companyBean.setMaxStock(987);
		companyBean.setRevenue(876.7);
		companyBean.setVolume(87);
		companyDao.addCompany(companyBean);
		assertTrue(companyDao.updateCompany(companyBean));
		
	}

}
