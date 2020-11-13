<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Calendar</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/static/css/fullcalendar.main.css" />"
	rel='stylesheet' />
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/static/js/fullcalendar.main.js" />"></script>

<script>
	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');

		
		/*
		 * using jstl to access booking 
		 * object and get event data
		 */
		var events = [], eventObj;
		<c:forEach var="booking" items="${bookings}">
		eventObj = {
			title : '${booking.title}',
			start : '${booking.dateTime}' + 'T' + '${booking.startTime}',//combine dateTime and startTime to "2020-10-09T16:00:00" formate
			end : '${booking.dateTime}' + 'T' + '${booking.endTime}'//combine dateTime and startTime to "2020-10-09T16:00:00" formate
			
		};
		events.push(eventObj);
		</c:forEach>
		
		
		
		var calendar = new FullCalendar.Calendar(calendarEl, {
			initialView : 'dayGridMonth',
			headerToolbar : {
				right : 'prev,next today',
				center : 'title',
				left : 'dayGridMonth,timeGridWeek,timeGridDay'
			}, events});
		
		
		//create calendar
		calendar.render();
	});
</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 1100px;
	margin: 0 auto;
}
</style>
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
	<div id='calendar'></div>
</body>
</html>