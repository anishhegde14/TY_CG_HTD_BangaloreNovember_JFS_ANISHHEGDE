package com.parallelproject.hibernate.forestrydao;

import java.util.List;

import com.parallelproject.hibernate.forestrybean.CustomerBean;

public interface ForestryCustomerDao {

	public List<CustomerBean> getAllCustomer();
	public boolean updateCustomer(CustomerBean customer);
	public boolean addCustomer(CustomerBean customer);
	public boolean deleteCustomer(int customerId);
	public CustomerBean findCustomer(int customerId);
	
	
	
	
}
