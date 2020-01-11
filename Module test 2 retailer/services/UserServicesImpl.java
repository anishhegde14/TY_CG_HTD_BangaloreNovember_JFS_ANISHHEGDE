package com.capgemini.retailer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.retailer.dto.UserInfoBean;
import com.capgemini.retailer.exception.UserException;
import com.capgemini.retailer.repository.UserRepository;
@Service
public class UserServicesImpl implements UserServices {
	@Autowired
	private UserRepository repository;
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	@Override
	public boolean addUser(UserInfoBean bean) {
		
		if(repository.findByEmail(bean.getEmail()).getEmail()!=null) {
			String password=bean.getPassword();
			bean.setPassword(encoder.encode(password));
			repository.save(bean);
		
		}
		else {		
			throw new UserException("Email Already Exsists!!!");
		}
		return true;
	}

	@Override
	public boolean deleteUser(int id) {
		
		if(repository.findById(id)!=0) {
		repository.deleteById(id);}
		else {
			throw new UserException("Employee Doesn't Exist");
		}
		return true;
	}

	@Override
	public UserInfoBean auth(String email, String password) {

		UserInfoBean bean=repository.findByEmail(email);
		if(bean!=null) {
			if
			(encoder.matches(password, bean.getPassword())) {
				return bean;
			}
			throw new UserException("password doesn't match");
		}
		throw new UserException("Email doesn't exist");
	
	}

	@Override
	public boolean changePassword(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
