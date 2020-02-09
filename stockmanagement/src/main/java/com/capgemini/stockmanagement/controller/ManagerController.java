package com.capgemini.stockmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.stockmanagement.dto.BeanResponse;
import com.capgemini.stockmanagement.dto.LoginBean;
import com.capgemini.stockmanagement.dto.ManagerBean;
import com.capgemini.stockmanagement.dto.ManagerDetails;
import com.capgemini.stockmanagement.service.LoginServices;
import com.capgemini.stockmanagement.service.ManagerServices;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class ManagerController {
	@Autowired
	public ManagerServices services;
	@Autowired
	public LoginServices loginServices;

	@PostMapping(path = "/addManager", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse addManager(@RequestBody ManagerDetails bean) {
		BeanResponse beanResponse = new BeanResponse();
		try {
			try {
				if (services.addManager(bean)) {
					beanResponse.setStatusCode(200);
					beanResponse.setMessage("Account Created");
					beanResponse.setDescription("Credentials are valid");
					return beanResponse;
				}
			} catch (Exception e) {
				beanResponse.setStatusCode(500);
				beanResponse.setMessage(e.getMessage());
				return beanResponse;
			}
		} catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			return beanResponse;
		}
		return beanResponse;
	}

	@DeleteMapping(path = "/delete-manager/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse deleteManager(@PathVariable("id") int id) {
		BeanResponse beanResponse = new BeanResponse();
		try {
			System.out.println("id is=" + id);
			if (services.deleteManager(id)) {

				try {
					if (loginServices.delete(id)) {
						beanResponse.setStatusCode(200);
						beanResponse.setMessage("Account Deleted");
						beanResponse.setDescription("Credentials are invalid");
						return beanResponse;
					}
				} catch (Exception e) {
					beanResponse.setStatusCode(500);
					beanResponse.setMessage(e.getMessage());
					return beanResponse;
				}
			} else {
				beanResponse.setStatusCode(500);
				beanResponse.setMessage("Account Doesnt exists!!");

			}

		} catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			return beanResponse;
		}
		return beanResponse;
	}

	@PostMapping(path = "/modify-manager", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse updateManager(@RequestBody ManagerBean bean) {
		BeanResponse beanResponse = new BeanResponse();
		try {
			if (services.updateManager(bean)) {
				beanResponse.setStatusCode(200);
				beanResponse.setMessage("Account Updated");
				beanResponse.setDescription("Credentials are valid");
				return beanResponse;
			}
		} catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			return beanResponse;
		}

		return beanResponse;
	}

	@GetMapping(path = "/get-all-manager", produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse findAllManager() {
		BeanResponse beanResponse = new BeanResponse();
		try {
			List<ManagerBean> bean = services.findAllManager();
			beanResponse.setStatusCode(200);
			beanResponse.setManagerList(bean);
			beanResponse.setMessage("Found All");
			beanResponse.setDescription("Credentials are valid");
			return beanResponse;

		} catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			return beanResponse;
		}

	}

	@GetMapping(path = "/getManager/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse findManager(@PathVariable("id") int id) {
		BeanResponse beanResponse = new BeanResponse();
		System.out.println(id);
		try {
			ManagerBean bean = services.findManager(id);
			beanResponse.setStatusCode(200);
			beanResponse.setManagerBean(bean);
			beanResponse.setMessage("Found All");
			beanResponse.setDescription("Credentials are valid");
			return beanResponse;

		} catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			return beanResponse;
		}

	}

}
