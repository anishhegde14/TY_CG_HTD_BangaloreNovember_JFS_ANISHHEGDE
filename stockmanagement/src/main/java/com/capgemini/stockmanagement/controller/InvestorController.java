package com.capgemini.stockmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.stockmanagement.dto.BeanResponse;
import com.capgemini.stockmanagement.dto.InvestorBean;
import com.capgemini.stockmanagement.dto.InvestorDetails;
import com.capgemini.stockmanagement.dto.LoginBean;
import com.capgemini.stockmanagement.dto.StockInfoBean;
import com.capgemini.stockmanagement.service.InvestorService;
import com.capgemini.stockmanagement.service.LoginServices;
import com.capgemini.stockmanagement.service.StockServices;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class InvestorController {

	@Autowired
	InvestorService services;
	@Autowired
	LoginServices login;

	@PostMapping(path = "/addInvestor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse addInvestor(@RequestBody InvestorDetails bean) {

		BeanResponse beanResponse = new BeanResponse();
		try {

			if (services.registerInvestor(bean)) {
				try {
					beanResponse.setStatusCode(200);
					beanResponse.setMessage("Investor Added");
					beanResponse.setDescription("Investor Registered sucessfully!!");

					return beanResponse;
				} catch (Exception e) {
					beanResponse.setStatusCode(500);
					beanResponse.setMessage(e.getMessage());
					beanResponse.setDescription("Please Check The Message");
					return beanResponse;
				}
			}
		} catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			return beanResponse;
		}
		return beanResponse;

	}

	@PutMapping(path = "/modify-investor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse updateInvestor(@RequestBody InvestorBean bean) {

		BeanResponse beanResponse = new BeanResponse();
		try {
			if (services.updateInvestor(bean)) {
				beanResponse.setStatusCode(200);
				beanResponse.setMessage("Investor updated");
				beanResponse.setDescription("Investor updated in table");
			} else {
				beanResponse.setStatusCode(400);
				beanResponse.setMessage("Investor Couldnt Be updated");
				beanResponse.setDescription("Something Went Wrong");
			}

			return beanResponse;
		} catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			beanResponse.setDescription("Please Check The Message");
			return beanResponse;
		}
	}

	@DeleteMapping(path = "/delete-investor/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse deleteInvestor(@PathVariable("id") int id) {

		BeanResponse beanResponse = new BeanResponse();
		try {
			if (services.deleteInvestor(id)) {
				beanResponse.setStatusCode(200);
				beanResponse.setMessage("Success");
				beanResponse.setDescription("Investors deleted");
			} else {
				beanResponse.setStatusCode(400);
				beanResponse.setMessage("Failure");
				beanResponse.setDescription("Investor Couldnt Be deleted");
			}

			return beanResponse;
		} catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			beanResponse.setDescription("Please Check The Message");
			return beanResponse;
		}
	}

	@GetMapping(path = "/get-all-investor", produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse getAllInvestor() {

		BeanResponse beanResponse = new BeanResponse();
		try {
			List<InvestorBean> bean = services.getAllInvestor();

			if (!bean.isEmpty()) {
				beanResponse.setStatusCode(200);
				beanResponse.setMessage("Success");
				beanResponse.setDescription("Investor Details found");
				beanResponse.setInvestorList(bean);
			} else {
				beanResponse.setStatusCode(400);
				beanResponse.setMessage("Failure");
				beanResponse.setDescription("Investors Couldnt Be found");
			}

			return beanResponse;
		} catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			beanResponse.setDescription("Please Check The Message");
			return beanResponse;
		}
	}

	@GetMapping(path = "/get-investor/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse findInvestor(@PathVariable("id") String id) {
		BeanResponse beanResponse = new BeanResponse();
		System.out.println(id);
		try {
			InvestorBean bean = services.searchInvestor(id);
			beanResponse.setStatusCode(200);
			beanResponse.setDescription("Update Investor now");
			beanResponse.setMessage("investor found");
			beanResponse.setBean1(bean);
			return beanResponse;
		} catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
		}
		return beanResponse;

	}
}