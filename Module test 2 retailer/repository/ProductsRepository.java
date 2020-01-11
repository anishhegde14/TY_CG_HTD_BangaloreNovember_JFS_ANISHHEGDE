package com.capgemini.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.retailer.dto.ProductInfoBean;

public interface ProductsRepository extends JpaRepository<ProductInfoBean, Integer>{
	@Query("from ProductInfoBean where prod_id=:prod_id")
	public ProductInfoBean findById(@Param("prod_id")int prod_id);
	
	@Query("from ProductInfoBean")
	public List<ProductInfoBean> getAllProducts();

}
