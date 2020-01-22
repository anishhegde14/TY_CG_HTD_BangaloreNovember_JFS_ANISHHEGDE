package com.capgemini.empspringboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.empspringboot.dto.EmployeeBean;
import com.capgemini.empspringboot.dto.EmployeeResponse;
import com.capgemini.empspringboot.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping(path = "/auth", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse auth(@RequestBody EmployeeBean bean) {

		EmployeeBean empbean=service.auth(bean.getEmail(), bean.getPassword());
		EmployeeResponse response=new EmployeeResponse();
		if(empbean!=null)
		{
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee found for the credentials");
			response.setBeans(Arrays.asList(empbean));
			return response;
		}
		else
		{
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Employee not found for the credentials");
			return response;
		}
	}

	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse register(@RequestBody EmployeeBean bean) {
		EmployeeResponse response=new EmployeeResponse();
		boolean b = service.addEmployee(bean);
		if(b)
		{
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee added");
			return response;
		}
		else
		{
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Email Already Exists!!!!");
			return response;
		}
	}

	@GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse searchEmployee(@RequestParam("key") String key) {
		EmployeeResponse response =new EmployeeResponse();
		List<EmployeeBean> elist=service.getEmployees(key);
		if(elist!=null)
		{
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee/Employess Found");
			response.setBeans(elist);
			return response;
		}
		else
		{
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Employee not Exists!!!!");
			return response;
		}
		
		
		
	}

	@PutMapping(path = "/change-password", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse changePassword(@RequestBody EmployeeBean bean) {
		EmployeeResponse response=new EmployeeResponse();
				if(service.changePassword(bean.getId(), bean.getPassword()))
				{
					response.setStatusCode(201);
					response.setMessage("Success");
					response.setDescription("Password Changed");
					return response;
				}
				else
				{
					response.setStatusCode(401);
					response.setMessage("Failure");
					response.setDescription("Error!!!! Try Another Password ");
					return response;
				}
	}
	
	@DeleteMapping(path= "/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse deleteEmployee(int id)
	{
		EmployeeResponse response=new EmployeeResponse();
		service.deleteEmployee(id);
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Details deleted");
			return response;
			
			
		}
	}
	
	

