<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page session="false" %>
    <% String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
	<h2 style='color:red'><%if(msg!=null && !msg.isEmpty()){%>
	
<%=msg%>
<%} %>	
	</h2>
		<legend>Employee Login</legend>
		<form action="./login2" method="post">
			<table>
				<tr>

					<td>ID</td>
					<td>:</td>
					<td><input type="number" name="empid" required></td>
				</tr><tr>
				<td>Password</td>
				<td>:</td>
				<td> <input type="password" name="password" required></td>
				</tr>

				<tr>

					<td colspan="3" align="center"><br> <input type="submit"
						value="Login"></td>
				</tr>
			</table>

		</form>

	</fieldset>
</body>
</html>