<%@page import="com.capgemini.mywebapp.bean.EmployeeInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page session="false" %>
    <% List<EmployeeInfoBean> l1=(List<EmployeeInfoBean>)request.getAttribute("l1"); %>
    <%String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3><a href="./home">HOME</a></h3>

<%if(!l1.isEmpty() && l1!=null) {%>
<table>
  <tr>
    <th>Employee ID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Salary</th>
    <th>Designation</th>
  </tr>
  
  <%for(EmployeeInfoBean eib:l1){ %>
  <tr>
    <td><%=eib.getEmp_id()%></td>
    <td><%=eib.getName()%></td>
    <td><%=eib.getAge()%></td>
    <td><%=eib.getSalary()%></td>
    <td><%=eib.getDesignation()%></td>
  </tr>
<%} %>
</table>



<%}if(msg!=null && !msg.isEmpty()){ %>
<h3 style="color:red"><%=msg %></h3>

<%} %>


</body>
</html>