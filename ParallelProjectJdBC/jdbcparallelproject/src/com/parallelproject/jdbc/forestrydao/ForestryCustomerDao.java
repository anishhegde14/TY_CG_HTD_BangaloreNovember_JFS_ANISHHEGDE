package com.parallelproject.jdbc.forestrydao;

import java.util.List;

import com.parallelproject.jdbc.forestrybean.CustomerBean;

public interface ForestryCustomerDao {

	public List<CustomerBean> getAllCustomer();
	public boolean updateCustomer(CustomerBean customer);
	public boolean addCustomer(CustomerBean customer);
	public boolean deleteCustomer(int customerId);
	public CustomerBean findCustomer(int customerId);
	
	
	
	
}
