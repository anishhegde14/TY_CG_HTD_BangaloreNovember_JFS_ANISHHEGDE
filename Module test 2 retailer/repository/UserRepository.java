package com.capgemini.retailer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.retailer.dto.UserInfoBean;

public interface UserRepository  extends JpaRepository<UserInfoBean, Integer>{
	@Query("from UserInfoBean where user_id=:id ")
	public int findById(@Param("id")int id);
	
	
	public UserInfoBean findByEmail(String email);
	
	
	@Transactional
	@Modifying
	@Query("update EmployeeBean set password=:pwd where email=:id")
	public boolean changePassword(@Param("id")String id,
			@Param("pwd")String password);

}
