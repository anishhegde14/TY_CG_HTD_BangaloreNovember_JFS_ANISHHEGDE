package com.capgemini.springwebapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.capgemini.springwebapp.beans.EmployeeBean;
import com.capgemini.springwebapp.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@GetMapping("login")
	public String login()
	{
		return "login";
	}
	@PostMapping("login")
	public String login(String email,String password,ModelMap map,HttpServletRequest req)
	{
		EmployeeBean bean=service.auth(email, password);
		if(bean==null)
		{	
			map.addAttribute("msg", "InValid Credentials");
			return "login";
		}
		HttpSession session=req.getSession();
		session.setAttribute("bean", bean);
		return "home";
	}
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	@PostMapping("/register")
	public String register(EmployeeBean bean,ModelMap map)
	{
		boolean check=service.addEmployee(bean);
		if(check)
		{
			map.addAttribute("msg","Registeration Successfull!!!");
		}
		else
		{
			map.addAttribute("msg", "This Email Id Already Exists!!!");
		}
		return "login";
	}
	@GetMapping("/search")
	public String search(@RequestParam("key")String key,ModelMap map,@SessionAttribute(name="bean",required=false)EmployeeBean bean)
	{
		List<EmployeeBean> list=service.getEmployees(key);
		map.addAttribute("list",list);
		return "home";
	}
	@PostMapping("/home")
	public String home(@SessionAttribute(name="bean",required=false)EmployeeBean bean)
	{	if(bean!=null)
		return "changepassword";
	else
		return "home";
	}
	@GetMapping("/changepassword")
	public String changePassword(@SessionAttribute(name="bean",required=false)EmployeeBean bean)
	{
		if(bean!=null)
			return "changepassword";
		else
			return "login";
	}
	@PostMapping("/changepassword")
	public  String changePassword(String password,@SessionAttribute("bean")EmployeeBean bean)
	{
		service .changePassword(bean.getId(), password);
		return "home";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "login";
	}

}
