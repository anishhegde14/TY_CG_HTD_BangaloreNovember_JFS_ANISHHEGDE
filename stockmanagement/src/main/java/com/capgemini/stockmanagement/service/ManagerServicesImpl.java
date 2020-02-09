package com.capgemini.stockmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagement.dao.CompanyDao;
import com.capgemini.stockmanagement.dao.LoginDao;
import com.capgemini.stockmanagement.dao.ManagerDao;
import com.capgemini.stockmanagement.dto.LoginBean;
import com.capgemini.stockmanagement.dto.ManagerBean;
import com.capgemini.stockmanagement.dto.ManagerDetails;
import com.capgemini.stockmanagement.exception.CompanyException;
import com.capgemini.stockmanagement.exception.InvestorException;
import com.capgemini.stockmanagement.exception.ManagerException;
import com.capgemini.stockmanagement.validations.Validation;

@Service
public class ManagerServicesImpl implements ManagerServices {
	@Autowired
	private ManagerDao dao;
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private CompanyDao companyDao;

	@Override
	public boolean addManager(ManagerDetails bean) {
		try {

			ManagerBean bean2 = dao.findManagerByCompany(bean.getCompanyId());
			if (bean2.getCompanyId() != 0) {
				throw new CompanyException("Manager For This Company Already Exists!!!!");
			}
			if (companyDao.findCompany(bean.getCompanyId()).getCompanyId() == 0) {
				throw new CompanyException("Company Doesnt Exist!!!");
			}
			LoginBean loginBean = new LoginBean();
			loginBean.setEmailId(bean.getEmailId());
			loginBean.setPassword(bean.getPassword());
			loginBean.setRole("manager");
			if (loginDao.add(loginBean)) {
				ManagerBean managerBean = new ManagerBean();
				managerBean.setId(loginDao.findCredentials(loginBean).getId());
				managerBean.setAddress(bean.getAddress());
				managerBean.setCompanyId(bean.getCompanyId());
				managerBean.setEmailId(bean.getEmailId());
				managerBean.setManagerName(bean.getManagerName());
				managerBean.setCompanyName(bean.getCompanyName());

				if (dao.addManager(managerBean)) {

					return true;
				}
			}
		} catch (Exception e) {
			throw new ManagerException(e.getMessage());
		}
		return false;
	}

//	@Override
//	public boolean deleteManager(int id) {
//
//		try {
//			if(dao.findManager(id).getId()==0) {
//				if(dao.deleteManager(id)) {
//				return true;
//			}
//				else {
//					return false;
//				}
//			}
//		}
//		catch (Exception e) {
//			
//			throw new ManagerException("Manager Account Doesn't Exists!!!!!");
//		}
//			return false;
//			
//		}

	@Override
	public boolean deleteManager(int id) {
		String managerId3 = Integer.toString(id);

		if (Validation.isNumber(managerId3)) {
			if (loginDao.delete(id)) {
				return dao.deleteManager(id);
			}
		} else {
			throw new InvestorException("Enter numbers only ");
		}
		return false;
	}

	@Override
	public ManagerBean findManager(int id) {

		try {
			ManagerBean bean = dao.findManager(id);
			System.out.println(bean);
			return bean;
		} catch (Exception e) {

			throw new ManagerException("No Manager Found!!");
		}

	}

	@Override
	public ManagerBean findManagerByName(String name) {

		try {
			ManagerBean bean = dao.findManagerByName(name);
			return bean;
		} catch (Exception e) {

			throw new ManagerException("No Manager Found!!!!!!");
		}
	}

	@Override
	public List<ManagerBean> findAllManager() {

		try {
			return dao.findAllManager();
		} catch (Exception e) {
			throw new ManagerException("NO MANAGERS ARE PRESENT!!! Please add any");
		}

	}

	@Override
	public boolean updateManager(ManagerBean bean) {
		try {
			if (findManager(bean.getId()).getId() != 0) {
				if (dao.updateManager(bean)) {
					return true;
				}
			}
		} catch (Exception e) {

			throw new ManagerException(e.getMessage());
		}

		return false;
	}

}
