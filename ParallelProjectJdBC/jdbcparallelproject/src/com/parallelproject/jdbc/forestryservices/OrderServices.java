package com.parallelproject.jdbc.forestryservices;

import java.util.List;

import com.parallelproject.jdbc.forestrybean.OrderBean;

public interface OrderServices {
	public List<OrderBean> getAllOrder();
	public boolean updateOrder(OrderBean order);
	public boolean addOrder(OrderBean order);
	public boolean deleteOrder(int orderId);
	public OrderBean findOrder(int orderId);
}
