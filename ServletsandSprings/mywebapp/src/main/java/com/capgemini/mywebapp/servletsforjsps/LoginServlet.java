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
@WebServlet("/login2")
public class LoginServlet extends HttpServlet{

	private EmployeeService ser=new EmployeeServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		int empid=Integer.parseInt(req.getParameter("empid"));
		String password=req.getParameter("password");
		EmployeeInfoBean eib=ser.authenticate(empid, password);
		if(eib!=null)
		{
			//valid
			
			HttpSession session=req.getSession(true);
			session.setAttribute("eib", eib);
			
			session.setMaxInactiveInterval(60);
			req.getRequestDispatcher("homePageJsp.jsp").include(req, resp);
		}
		else
		{
			//invalid
			req.setAttribute("msg", "Invalid Credentials!!!");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		}
	
	
	}
}
