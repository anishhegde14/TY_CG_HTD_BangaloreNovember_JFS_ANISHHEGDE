package com.parallel.forestrymanagement.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.parallel.forestrymanagement.dto.AdminResponse;
import com.parallel.forestrymanagement.exception.CustomerException;

public class AdminControllerResponse {
	@ExceptionHandler(CustomerException.class)
	public AdminResponse HandleCustomerException(CustomerException e) {
		AdminResponse adminResponse=new AdminResponse();
		adminResponse.setStatusCode(501);
		adminResponse.setMessage("Exception");
		adminResponse.setDiscription(e.getMessage());
		return adminResponse;
	}
}
