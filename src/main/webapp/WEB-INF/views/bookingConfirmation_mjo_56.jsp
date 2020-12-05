<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Room Booking Records</title>
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
					href="${pageContext.request.contextPath}/showRooms/">Filter
						Room</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/bookingCalendar/?id=${userId}">Calendar</a></li>

			</ul>
		</div>
	</nav>

	<form:form
		action="${pageContext.request.contextPath}/inputEmail/?id=${userId}"
		cssClass="form-horizontal" method="get" modelAttribute="booking">
		<div class="form-group">
			<h1>Show Booking Confirmation</h1>
			<hr />
			<table class="table table-striped table-bordered">

				<tr>
					<td>Room ID</td>
					<td>Booking ID</td>
					<td>User ID</td>
					<td>Date</td>
					<td>Start Time</td>
					<td>End Time</td>
					<td>Title</td>
				</tr>

				<tr>
					<td>${confirmation.room_id}</td>
					<td>${confirmation.booking_id}</td>
					<td>${confirmation.user_id}</td>
					<td>${confirmation.dateTime}</td>
					<td>${confirmation.startTime}</td>
					<td>${confirmation.endTime}</td>
					<td>${confirmation.title}</td>
				</tr>
			</table>

			<div class="col-md-offset-3 col-md-9">
				<form:button class="btn btn-primary" onclick="window.print()">Download Booking
					Confirmation</form:button>
			</div>
			<div class="col-md-offset-3 col-md-9">
				<form:button class="btn btn-primary">Send Email</form:button>
			</div>
		</div>
	</form:form>
</body>
</html>