package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/readCookie")
public class ReadCookieServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	Cookie[] mycookie=req.getCookies();
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	req.getRequestDispatcher("./CookiePage.html").include(req, resp);
	out.println("<html>");
	out.println("<body>");
	if(mycookie==null)
	{
		out.println("<br><h2>No cookies Available!!!!</h2>");
	}
	for (Cookie cookie : mycookie) {
		out.println("<br>Cookie name is"+cookie.getName());
		out.println("<br>Cookie Value is"+cookie.getValue());
	}
	out.println("</html>");
	out.println("</body>");
	
	}
	
	
}