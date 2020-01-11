package com.capgemini.retailer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.retailer.dto.ProductInfoBean;
import com.capgemini.retailer.repository.ProductsRepository;
@Service
public class ProductsServicesImpl implements ProductServices{
	@Autowired
	private ProductsRepository repository;
	
	@Override
	public ProductInfoBean findProduct(int prod_id) {
		return repository.findById(prod_id);
		
	}

	@Override
	public List<ProductInfoBean> getAllProducts() {
		
		return repository.getAllProducts();
	}

}
