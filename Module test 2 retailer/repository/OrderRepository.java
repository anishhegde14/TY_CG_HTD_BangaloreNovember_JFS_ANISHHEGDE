package com.capgemini.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.retailer.dto.OrderInfoBean;

public interface OrderRepository extends JpaRepository<OrderInfoBean, Integer>{
	
	@Query("from OrderInfoBean where user_id=:id")
	public List<OrderInfoBean> getTotalOrder(@Param("id")int id);
	

}
