package com.capgemini.retailer.services;

import java.util.List;

import com.capgemini.retailer.dto.OrderInfoBean;

public interface OrderServices {

	
	public int getTotalAmount(int id);
	public List<OrderInfoBean> getAllOrderOfId(int id);
}
