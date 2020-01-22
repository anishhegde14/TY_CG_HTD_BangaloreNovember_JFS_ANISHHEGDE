package com.capgemini.mywebapp.dao;

import java.util.List;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;

public interface EmployeeDao {

	
	public EmployeeInfoBean searchEmployee(int empid);
	
	public EmployeeInfoBean authenticate(int empid,String password);
	
	public boolean addEmployee(EmployeeInfoBean eib);
	public boolean deleteEmployee(int empid);
	public boolean updateEmployee(EmployeeInfoBean eib);
	public List<EmployeeInfoBean> getAllEmployees();
}
