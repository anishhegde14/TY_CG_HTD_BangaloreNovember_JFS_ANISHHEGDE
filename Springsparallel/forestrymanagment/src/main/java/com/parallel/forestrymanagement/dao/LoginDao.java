package com.parallel.forestrymanagement.dao;

import com.parallel.forestrymanagement.dto.LoginDetailsBean;

public interface LoginDao {

	
	public boolean addLoginCredentials(LoginDetailsBean bean);
	public boolean deleteLoginCredentials(int id);
	public LoginDetailsBean findLogin(int id);
	public LoginDetailsBean findCredentials(String email);
}