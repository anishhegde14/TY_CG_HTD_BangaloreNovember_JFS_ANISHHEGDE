package com.capgemini.mywebapp.service;

import java.util.List;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.dao.EmployeeDAOImpl;
import com.capgemini.mywebapp.dao.EmployeeDao;

public class EmployeeServiceImpl implements EmployeeService{
	
	
	private EmployeeDao dao=new EmployeeDAOImpl();

	@Override
	public EmployeeInfoBean searchEmployee(int empid) {

	return dao.searchEmployee(empid);
	}
	
	public EmployeeInfoBean authenticate(int empid,String password)
	
	{
		return dao.authenticate(empid, password);
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean eib) {
		// TODO Auto-generated method stub
		return dao.addEmployee(eib);
	}

	@Override
	public boolean deleteEmployee(int empid) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(empid);
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean eib) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(eib);
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}

}
