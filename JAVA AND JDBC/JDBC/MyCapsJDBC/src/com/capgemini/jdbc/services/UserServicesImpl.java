package com.capgemini.jdbc.services;

import java.util.List;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.dao.UserDAO;
import com.capgemini.jdbc.factory.UserFactory;

public class UserServicesImpl implements UserServices{

	UserDAO dao=UserFactory.instanceOfUserDAOImpl();
	@Override
	public List<UserBean> getAllUsers() {
		return dao.getAllUsers();
	}

	@Override
	public UserBean userLogin(String username, String password) {
		return dao.userLogin(username, password);
	}

	@Override
	public boolean updateUser(int userId, String password, String email) {
		return dao.updateUser(userId, password, email);
	}

	@Override
	public boolean deleteUser(int userId, String password) {
		return dao.deleteUser(userId, password);
	}

	@Override
	public boolean insertUser(UserBean user) {
		
		return dao.insertUser(user);
	}

}
