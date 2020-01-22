package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	public EmployeeService service=new EmployeeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String empIdVal=req.getParameter("empid");
		String password=req.getParameter("password");
		Integer emp_id=Integer.parseInt(empIdVal);
		EmployeeInfoBean eib=service.authenticate(emp_id, password);
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (eib!=null) {//valid
			HttpSession session=req.getSession(true);

			session.setAttribute("EmployeeInfoBean", eib);
			out.println("<h1 style='color:blue'>Welcome "+eib.getName()+"</h1>");
			out.println("<br><a href='./AddEmployee.html'>ADD EMPLOYEE</a>");
			out.println("<br><a href='#'>UPDATE EMPLOYEE</a>");
			out.println("<br><a href='./searchEmpForm.html'>SEARCH EMPLOYEE</a>");
			out.println("<br><a href='./DeleteEmployee.html'>DELETE EMPLOYEE</a>");
			out.println("<br><a href='#'>GET ALL EMPLOYEE</a>");
			out.println("<br><br><a href='./logout'>LOGOUT</a>");

		} else {
			out.println("<h3 style='color:red'>Invalid Credentials!!!!</h3>");
			req.getRequestDispatcher("./LoginPage.html").include(req, resp);


		}
		out.println("</body>");
		out.println("</html>");
	}//end of dopost
}//end of classloginServ
