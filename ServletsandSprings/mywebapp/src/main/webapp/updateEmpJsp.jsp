<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page session="false" %>
    <%String msg=(String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4><a href="./home">HOME</a></h4>
	<fieldset>

		<legend>ADD EMPLOYEE</legend>
		<form action="./updateEmployee" method="post">
			<table>
<tr>

					<td>ENTER EMPID YOU WANT TO CHANGE</td>
					<td>:</td>
					<td><input type="number" name="empid" required></td>
				</tr>
				



			
				<tr>

					<td>ENTER YOUR NAME</td>
					<td>:</td>
					<td><input type="text" name="name" ></td>
				</tr>
				<tr>

					<td>ENTER SALARY</td>
					<td>:</td>
					<td><input type="number" name="salary" ></td>
				</tr>
				<tr>

					<td>ENTER AGE</td>
					<td>:</td>
					<td><input type="number" name="age" ></td>
				</tr>
				<tr>

					<td>ENTER DESIGNATION</td>
					<td>:</td>
					<td><input type="text" name="designation" ></td>
				</tr>
								<tr>
				<td>ENTER PASSWORD</td>
				<td>:</td>
				<td> <input type="password" name="password" ></td>
				</tr>

				<tr>

					<td colspan="3" align="center"><br> <input type="submit"
						value="Submit"></td>
				</tr>
			</table>

		</form>

	</fieldset>
	<%if(msg!=null && !msg.isEmpty()) {%>
	<h3 style ="color:red"><%=msg %></h3>
	
	<%} %>
	
</body>
</html>