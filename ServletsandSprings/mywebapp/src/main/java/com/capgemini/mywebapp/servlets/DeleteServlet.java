package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;

@WebServlet("/deleteEmployee")
public class DeleteServlet extends HttpServlet{
	
	
	private EmployeeService es=new EmployeeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	HttpSession session=req.getSession(false);
	resp.setContentType("text/hmtl");
	PrintWriter out=resp.getWriter();
	out.println("<html>");
	out.println("<body>");
	
	if(session!=null) {
		
		
		Integer empid=Integer.parseInt(req.getParameter("empid"));
		if(es.deleteEmployee(empid))
		{
			out.println("<h3 style=color:red> EMPLOYEE"+empid+" DELETED</h3>");
		}
		else
		{
			out.println("<h3 style=color:red> EMPLOYEE\"+empid+\" NOT FOUND</h3><br>PLEASE RE-ENTER EMPID");
		}
		
		req.getRequestDispatcher("./DeleteEmployee.html").include(req, resp);;
	}
	else
	{
		out.println("<h3 style=color:red>You Have Been Logged out");
		req.getRequestDispatcher("./DeleteEmployee.html").include(req, resp);
	}
	
	
	out.println("</body>");
	out.println("</html>");
	}//end of doGet

}//end of class