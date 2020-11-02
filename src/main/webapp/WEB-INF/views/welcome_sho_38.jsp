<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome Page</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<h1>Welcome</h1>
<body>
	<table>
		<tr>
			<td>Welcome  ${newUser.first_name}</td>
		</tr>

		<tr>
			<td><label>email:</label></td>
			<td>${newUser.email}</td>
		</tr>


	</table>
	<h4>${newUser}</h4>
</body>
</html>