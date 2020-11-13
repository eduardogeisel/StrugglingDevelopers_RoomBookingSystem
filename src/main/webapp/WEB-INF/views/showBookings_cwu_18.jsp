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

	<div class="container">
		<h1>Show Booking List for ${userName}</h1>
		<hr />
		<c:if test="${ deleteMessage !=null }">
			<div class="alert alert-danger" role="alert">${deleteMessage}</div>
		</c:if>
		<c:if test="${ editMessage !=null }">
			<div class="alert alert-success" role="alert">${editMessage}</div>
		</c:if>
		<table class="table table-striped table-bordered">
			<tr>
				<td>Title</td>
				<td>Room ID</td>
				<td>Date</td>
				<td>Start Time</td>
				<td>End Time</td>
				<!--
				 <td>Edit</td>
				 -->

				<td>Delete</td>
			</tr>
			<c:forEach var="booking" items="${bookings}">
				<tr>
					<td>${booking.title}</td>
					<td>${booking.room_id}</td>
					<td>${booking.dateTime}</td>
					<td>${booking.startTime}</td>
					<td>${booking.endTime}</td>

					<!-- <td><a
						href="${pageContext.request.contextPath}/editBooking/?id=${booking.booking_id}">Edit</a></td>
					
					-->
					<td><a
						href="${pageContext.request.contextPath}/deleteBooking/?id=${booking.booking_id}">Delete</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>