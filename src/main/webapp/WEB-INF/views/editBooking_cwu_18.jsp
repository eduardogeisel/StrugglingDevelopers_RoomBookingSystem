<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Booking Room Request</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="container">
		<h1>Edit Booking Room Form</h1>
		<hr />
		<h3>Edit Booking</h3>

		<form:form action="${pageContext.request.contextPath}/editBooking/"
			cssClass="form-horizontal" method="post" modelAttribute="booking">
			<div class="form-group">
				<label for="title" class="col-md-3 controllabel">Title:</label>
				<div class="col-md-3">
					<form:select path="title" id="title">
						<form:option value="${booking.title}">Select Title</form:option>
						<form:options items="${title}" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label for="description" class="col-md-3 controllabel">Description:</label>
				<div class="col-md-6">
					<textarea value = "${booking.description}" class="form-control" id="description" rows="3"></textarea>
				</div>


			</div>
			<div class="form-group">
				<label for="room_id" class="col-md-3 controllabel">Room ID:</label>
				<div class="col-md-3">
					<form:input path="room_id" class="form-control" value = "${booking.room_id}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="dateTime" class="col-2 col-form-label">Date:</label>
				<div class="col-6">
					<form:input type="date" 
						path="dateTime" id="dateTime" value = "${booking.dateTime}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="startTime" class="col-2 col-form-label">Start Time:</label>
				<div class="col-6">
					<form:input class="form-control" type="time" 
						id="startTime" path="startTime" value = "${booking.startTime}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="endTime" class="col-2 col-form-label">End Time:</label>
				<div class="col-6">
					<form:input class="form-control" type="time" 
						id="endTime" path="endTime" value = "${booking.endTime}"/>
				</div>
			</div>
			<div class="invisible">
				<div class="col-6">
					<form:input class="form-control" value="${booking.user_id}"  id="user_id"
						path="user_id" />
				</div>
			</div>
			<div class="invisible">
				<div class="col-6">
					<form:input class="form-control" value="${booking.booking_id}" id="booking_id"
						path="booking_id" />
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