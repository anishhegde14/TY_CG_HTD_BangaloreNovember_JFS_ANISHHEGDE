package com.parallel.forestrymanagement.services;


import com.parallel.forestrymanagement.dto.ClientBean;
import com.parallel.forestrymanagement.dto.HaulierBean;
import com.parallel.forestrymanagement.dto.LoginDetailsBean;

public interface LoginServices {

	public boolean addLoginCredentials(ClientBean detailsBean);
	public boolean deleteLoginCredentials(String id);
	public LoginDetailsBean findLoginCredentials(int id);
	public LoginDetailsBean findCredentials(String email);
	public LoginDetailsBean auth(LoginDetailsBean bean);
}