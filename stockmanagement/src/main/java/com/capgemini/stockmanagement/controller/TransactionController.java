package com.capgemini.stockmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.stockmanagement.dto.BeanResponse;
import com.capgemini.stockmanagement.dto.StockInfoBean;
import com.capgemini.stockmanagement.dto.TransactionDetails;
import com.capgemini.stockmanagement.dto.TransactionHistory;
import com.capgemini.stockmanagement.service.TransactionServices;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class TransactionController {

	@Autowired
	TransactionServices services;

	@PostMapping(path = "/buyStocks/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse buyStocks(@RequestBody StockInfoBean bean, @PathVariable("id") int id) {
		BeanResponse beanResponse = new BeanResponse();
		try {
			System.out.println(id);
			if (services.addTransaction(bean, id)) {
				beanResponse.setStatusCode(200);
				beanResponse.setMessage("Stock Bought");
				beanResponse.setDescription("Stocks Added to table");
			} else {
				beanResponse.setStatusCode(400);
				beanResponse.setMessage("Stock Couldn't Be Bought");
				beanResponse.setDescription("Stocks Couldn't be Added to table");
			}
			return beanResponse;
		} catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			beanResponse.setDescription("Stocks Couldn't be Added to table");
			return beanResponse;

		}

	}

	@PostMapping(path = "/sellStocks", produces = MediaType.APPLICATION_JSON_VALUE,consumes =MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse sellStocks(@RequestBody TransactionDetails bean) {
		BeanResponse beanResponse = new BeanResponse();
		try {
			if (services.sellTransaction(bean)) {
				beanResponse.setStatusCode(200);
				beanResponse.setMessage("Stock Sold");
				beanResponse.setDescription("Stocks Added to table");
			} else {
				beanResponse.setStatusCode(400);
				beanResponse.setMessage("Stock Couldn't Be Bought");
				beanResponse.setDescription("Stocks Couldn't be Added to table");
			}
			return beanResponse;
		} catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			beanResponse.setDescription("Stocks Couldn't be Added to table");
			return beanResponse;

		}

	}
	@GetMapping(path = "/getAllTransactionHistory", produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse getAllTransaction() {
		BeanResponse beanResponse = new BeanResponse();
		try {List<TransactionHistory> list=services.getAllTransactionHistory();
		System.out.println(list);
			if (!list.isEmpty()) {
				beanResponse.setStatusCode(200);
				beanResponse.setList(list);
				beanResponse.setMessage("History Displayed ");
				beanResponse.setDescription("History Displayed in table");
			} else {
				beanResponse.setStatusCode(400);
				beanResponse.setMessage("History couldn't be Displayed ");
				beanResponse.setDescription("History  Couldn't be  Displayed to table");
			}
			return beanResponse;
		} catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			beanResponse.setDescription(" history Couldn't be Displayed to table");
			return beanResponse;

		}

	}
}
