package com.capgemini.empspringboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.empspringboot.dto.EmployeeBean;

public interface EmployeeRepository extends JpaRepository<EmployeeBean, Integer> {

	
	public EmployeeBean findByEmail(String email);
	
	@Query("from EmployeeBean where name:key or email:key")
	public List<EmployeeBean> findByKey(@Param("key")String key);
	@Transactional
	@Modifying
	@Query("update EmployeeBean set password=:pwd where id=:id")
	public boolean changePassword(@Param("id")int id,@Param("pwd")String password);
	
	
}
