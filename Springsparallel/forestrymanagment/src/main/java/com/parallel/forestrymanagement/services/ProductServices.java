package com.parallel.forestrymanagement.services;

import java.util.List;

import com.parallel.forestrymanagement.dto.ProductBean;

public interface ProductServices {

	public boolean addProducts(ProductBean bean);
	public boolean deleteProducts(String id);
	public boolean updateProduct(ProductBean bean);
	public List<ProductBean> seeAllProducts();
	public ProductBean findProduct(String id);
	
}
