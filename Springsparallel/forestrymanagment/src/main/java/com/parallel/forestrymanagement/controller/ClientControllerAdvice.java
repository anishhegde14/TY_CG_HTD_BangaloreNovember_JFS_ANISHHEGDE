package com.parallel.forestrymanagement.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.parallel.forestrymanagement.dto.ClientResponse;
import com.parallel.forestrymanagement.exception.CustomerException;
//(controllerAdvice+ResponseBody)
@RestControllerAdvice
public class ClientControllerAdvice {


	@ExceptionHandler(CustomerException.class)
		public ClientResponse HandleCustomerException(CustomerException e) {
			ClientResponse clientResponse=new ClientResponse();
			clientResponse.setStatusCode(501);
			clientResponse.setMessage("Exception");
			clientResponse.setDiscription(e.getMessage());
			return clientResponse;
		}
	}


