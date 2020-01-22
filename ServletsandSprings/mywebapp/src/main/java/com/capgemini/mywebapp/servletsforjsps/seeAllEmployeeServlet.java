package com.capgemini.mywebapp.servletsforjsps;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;
@WebServlet("/seeAllEmployees")
public class seeAllEmployeeServlet extends HttpServlet {

	EmployeeService s=new EmployeeServiceImpl();
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	HttpSession session=req.getSession(false);
	if(session!=null)
	{
		List<EmployeeInfoBean> l1=s.getAllEmployees();
		if(l1!=null && !l1.isEmpty())
		{
			
			req.setAttribute("l1", l1);
		}
		else
		{
			req.setAttribute("msg", "No Records Present!!!");
		}
		req.getRequestDispatcher("./seeAllEmployeesJsp.jsp").forward(req, resp);
	}
	else {
		req.setAttribute("msg", "Please Login First!!");
		req.getRequestDispatcher("./loginForm").include(req, resp);
	}
	}
}
