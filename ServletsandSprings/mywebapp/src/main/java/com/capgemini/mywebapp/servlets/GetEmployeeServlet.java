package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetEmployeeServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String idVal=req.getParameter("id");
	
	resp.setContentType("text/html");
	PrintWriter pr=resp.getWriter();
	pr.println("<html>");
	pr.println("<head>");
	pr.println("<body style=background color:red>");
	
	pr.println("Employee id="+idVal);
	pr.println("<br>EmpName=Anish<br>");
	pr.println("Salary=100000000");
	pr.println("</body>");
	pr.println("</html>");
	
	
	}
	
}
