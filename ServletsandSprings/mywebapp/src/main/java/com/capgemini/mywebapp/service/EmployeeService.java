package com.capgemini.mywebapp.service;

import java.util.List;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.dao.EmployeeDAOImpl;
import com.capgemini.mywebapp.dao.EmployeeDao;

public interface EmployeeService {
	
	

public EmployeeInfoBean searchEmployee(int empid);
public EmployeeInfoBean authenticate(int empid,String password);
public boolean addEmployee(EmployeeInfoBean eib);
public boolean deleteEmployee(int empid);
public boolean updateEmployee(EmployeeInfoBean eib);
public List<EmployeeInfoBean> getAllEmployees();

}
