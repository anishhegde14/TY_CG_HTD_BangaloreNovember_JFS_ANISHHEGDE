<%@page import="com.capgemini.mywebapp.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page session="false" %>
    <% String msg=(String)request.getAttribute("msg"); %>
        <% String msg1=(String)request.getAttribute("msg"); %>
     <%HttpSession session=request.getSession(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Employee</title>
</head>
<body>
<fieldset>
<legend>Delete Employee</legend>
<form action="./deleteEmployeeJsp" method="get">
Employee ID:<input type="number" name="empid" required><br>
<input type="submit" value="delete">

</form>
<%if(msg!=null && !msg.isEmpty() || msg1!=null && !msg1.isEmpty()){ %>
<%if(session!=null){ %>
<h3 style="color:green">
                 <%=msg %>                     </h3>         
<% } else{ %>
<h3 style="color:green"></h3>
<%=msg1 %>                               <%} }%>
</fieldset>
</body>
</html>