package com.capgemini.retailer.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgemini.retailer.dto.UserInfoBean;
import com.capgemini.retailer.dto.UserResponse;
import com.capgemini.retailer.services.UserServices;

@Controller
public class UserController {

	@Autowired
	private UserServices services;
	
	
	@PostMapping(path="/login", produces =  MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public UserResponse Auth(@RequestBody UserInfoBean bean) {
		UserInfoBean user=services.auth(bean.getEmail(), bean.getPassword());
		UserResponse response=new UserResponse();
		if(user!=null) {
			response.setStatusCode(200);
			response.setDiscription("Logged In Successfully!!!");
			response.setMessage("User Credentials correct");
			response.setBeans(Arrays.asList(user));
			
		}
		else {
			response.setStatusCode(400);
			response.setDiscription("Error!!!");
			response.setMessage("User Credentials incorrect");
			
		}
		
		return response ;
		
		
		
	}
	
}
