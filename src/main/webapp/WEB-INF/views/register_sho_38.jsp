<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Page</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>
	<h1>Sign up</h1>
	<form:form action="${pageContext.request.contextPath}/registerProcess/"
		method="POST" modelAttribute="user_sho_38">
		<table>
			<tr>
				<td><label>First Name</label></td>
				<td><form:input type="text" path="first_name" id="first_name" />
					<form:errors path="first_name" style="color:red" /></td>
			</tr>
			<tr>
				<td><label>Last Name</label></td>
				<td><form:input type="text" path="last_name" id="last_name" />
					<form:errors path="last_name" style="color:red" /></td>
			</tr>

			<tr>
				<td><label>Email</label></td>
				<td><form:input type="email" path="email" id="email" /> <form:errors
						path="email" style="color:red" /></td>
			</tr>
			<tr>
				<td><label>Address</label></td>
				<td><form:input type="text" path="address" id="address" /> <form:errors
						path="address" style="color:red" /></td>
			</tr>
			<tr>
				<td><label>Contact Number</label></td>
				<td><form:input type="text" path="contact_number"
						id="contact_number" /> <form:errors path="contact_number"
						style="color:red" /></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><form:input type="text" path="password" id="password" /> <form:errors
						path="password" style="color:red" /></td>
			</tr>
			<tr>
				<td><label>User type</label></td>
				<td><form:select path="user_type" id="user_type">
						<form:option value="">Select userType</form:option>
						<form:options items="${user_type}" />
					</form:select> <form:errors path="user_type" style="color:red" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Sign Up"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>