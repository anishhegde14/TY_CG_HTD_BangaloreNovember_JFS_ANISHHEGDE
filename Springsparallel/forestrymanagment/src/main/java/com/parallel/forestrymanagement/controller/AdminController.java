package com.parallel.forestrymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.parallel.forestrymanagement.dto.ClientBean;
import com.parallel.forestrymanagement.dto.ClientResponse;
import com.parallel.forestrymanagement.dto.ContractBean;
import com.parallel.forestrymanagement.dto.ContractResponse;
import com.parallel.forestrymanagement.dto.HaulierBean;
import com.parallel.forestrymanagement.dto.HaulierResponse;
import com.parallel.forestrymanagement.services.ClientServices;

import com.parallel.forestrymanagement.services.ContractServices;
import com.parallel.forestrymanagement.services.HaulierServices;
import com.parallel.forestrymanagement.services.LoginServices;
@CrossOrigin(origins = "*",allowedHeaders = "*" , allowCredentials = "true")
@RestController
public class AdminController {
@Autowired
public	ClientServices services;
@Autowired
public LoginServices loginServices;
@Autowired
public ContractServices contractServices;
@Autowired
public HaulierServices haulierServices;
	@PostMapping(path = "/registerclient", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ClientResponse addClient(@RequestBody ClientBean eBean) {
		ClientResponse clientResponse=new  ClientResponse();
		
			
		if(services.addClient(eBean)) {
			clientResponse.setStatusCode(200);
			clientResponse.setMessage("success");
			clientResponse.setDiscription("Customer registered");
		}else {
			clientResponse.setStatusCode(401);
			clientResponse.setMessage("Failure");
			clientResponse.setDiscription("Email already exist");
		}
		return clientResponse;
	}
	
	@DeleteMapping(path = "/deleteclient/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
	public ClientResponse deleteClient(@PathVariable("id") String id)
	{
		ClientResponse clientResponse=new  ClientResponse();
		System.out.println("id is"+id);
		boolean b=services.deleteClient(String.valueOf(id));
		System.out.println(b);
		if(b) {
			
			
			clientResponse.setStatusCode(200);
			clientResponse.setMessage("success");
			clientResponse.setDiscription("Customer deleted");
		}else {
			clientResponse.setStatusCode(401);
			clientResponse.setMessage("Failure");
			clientResponse.setDiscription("Error");
		}
		return clientResponse;
	}
	
	@GetMapping(path = "getallclient" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientResponse findAllClients()
	{
	List<ClientBean> list= services.getAllClient();
	ClientResponse clientResponse=new ClientResponse();
	if(!list.isEmpty()) {
		clientResponse.setBeans(list);
		
	}else
	{
		clientResponse.setStatusCode(401);
		clientResponse.setMessage("Failure");
		clientResponse.setDiscription("Error");
		
	}
	return clientResponse;
	}

	@PostMapping(path = "/updateclient", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ClientResponse updateClient(@RequestBody ClientBean eBean) {
		ClientResponse clientResponse=new  ClientResponse();
		if(services.updateClient(eBean)) {
		
			clientResponse.setStatusCode(200);
			clientResponse.setMessage("success");
			clientResponse.setDiscription("Customer updated");
		}else {
			clientResponse.setStatusCode(401);
			clientResponse.setMessage("Failure");
			clientResponse.setDiscription("Email already exist");
		}
		return clientResponse;
	}
	@PostMapping(path = "/seeallcontracts", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponse viewAllContracts() {
		ContractResponse contractResponse=new ContractResponse();
		List<ContractBean> list=contractServices.getAllContract();
		if(list.isEmpty()) {
			contractResponse.setBeans(list);
			contractResponse.setStatusCode(200);
			contractResponse.setMessage("success");
			contractResponse.setDiscription("Customer updated");
		}else {
			contractResponse.setStatusCode(401);
			contractResponse.setMessage("Failure");
			contractResponse.setDiscription("Empty Sets");
		}
		return contractResponse;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping(path = "/registerhaulier", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HaulierResponse addHaulier(@RequestBody HaulierBean eBean) {
		HaulierResponse haulierResponse=new  HaulierResponse();
		
		if(haulierServices.addHaulier(eBean)) {
			haulierResponse.setStatusCode(200);
			haulierResponse.setMessage("success");
			haulierResponse.setDiscription("Customer registered");
}else {
			haulierResponse.setStatusCode(401);
			haulierResponse.setMessage("Failure");
			haulierResponse.setDiscription("Email already exist");
		}
		return haulierResponse;
	}
	
	@DeleteMapping(path = "/deletehaulier" ,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HaulierResponse deleteHaulier(@RequestParam("id") String id)
	{
		HaulierResponse haulierResponse=new  HaulierResponse();
		boolean b=haulierServices.deleteHaulier(id);
		if(b) {
			
			if(loginServices.deleteLoginCredentials(id)) {
			haulierResponse.setStatusCode(200);
			haulierResponse.setMessage("success");
			haulierResponse.setDiscription("Customer deleted");
		}}else {
			haulierResponse.setStatusCode(401);
			haulierResponse.setMessage("Failure");
			haulierResponse.setDiscription("Error");
		}
		return haulierResponse;
	}
	
	@GetMapping(path = "getallhaulier" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HaulierResponse findAllHaulier()
	{
	List<HaulierBean> list= haulierServices.seeAllHauliers();
	HaulierResponse haulierResponse=new HaulierResponse();
	if(!list.isEmpty()) {
		haulierResponse.setBeans(list);
		
	}else
	{
		haulierResponse.setStatusCode(401);
		haulierResponse.setMessage("Failure");
		haulierResponse.setDiscription("Error");
		
	}
	return haulierResponse;
	}

	
	
	
	
	
	
	
	
	
}
