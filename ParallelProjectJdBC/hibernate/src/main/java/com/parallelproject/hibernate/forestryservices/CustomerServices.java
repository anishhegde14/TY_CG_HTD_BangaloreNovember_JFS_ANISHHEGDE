package com.parallelproject.hibernate.forestryservices;

import java.util.List;

import com.parallelproject.hibernate.forestrybean.CustomerBean;

public interface CustomerServices {

	public List<CustomerBean> getAllCustomer();
	public boolean updateCustomer(CustomerBean customer);
	public boolean addCustomer(CustomerBean customer);
	public boolean deleteCustomer(int customerId);
	public CustomerBean findCustomer(int customerId);
	
}
