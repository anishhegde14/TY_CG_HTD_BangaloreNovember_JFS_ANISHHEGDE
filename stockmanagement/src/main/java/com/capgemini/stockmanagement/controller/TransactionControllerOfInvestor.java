package com.capgemini.stockmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.stockmanagement.dto.BeanResponse;
import com.capgemini.stockmanagement.dto.TransactionBean;
import com.capgemini.stockmanagement.service.TransactionServices;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "True")
@RestController
public class TransactionControllerOfInvestor {

	@Autowired
	TransactionServices services;

	@GetMapping(path = "/getAllTransactionInvestor/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse showAllTransactionOfInvestor(@PathVariable("id") int id) {
		BeanResponse beanResponse = new BeanResponse();
		try {
			List<TransactionBean> list = services.getAllTransactionOfInvestor(id);
			System.out.println("id is=" + id);
			beanResponse.setStatusCode(200);
			beanResponse.setMessage("Transaction Found");
			beanResponse.setDescription("Transaction details found");
			beanResponse.setListTransaction(list);
			return beanResponse;
		} catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			return beanResponse;
		}
	}
}
