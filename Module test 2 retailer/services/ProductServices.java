package com.capgemini.retailer.services;

import java.util.List;

import com.capgemini.retailer.dto.ProductInfoBean;

public interface ProductServices {

	public ProductInfoBean findProduct(int prod_id);
	public List<ProductInfoBean> getAllProducts();
	
	
}
