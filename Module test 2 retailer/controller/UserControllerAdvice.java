

package com.capgemini.retailer.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//(controllerAdvice+ResponseBody)

import com.capgemini.retailer.dto.UserResponse;
import com.capgemini.retailer.exception.UserException;
@RestControllerAdvice
public class UserControllerAdvice {
	@ExceptionHandler(UserException.class)
	public UserResponse HandleEmployeeException(UserException e) {
		UserResponse erResponse=new UserResponse();
		erResponse.setStatusCode(501);
		erResponse.setMessage("Exception");
		erResponse.setDiscription(e.getMessage());
		return erResponse;
	}
}
