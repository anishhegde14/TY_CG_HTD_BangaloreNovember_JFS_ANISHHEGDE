package com.capgemini.springwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.springwebapp.beans.EmployeeAddressBean;
import com.capgemini.springwebapp.beans.EmployeeBean;
import com.capgemini.springwebapp.dao.EmployeeDAO;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDAO dao;
	BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
	@Override
	public EmployeeBean auth(String email, String password) {

		
		
		return dao.auth(email, password);
	}

	@Override
	public boolean addEmployee(EmployeeBean bean) {
		String encodedPassword=encoder.encode(bean.getPassword());
		bean.setPassword(encodedPassword);
		
		
		
		
		List<EmployeeAddressBean> addressBeans=bean.getBeanAddress();
		for (EmployeeAddressBean employeeAddressBean : addressBeans) {
			
			employeeAddressBean.setBean(bean);
		}
		
		return dao.addEmployee(bean);
	}

	@Override
	public List<EmployeeBean> getEmployees(String key) {
		return dao.getEmployees(key);
	}

	@Override
	public boolean changePassword(int id, String password) {
		return dao.changePassword(id,encoder.encode(password));
	}

}
