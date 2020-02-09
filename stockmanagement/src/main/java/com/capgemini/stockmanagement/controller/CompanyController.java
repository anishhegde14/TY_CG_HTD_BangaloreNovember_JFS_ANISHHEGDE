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
import com.capgemini.stockmanagement.dto.CompanyBean;
import com.capgemini.stockmanagement.service.CompanyService;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class CompanyController {

	@Autowired
	CompanyService companyServices;

	@PostMapping(path = "addCompany", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse addCompany(@RequestBody CompanyBean bean) {
		BeanResponse beanResponse = new BeanResponse();
		try {
			if (companyServices.addCompany(bean)) {
				try {
					beanResponse.setStatusCode(200);
					beanResponse.setMessage("Company Added");
					beanResponse.setDescription("Company Added Successfully....");
					return beanResponse;
				} catch (Exception e) {
					beanResponse.setStatusCode(500);
					beanResponse.setMessage(e.getMessage());
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

	@DeleteMapping(path = "/delete-company/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse deleteCompany(@PathVariable("id") int id) {
		BeanResponse beanResponse = new BeanResponse();
		try {
			System.out.println("id is=" + id);
			if (companyServices.deleteCompany(id)) {

				try {

					beanResponse.setStatusCode(200);
					beanResponse.setMessage("Company Deleted");
					beanResponse.setDescription("Company Successfully removed from Market");
					return beanResponse;

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

	@PutMapping(path = "/modify-company", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse updateCompany(@RequestBody CompanyBean bean) {
		BeanResponse beanResponse = new BeanResponse();
		try {
			if (companyServices.updateCompany(bean)) {
				beanResponse.setStatusCode(200);
				beanResponse.setMessage("Account Updated");
				beanResponse.setDescription("Company Details updated  Successfully....");
				return beanResponse;
			}
		} catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			return beanResponse;
		}

		return beanResponse;
	}

	@GetMapping(path = "/get-all-company", produces = MediaType.APPLICATION_JSON_VALUE)
	public BeanResponse findAllCompany() {
		BeanResponse beanResponse = new BeanResponse();
		try {
			List<CompanyBean> bean = companyServices.getAllCompany();
			beanResponse.setStatusCode(200);
			beanResponse.setCompanyList(bean);
			beanResponse.setMessage("Found All");
			beanResponse.setDescription("Company Details not present....");
			return beanResponse;

		} catch (Exception e) {
			beanResponse.setStatusCode(500);
			beanResponse.setMessage(e.getMessage());
			return beanResponse;
		}

	}

}
