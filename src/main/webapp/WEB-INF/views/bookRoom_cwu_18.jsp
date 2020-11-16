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
					href="${pageContext.request.contextPath}/showRooms/">Filter
						Room</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/bookingCalendar/?id=${userId}">Calendar</a></li>

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
					<form:input class="form-control"
						id="booking_id" path="booking_id" />
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
</html>