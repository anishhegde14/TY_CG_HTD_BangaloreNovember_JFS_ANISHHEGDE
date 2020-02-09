package com.capgemini.stockmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagement.dao.CompanyDao;
import com.capgemini.stockmanagement.dao.LoginDao;
import com.capgemini.stockmanagement.dao.ManagerDao;
import com.capgemini.stockmanagement.dto.CompanyBean;
import com.capgemini.stockmanagement.dto.ManagerBean;
import com.capgemini.stockmanagement.exception.CompanyException;
import com.capgemini.stockmanagement.exception.InvestorException;
import com.capgemini.stockmanagement.validations.Validation;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	CompanyDao dao;
	@Autowired
	ManagerDao managerDao;
	@Autowired
	LoginDao loginDao;

	@Override
	public boolean addCompany(CompanyBean bean) {

		try {
			if (!dao.findCompanyByName(bean.getCompanyName()).getCompanyName()
					.equalsIgnoreCase(bean.getCompanyName())) {

				if (dao.addCompany(bean)) {
					return true;
				}
				return false;
			}

			else {
				return false;
			}
		} catch (Exception e) {
		}
		throw new CompanyException("Company Already Exists");

	}

//	@Override
//	public boolean deleteCompany(int id) {
//
//	try {	if(dao.findCompany(id).getCompanyId()==0) {
//			if(dao.deleteCompany(id)) {
//				return true;
//			}
//			else {
//				return false;
//			}
//		}
//	}
//catch (Exception e) {
//			throw new CompanyException("Company Doesnt Exists");
//		}
//	return false;
//		
//	}
	@Override
	public boolean deleteCompany(int id) {
		String companyId3 = Integer.toString(id);
		try {
			if (Validation.isNumber(companyId3)) {
				if (dao.deleteCompany(id)) {
					ManagerBean bean = managerDao.findManagerByCompany(id);

					if (managerDao.deleteManager(bean.getId())) {
						if (loginDao.delete(bean.getId())) {

							return true;
						}
					}
				}
			} else {
				throw new CompanyException("Enter Valid ID ");
			}
		} catch (Exception e) {
			throw new CompanyException(e.getMessage());
		}
		return false;
	}

	@Override
	public CompanyBean findCompany(int id) {

		try {
			CompanyBean bean = dao.findCompany(id);
			return bean;
		} catch (Exception e) {
			throw new CompanyException("Company Not Found");
		}

	}

	@Override
	public List<CompanyBean> getAllCompany() {
		try {
			List<CompanyBean> beans = dao.getAllCompany();
			return beans;
		} catch (Exception e) {
			throw new CompanyException("No Companies Found Please Contact The Admin For Furth" + "er Queries");
		}
	}

	@Override
	public CompanyBean findCompanyByName(String name) {
		try {
			CompanyBean bean = dao.findCompanyByName("name");
			return bean;
		} catch (Exception e) {
			throw new CompanyException("Company Not Found !!!! Please enter Valid Name");
		}
	}

	@Override
	public boolean updateCompany(CompanyBean bean) {

		try {
			if (dao.findCompany(bean.getCompanyId()).getCompanyId() != 0) {
				if (dao.updateCompany(bean)) {
					return true;
				} else {
					return false;
				}

			} else {
				throw new CompanyException("Company Doesnt exists!!");
			}
		} catch (Exception e) {
			throw new CompanyException("Company Doesnt exists!!!");
		}

	}

}
