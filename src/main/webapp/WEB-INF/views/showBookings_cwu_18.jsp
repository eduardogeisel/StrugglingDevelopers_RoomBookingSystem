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
		<div class="container">
		<h1>Show Booking List for ${userName}</h1>
		<hr />
		<table class="table table-striped table-bordered">
		<tr>
				<td>Title</td>
				<td>Room ID</td>
				<td>Date</td>
				<td>Start Time</td>
				<td>End Time</td>
				<!--<td>Edit</td>
				<td>Delete</td>-->
			</tr>
			<c:forEach var="booking" items="${bookings}">
				<tr>
					<td>${booking.title}</td>
					<td>${booking.room_id}</td>
					<td>${booking.dateTime}</td>
					<td>${booking.startTime}</td>
					<td>${booking.endTime}</td>
					<!--
					<td><a
						href="${pageContext.request.contextPath}/editBooking/?id=${booking.booking_id}">Edit</a></td>
					<td><a
						href="${pageContext.request.contextPath}/deleteBooking/?id=${booking.booking_id}">Delete</a></td>
					-->
				</tr>
			</c:forEach>
			
		</table>
</body>
</html>