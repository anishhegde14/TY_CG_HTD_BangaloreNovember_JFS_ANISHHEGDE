package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	HttpSession session=req.getSession(false);
	PrintWriter out=resp.getWriter();
	out.println("<html>");
	out.println("<body>");

	if(session!=null) {
	session.invalidate();
	out.println("<h2 style=color:green>LOGGED OUT SUCCESSFULLY!!!</h2>");
	
	}
	else
	{
		out.println("<h2 style=color:green>ALREADY LOGGED OUT!!!</h2>");
	}
	out.println("</body>");	
	out.println("</html>");
		req.getRequestDispatcher("./LoginPage.html").include(req, resp);
	
	
	}

}
