<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submit The Form</title>
</head>
<body>
<h2>${name}</h2>
<h2>${email}</h2>
<h2>${password}</h2>
<h2>${gender}</h2>
<form action="./form" method="POST">

<table>
<tr>
<td>Name:</td>
<td> <input type="text" name="name">
</td>

</tr>
<tr>
<td>Email:</td>
<td> <input type="text" name="email">
</td>

</tr>
<tr>
<td>Password:</td>
<td> <input type="password" name="password">
</td>

</tr>
<tr>
<td>Gender:</td>
<td> M<input type="radio" name="gender" value="M">
</td>
<td> F<input type="radio" name="gender" value="F">
</td>

</tr>
<tr>

<td> <input type="reset" value="RESET">
</td>
<td><input type="submit" value="SUBMIT">
</td>

</tr>


</table>



</form>



</body>
</html>