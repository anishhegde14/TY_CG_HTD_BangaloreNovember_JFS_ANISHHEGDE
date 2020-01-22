package com.parallel.forestrymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.parallel.forestrymanagement.dao.ProductDAO;
import com.parallel.forestrymanagement.dto.ProductBean;
import com.parallel.forestrymanagement.exception.ProductException;

@Service
public class ProductServicesImpl implements ProductServices{
	@Autowired
	public ProductDAO dao;
	@Override
	public boolean addProducts(ProductBean bean) {
		try {
			if(dao.findProduct1(bean.getProductName())==null )
			{
				dao.addProducts(bean);
				return true;
			}
		} catch (Exception e) {
		
			return false;
		}
		
		return false;
	}

	@Override
	public boolean updateProduct(ProductBean bean) {
		if(dao.findProduct1(bean.getProductName()).getProductId()!=0)
		{
			try {
				bean.setAvaliableqty(bean.getAvaliableqty());
				dao.updateProduct(bean, bean.getProductId());
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
		
		return false;
	}

	@Override
	public List<ProductBean> seeAllProducts() {
	return dao.getAllProducts();
		
	}

	@Override
	public ProductBean findProduct(String id) {
		try {
		int pid=Integer.parseInt(id);
		ProductBean bean=dao.findProduct(pid);
		if(bean.getProductId()!=0)
		{
			return bean;
		}
		else
		{
			return null;
		}
		
		}
		catch (Exception e) {
			
			throw new ProductException("Prouct Id has only numbers....");
		}
	}

	@Override
	public boolean deleteProducts(String id) {
		int idValue=Integer.parseInt(id);
		if(dao.findProduct(idValue).getProductId()!=0) {
			if(dao.deleteProducts(idValue)) {
				return true;
			}
		}
			
		return false;
	}

}
