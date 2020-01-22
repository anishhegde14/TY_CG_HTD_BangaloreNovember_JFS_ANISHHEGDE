package com.capgemini.mywebapp.servletsforjsps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;




@WebServlet("/deleteEmployeeJsp")
public class DeleteEmployeeJsp extends HttpServlet {
	
private EmployeeService s=new EmployeeServiceImpl();	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	HttpSession session=req.getSession(false);
	if(session!=null)
	{
		int empid=Integer.parseInt(req.getParameter("empid"));
		boolean status=s.deleteEmployee(empid);
		if(status==true)
		{
			req.setAttribute("msg", "Employee Deleted Successfully!!!!");
			
		}
		else
		{
			req.setAttribute("msg", "Employee Not Found!!!!");
		}
		req.getRequestDispatcher("./deleteEmployeeJsp").forward(req, resp);
	}else
		{
			req.setAttribute("msg1", "Please Login First");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		}
		
	}
	
	
	}


