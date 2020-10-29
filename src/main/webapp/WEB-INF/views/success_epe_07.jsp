<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
</head>
<h1>${successMessage}</h1>
<body>
	<table>
		<tr>
			<td><label>email:</label></td>
			<td>${login.email}</td>
		</tr>
		<tr>
			<td><label>password:</label></td>
			<td>${login.password}</td>
		</tr>
		<tr>
			<td colspan="2"><a href="${pageContext.request.contextPath}/sessionEnd">Logout</a></td>
		</tr>

	</table>
	<!-- user session -->
	<h4>${user}</h4>
</body>
</html>