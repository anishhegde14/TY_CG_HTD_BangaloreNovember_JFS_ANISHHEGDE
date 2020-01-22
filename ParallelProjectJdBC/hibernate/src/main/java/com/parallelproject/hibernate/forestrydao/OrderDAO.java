package com.parallelproject.hibernate.forestrydao;

import java.util.List;

import com.parallelproject.hibernate.forestrybean.OrderBean;

public interface OrderDAO {

	public List<OrderBean> getAllOrder();
	public boolean updateOrder(OrderBean order);
	public boolean addOrder(OrderBean order);
	public boolean deleteOrder(int orderId);
	public OrderBean findOrder(int orderId);
	
}
