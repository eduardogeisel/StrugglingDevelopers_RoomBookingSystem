<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Room</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Book Room System</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">

				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/showBookings/?id=${userId}">Show
						Bookings</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/bookRoom/?id=${userId}">Book
						Room</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/showRooms/?id=${userId}">Filter
						Room</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/bookingCalendar/?id=${userId}">Calendar</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/contactus/?id=${userId}">Contact
						Us</a></li>

			</ul>
		</div>
	</nav>

	<div class="container">
		<h1>Booking Room Form</h1>
		<hr />

		<!-- **************MJ*************** Changed below id to booking id and passed to confirm booking -->

		<form:form
			action="${pageContext.request.contextPath}/confirmBooking/?id=${userId}"
			cssClass="form-horizontal" method="post" modelAttribute="booking">
			<div class="form-group">
				<label for="title" class="col-md-3 controllabel">Title:</label>
				<div class="col-md-3">
					<form:select path="title" id="title">
						<form:option value="">Select Title</form:option>
						<form:options items="${title}" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label for="description" class="col-md-3 controllabel">Description:</label>
				<div class="col-md-6">
					<textarea name="description" class="form-control" id="description"
						rows="3"></textarea>
				</div>


			</div>
			<div class="form-group">
				<label for="room_id" class="col-md-3 controllabel">Room ID:</label>
				<div class="col-md-3">
					<form:input path="room_id" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="dateTime" class="col-2 col-form-label">Date:</label>
				<div class="col-6">
					<form:input type="date" path="dateTime" id="dateTime" />
				</div>
			</div>
			<div class="form-group">
				<label for="startTime" class="col-2 col-form-label">Start
					Time:</label>
				<div class="col-6">
					<form:input class="form-control" type="time" id="startTime"
						path="startTime" />
				</div>
			</div>
			<div class="form-group">
				<label for="endTime" class="col-2 col-form-label">End Time:</label>
				<div class="col-6">
					<form:input class="form-control" type="time" id="endTime"
						path="endTime" />
				</div>
			</div>
			<div class="invisible">
				<div class="col-6">
					<form:input class="form-control" value="${userId}" id="user_id"
						path="user_id" />
				</div>
			</div>
			<div class="invisible">
				<div class="col-6">
					<form:input class="form-control" id="booking_id" path="booking_id" />
				</div>
			</div>

			<div class="form-group">
				<!-- Button -->
				<div class="col-md-offset-3 col-md-9">
					<form:button class="btn btn-primary">Submit</form:button>
				</div>
			</div>
		</form:form>
	</div>
</body>
<footer class="site-footer">
	<div class="container top-footer p-md-3 p-1">
		<div class="row">

			<div class="col-md-3  pl-4 pr-4">
				<h3>Important Links</h3>
				<a href="#">Privacy Policy</a><br> <a href="#">Youtube Link
				</a><br> <a href="#">GitHub </a><br> <a href="#">Project
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
	

	<div class="container-fluid bottom-footer pt-2">
		<div class="row">
			<div class="col-12 text-center">

				<p>Copyrights&copy;2020 - All rights reserved</p>
			</div>
		</div>
	</div>
</footer>
</html>