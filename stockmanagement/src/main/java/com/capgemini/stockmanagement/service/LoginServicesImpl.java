package com.capgemini.stockmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagement.dao.LoginDao;
import com.capgemini.stockmanagement.dto.LoginBean;
import com.capgemini.stockmanagement.exception.LoginException;

@Service
public class LoginServicesImpl implements LoginServices {

	@Autowired
	private LoginDao dao;

	@Override
	public LoginBean findCredentials(LoginBean bean) throws LoginException {
		try {
			LoginBean bean2 = dao.findAccount(bean.getId());
			return bean2;
		} catch (Exception e) {
			throw new LoginException("Account Doesnt Exists");
		}

	}

	@Override
	public boolean add(LoginBean bean) throws LoginException {
		try {
			if (dao.add(bean)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new LoginException("Account Doesnt Exists!!!");
		}
	}

	@Override
	public boolean delete(int id) throws LoginException {
		try {
			if (dao.findAccount(id) != null) {
				if (dao.delete(id)) {
					return true;
				}
			}
		}

		catch (Exception e) {
			throw new LoginException("Account doesnt exists!!!!");
		}

		return false;
	}

	@Override
	public boolean update(LoginBean bean) throws LoginException {
		try {
			if (dao.findCredentials(bean) != null) {
				try {
					if (dao.update(bean)) {
						return true;
					}
				} catch (Exception e) {
					throw new LoginException("Something went Wrong");
				}

			}
		} catch (Exception e) {
			throw new LoginException("Account Doesnt exist!!!!");
		}
		return false;
	}

	@Override
	public LoginBean auth(LoginBean bean) throws LoginException {
		try {
			LoginBean login = dao.findCredentials(bean);
			if (login.getEmailId().equalsIgnoreCase(bean.getEmailId())) {
				try {
					if (login.getPassword().equalsIgnoreCase(bean.getPassword())) {
						return dao.findCredentials(bean); // dao.findCredentials(bean).getRole();
					}
				} catch (Exception e) {
					throw new LoginException("Password Invalid");
				}
			}
		} catch (Exception e) {
			throw new LoginException("Email Id Invalid");
		}
		return null;
	}

}
