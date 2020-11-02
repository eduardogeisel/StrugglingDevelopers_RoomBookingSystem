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
	
	<form:form action="${pageContext.request.contextPath}/register_sho_38/"
			cssClass="form-horizontal" method="post" modelAttribute="user_sho_38">
			<div class="invisible">
				<label for="user_id" class="col-md-3 controllabel">User ID</label>
				<div class="col-md-3">
					<form:input path="user_id" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="first_name" class="col-md-3 controllabel">First Name</label>
				<div class="col-md-3">
					<form:input path="first_name" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="last_name" class="col-md-3 controllabel">Last Name</label>
				<div class="col-md-3">
					<form:input path="last_name" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-md-3 controllabel">Email </label>
				<div class="col-md-3">
					<form:input path="email" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="address" class="col-md-3 controllabel">Address </label>
				<div class="col-md-3">
					<form:input path="address" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="contact_number" class="col-md-3 controllabel">Contact Number </label>
				<div class="col-md-3">
					<form:input path="contact_number" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-md-3 controllabel">Password </label>
				<div class="col-md-3">
					<form:input path="password" class="form-control" />
				</div>
			</div>
		
			<div class="form-group">
				<label for="user_type" class="col-md-3 control-label">User Type:</label>
				<div class="col-md-3">
					<form:radiobutton path="user_type" value="1" />Faculty <form:radiobutton
						path="user_type" value="2" />Student <form:errors path="user_type"
						style="color:red" />
				</div>
			</div>
			<div class="form-group">
				<!-- Button -->
				<div class="col-md-offset-3 col-md-9">
					<form:button cssClass="btn btn-primary">Sign Up</form:button>
				</div>
			</div>
		</form:form>
	<!-- 
	
	<form:form action="${pageContext.request.contextPath}/register_sho_38/"
		method="POST" modelAttribute="user_sho_38">
		<table>
			<tr>
				<td><label>User ID</label></td>
				<td><form:input type="number" path="user_id" id="user_id" />
					<form:errors path="user_id" style="color:red" /></td>
			</tr>
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
				<td colspan="2"><input type="submit" value="Sign Up"></td>
			</tr>
		</table>
	</form:form>
	
	
	 -->
</body>
</html>