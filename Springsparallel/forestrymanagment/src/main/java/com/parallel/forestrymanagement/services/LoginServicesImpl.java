package com.parallel.forestrymanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parallel.forestrymanagement.dao.LoginDao;
import com.parallel.forestrymanagement.dto.ClientBean;
import com.parallel.forestrymanagement.dto.HaulierBean;
import com.parallel.forestrymanagement.dto.LoginDetailsBean;

@Service
public class LoginServicesImpl implements LoginServices {

	@Autowired
	private LoginDao dao;
	@Override
	public boolean addLoginCredentials(ClientBean detailsBean)
	{
		LoginDetailsBean bean=new LoginDetailsBean();
		bean.setEmail(detailsBean.getEmail());
		bean.setPassword(detailsBean.getPassword());
		bean.setType(1);
			if(dao.addLoginCredentials(bean))
			{
				return true;
			}
			else {
				return false;
			}
	
	}
	@Override
	public boolean deleteLoginCredentials(String id)
	{
		try {
		int iD=Integer.parseInt(id);
		if(dao.findLogin(iD).getId()!=0)
		{
			dao.deleteLoginCredentials(iD);
		}
		return true;
		}
		catch (Exception e) {
return false;		}
	}
	@Override
	public LoginDetailsBean findLoginCredentials(int id) {
		LoginDetailsBean bean=dao.findLogin(id);
		if(bean.getId()!=0) {
			return bean;
		}
		return null;
	}
	@Override
	public LoginDetailsBean findCredentials(String email) {
		
		try {
			System.out.println("inside login services"+dao.findCredentials(email));
			LoginDetailsBean bean= dao.findCredentials(email);
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	
	}
	@Override
	public LoginDetailsBean auth(LoginDetailsBean bean) {
		
		try {
			System.err.println(bean);
			LoginDetailsBean thisbean = dao.findCredentials(bean.getEmail());
			if(thisbean.getEmail().equals(bean.getEmail()) && 
					thisbean.getPassword().equals(bean.getPassword())) {
					return thisbean;
			}
			else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
		}
		
		
		
	}
	

