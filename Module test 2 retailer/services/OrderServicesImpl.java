package com.capgemini.retailer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.retailer.dto.OrderInfoBean;
import com.capgemini.retailer.repository.OrderRepository;
import com.capgemini.retailer.repository.ProductsRepository;

@Service
public class OrderServicesImpl implements OrderServices {
	@Autowired
	private OrderRepository repository;	
	private ProductsRepository productrepo;
	@Override
	public int getTotalAmount(int id) {
		List<OrderInfoBean> list=repository.getTotalOrder(id);
		int total=0;
		for (OrderInfoBean orderInfoBean : list) {
			total=total+productrepo.findById(orderInfoBean.getProduct_id()).getTotal();
		}
		
		return total;
	}

	public List<OrderInfoBean> getAllOrderOfId(int id)
	{
		
		return repository.getTotalOrder(id);
	}
	
}
