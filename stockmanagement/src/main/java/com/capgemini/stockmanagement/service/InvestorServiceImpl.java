package com.capgemini.stockmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagement.dao.InvestorDao;
import com.capgemini.stockmanagement.dao.LoginDao;
import com.capgemini.stockmanagement.dto.CompanyBean;
import com.capgemini.stockmanagement.dto.InvestorBean;
import com.capgemini.stockmanagement.dto.InvestorDetails;
import com.capgemini.stockmanagement.dto.LoginBean;
import com.capgemini.stockmanagement.dto.ManagerBean;
import com.capgemini.stockmanagement.exception.CompanyException;
import com.capgemini.stockmanagement.exception.InvestorException;
import com.capgemini.stockmanagement.exception.ManagerException;
import com.capgemini.stockmanagement.validations.Validation;

@Service
public class InvestorServiceImpl implements InvestorService {

	@Autowired
	InvestorDao dao;
	@Autowired
	private LoginDao loginDao;

	@Override
	public boolean registerInvestor(InvestorDetails bean) {

		try {

			LoginBean loginBean = new LoginBean();
			loginBean.setEmailId(bean.getEmailId());
			loginBean.setPassword(bean.getPassword());
			loginBean.setRole("investor");
			if (loginDao.add(loginBean)) {
				InvestorBean investorBean = new InvestorBean();
				investorBean.setId(loginDao.findCredentials(loginBean).getId());
				investorBean.setEmailId(bean.getEmailId());
				investorBean.setInvestorName(bean.getInvestorName());
				investorBean.setMaxInvest(bean.getMaxInvest());
				investorBean.setUrl(bean.getUrl());

				if (dao.registerInvestor(bean)) {

					return true;
				}
			}
		} catch (Exception e) {
			throw new ManagerException("Investor Account Already Exists!!!!!");
		}
		return false;
	}

	@Override
	public boolean deleteInvestor(int id) {
		String investorId3 = Integer.toString(id);

		if (Validation.isNumber(investorId3)) {
			return dao.deleteInvestor(id);
		} else {
			throw new InvestorException("Enter numbers only ");
		}
	}

	@Override
	public boolean updateInvestor(InvestorBean bean) {

		if (dao.searchInvestor(bean.getEmailId()).getId() != 0) {
			if (dao.updateInvestor(bean)) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}

	@Override
	public InvestorBean searchInvestor(String emailId) {

		try {
			InvestorBean bean = dao.searchInvestor(emailId);
			System.out.println("output in service" + bean);
			return bean;
		} catch (Exception e) {
			throw new InvestorException("no Investors Found!!!!");
		}
	}

	@Override
	public List<InvestorBean> getAllInvestor() {
		try {
			List<InvestorBean> beans = dao.getAllInvestor();
			return beans;
		} catch (Exception e) {
			throw new InvestorException("No Investors Found Please Contact The Admin For Furth" + "er Queries");
		}
	}

	@Override
	public InvestorBean searchInvestorById(int id) {

//		try {
//			InvestorBean bean=dao.
//		}

		return null;
	}

}
