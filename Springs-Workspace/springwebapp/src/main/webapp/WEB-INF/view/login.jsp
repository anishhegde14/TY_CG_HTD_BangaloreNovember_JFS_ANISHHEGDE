<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body>
	<h2>${msg}</h2>
	<fieldset>
		<form action="./login" method="post">
		<table>
			<tr>
				<td>Email</td>
				<td>:</td>
				<td><input type="text" name="email">
			</tr>
			<tr>
				<td>Password</td>
				<td>:</td>
				<td><input type="password" name="password">
			</tr>
			<tr>
				<td><input type="submit" value="login"></td>
			</tr>
			<tr>
				<td><a href="./register" style="color:red">Register Here</a></td>
			</tr>
			

		</table>


</form>
	</fieldset>
</body>
</html>