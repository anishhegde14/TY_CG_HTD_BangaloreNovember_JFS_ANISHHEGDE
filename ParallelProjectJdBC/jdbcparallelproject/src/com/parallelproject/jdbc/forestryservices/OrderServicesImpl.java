package com.parallelproject.jdbc.forestryservices;

import java.util.List;

import com.parallelproject.jdbc.forestrybean.OrderBean;
import com.parallelproject.jdbc.forestrydao.OrderDAO;
import com.parallelproject.jdbc.forestrydao.OrderDAOImpl;

public class OrderServicesImpl implements OrderServices {
	OrderDAO dao = new OrderDAOImpl();

	@Override
	public List<OrderBean> getAllOrder() {
		return dao.getAllOrder();
	}

	@Override
	public boolean updateOrder(OrderBean order) {
		return dao.updateOrder(order);
	}

	@Override
	public boolean addOrder(OrderBean order) {
		return dao.addOrder(order);
	}

	@Override
	public boolean deleteOrder(int orderId) {
		return dao.deleteOrder(orderId);
	}

	@Override
	public OrderBean findOrder(int orderId) {
		return dao.findOrder(orderId);
	}

}
