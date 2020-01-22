package com.parallelproject.hibernate.forestrydao;

import java.util.List;

import com.parallelproject.hibernate.forestrybean.ProductBean;

public interface ProductDAO {

	
	public List<ProductBean> getAllProducts();
	public boolean addProducts(ProductBean product);
	public boolean deleteProducts(int id);
	public ProductBean findProduct(int id);
	public boolean updateProduct(ProductBean product,int id);
	public ProductBean findProduct1(String id);
	
	
	
}
