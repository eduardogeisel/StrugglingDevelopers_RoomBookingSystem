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
<style>
.form-center {
  width: 100%;
  max-width: 1000px;
  padding: 15px;
  margin: auto;
}
</style>
</head>
<body>
	<h1>Sign up</h1>
<div class="form-center">
	<form:form action="${pageContext.request.contextPath}/register_sho_38/"
		cssClass="form-horizontal" method="post" modelAttribute="user_sho_38">
		<div class="invisible">
			<label for="user_id" class="col-md-3 controllabel">User ID</label>
			<div class="col-md-3">
				<form:input path="user_id" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="first_name" class="col-md-3 controllabel">First
				Name</label>
			<div class="col-md-3">
				<form:input path="first_name" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="last_name" class="col-md-3 controllabel">Last
				Name</label>
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
			<label for="contact_number" class="col-md-3 controllabel">Contact
				Number </label>
			<div class="col-md-3">
				<form:input path="contact_number" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-md-3 controllabel">Password
			</label>
			<div class="col-md-3">
				<form:input path="password" class="form-control" />
			</div>
		</div>

		<div class="form-group">
			<label for="user_type" class="col-md-3 control-label">User
				Type:</label>
			<div class="col-md-3">
				<form:radiobutton path="user_type" value="1" />
				Faculty
				<form:radiobutton path="user_type" value="2" />
				Student
				<form:errors path="user_type" style="color:red" />
			</div>
		</div>
		<div class="form-group">
			<!-- Button -->
			<div class="col-md-offset-3 col-md-9">
				<form:button cssClass="btn btn-primary">Sign Up</form:button>
			</div>
		</div>
	</form:form>
	</div>>
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
	<footer class="site-footer">
		<div class="container top-footer p-md-3 p-1">
			<div class="row">

				<div class="col-md-3  pl-4 pr-4">
					<h3>Important Links</h3>
					<a href="#">Privacy Policy</a><br> <a href="#">Youtube
						Link </a><br> <a href="#">GitHub </a><br> <a href="#">Project
						Board</a>
				</div>

				<div class="col-md-3  pl-4 pr-4">
					<h3>Our Services</h3>
					<a href="${pageContext.request.contextPath}/bookRoom/?id=${userId}">Room
						Booking </a><br>
				</div>

				<div class="col-md-3  pl-4 pr-4">
					<h3>Contact Us</h3>
					<a href="tel:+017781234567"><i class="fas fa-phone"></i> +(01)
						7781234567 </a><br> <a href="mailto:sdroombooking@gmail.com  "><i
						class="fas fa-envelope"></i> sdroombooking@gmail.com </a><br>

					<div class="embed-responsive embed-responsive-16by9">
						<iframe class="embed-responsive-item"
							src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d2606.9450694031175!2d-122.9138888!3d49.2016016!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x5485d93b3397eb9d%3A0xa9220611a8bbf0d1!2sAnvil%20Centre%20Office%20Tower!5e0!3m2!1sen!2sca!4v1607127667600!5m2!1sen!2sca"
							width="100%" height="300px" frameborder="0" style="border: 0"></iframe>
					</div>
				</div>
			</div>
		</div>
		>

		<div class="container-fluid bottom-footer pt-2">
			<div class="row">
				<div class="col-12 text-center">

					<p>Copyrights&copy;2020 - All rights reserved</p>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>