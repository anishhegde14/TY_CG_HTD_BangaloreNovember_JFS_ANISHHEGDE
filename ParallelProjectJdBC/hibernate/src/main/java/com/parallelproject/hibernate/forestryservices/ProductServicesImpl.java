package com.parallelproject.hibernate.forestryservices;

import java.util.List;

import com.parallelproject.hibernate.forestrybean.ProductBean;
import com.parallelproject.hibernate.forestrydao.ProductDAO;
import com.parallelproject.hibernate.forestrydao.ProductDAOImpl;

public class ProductServicesImpl implements ProductServices {
	ProductDAO dao = new ProductDAOImpl();

	@Override
	public List<ProductBean> getAllProducts() {
		return dao.getAllProducts();
	}

	@Override
	public boolean addProducts(ProductBean product) {
		return dao.addProducts(product);
	}

	@Override
	public boolean deleteProducts(int id) {
		return dao.deleteProducts(id);
	}

	@Override
	public ProductBean findProduct(int id) {
		return dao.findProduct(id);
	}

	@Override
	public boolean updateProduct(ProductBean product, int id) {
		return dao.updateProduct(product, id);
	}

	@Override
	public ProductBean findProduct1(String id) {
		// TODO Auto-generated method stub
		return dao.findProduct1(id);
	}

}
