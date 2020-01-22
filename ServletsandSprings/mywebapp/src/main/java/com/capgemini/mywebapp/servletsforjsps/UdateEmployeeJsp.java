package com.capgemini.mywebapp.servletsforjsps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;
@WebServlet("/updateEmployee")
public class UdateEmployeeJsp extends HttpServlet {

	EmployeeService service=new EmployeeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	HttpSession session=req.getSession(false);
	if(session !=null)
	{
		int empId=Integer.parseInt(req.getParameter("empid"));
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		double salary=Double.parseDouble("salary");
		String designation=req.getParameter("designation");
		String password=req.getParameter("password");
		
		EmployeeInfoBean eib=new EmployeeInfoBean();
		eib.setAge(age);
		eib.setDesignation(designation);
		eib.setEmp_id(empId);
		eib.setName(name);
		eib.setPassword(password);
		eib.setSalary(salary);
		boolean isAdded=service.updateEmployee(eib);
		if(isAdded)
			
		{
			req.setAttribute("msg", "Employee Updated Successfully!!!!!!!");
		}
		else
		{
			req.setAttribute("msg", "Employee Not Updated!!!");
		}
		req.getRequestDispatcher("./updateEmpJsp.jsp").forward(req, resp);
	}//valid
	else
	{
		req.setAttribute("msg", "Please Login First");
		req.getRequestDispatcher("./loginForm").forward(req, resp);
	}//invalid
	
	
	
	
	
	
	}
	
}
