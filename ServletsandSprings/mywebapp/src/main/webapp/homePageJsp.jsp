<%@page import="com.capgemini.mywebapp.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page session="false" %>
    <%HttpSession session=request.getSession(); %>
<%EmployeeInfoBean eib=(EmployeeInfoBean)session.getAttribute("eib"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style="color:navy">Welcome <%=eib.getName() %></h3>

<a href="./addEmp">Add Employee</a>
<a href="./updateEmpJsp">Update Employee</a>
<a href="./deleteEmpJsp">Delete Employee</a>
<a href="./getEmpJsp">Search Employee</a>
<a href="./seeAllEmployees">See all Employee</a>
<br>
<a href="./logout2">Logout</a>
</body>
</html>