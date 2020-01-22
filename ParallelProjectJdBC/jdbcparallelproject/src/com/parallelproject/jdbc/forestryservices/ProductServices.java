package com.parallelproject.jdbc.forestryservices;

import java.util.List;

import com.parallelproject.jdbc.forestrybean.ProductBean;

public interface ProductServices {
	public List<ProductBean> getAllProducts();
	public boolean addProducts(ProductBean product);
	public boolean deleteProducts(int id);
	public ProductBean findProduct(int id);
	public boolean updateProduct(ProductBean product,int id);
	public ProductBean findProduct1(String id);
	
}