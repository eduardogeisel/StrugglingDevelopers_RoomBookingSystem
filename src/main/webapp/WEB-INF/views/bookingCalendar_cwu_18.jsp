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
				left : 'dayGridMonth,timeGridWeek,timeGridDay' }, events});
		
		
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
	<section class="breadcrumbs-section">
		<div class="container pl-3 p-sm-3">
			<div class="row">
				<div class="col-12">
					<h2>Calendar</h2>
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a
							href="${pageContext.request.contextPath}/bookRoom/?id=${userId}">Home</a></li>
						<li class="breadcrumb-item active">Calendar</li>
					</ol>
				</div>
			</div>
		</div>

	</section>


	<div id='calendar'></div>
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