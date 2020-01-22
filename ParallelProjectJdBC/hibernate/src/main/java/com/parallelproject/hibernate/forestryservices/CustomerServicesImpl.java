package com.parallelproject.hibernate.forestryservices;

import java.util.List;

import com.parallelproject.hibernate.forestrybean.CustomerBean;
import com.parallelproject.hibernate.forestrydao.ForestryCustomerDAOImpl;
import com.parallelproject.hibernate.forestrydao.ForestryCustomerDao;

public class CustomerServicesImpl implements CustomerServices {

	ForestryCustomerDao dao = new ForestryCustomerDAOImpl();

	@Override
	public List<CustomerBean> getAllCustomer() {
		return dao.getAllCustomer();
	}

	@Override
	public boolean updateCustomer(CustomerBean customer) {
		return dao.updateCustomer(customer);
	}

	@Override
	public boolean addCustomer(CustomerBean customer) {
		return dao.addCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		return dao.deleteCustomer(customerId);
	}

	@Override
	public CustomerBean findCustomer(int customerId) {
		return dao.findCustomer(customerId);
	}

}
