package com.capgemini.retailer.services;

import com.capgemini.retailer.dto.UserInfoBean;

public interface UserServices {

	public boolean addUser(UserInfoBean bean );
	public boolean deleteUser(int id);
	public UserInfoBean auth(String email,String password);
	public boolean changePassword(String email,String password);
	
}
