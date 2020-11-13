<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Limitation (Admin)</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<h1>Booking Limitation Form (Admin)</h1>
		<hr/>		
		

		<form:form action="${pageContext.request.contextPath}/showBookings/?id=${userId}"
			cssClass="form-horizontal" method="post" modelAttribute="booking">
			
			<!-- title label field, for inputing booking limitation title -->			
			<div class="form-group">
				<label for="title" class="col-md-3 controllabel">Title:</label>
				<div class="col-md-3">
					<form:input path="title" class="form-control" />
				</div>
			</div>
				
				<!-- room id field, for inputing booking what room will be unavailable -->					
			<div class="form-group">
				<label for="room_id" class="col-md-3 controllabel">Room ID:</label>
				<div class="col-md-3">
					<form:input path="room_id" class="form-control" />
				</div>
			</div>
			
			<!-- description field, for inputing reason for booking limitation (maintenance...) -->
			<div class="form-group">
				<label for="description" class="col-md-3 controllabel">Description:</label>
				<div class="col-md-6">
					<textarea name = "description" class="form-control" id="description" rows="3"></textarea>
				</div>
			</div>

			<!-- date field, for inputing what date booking limitation will occur -->
			<div class="form-group">
				<label for="dateTime" class="col-2 col-form-label">Date:</label>
				<div class="col-6">
					<form:input type="date" 
						path="dateTime" id="dateTime" />
				</div>
			</div>
			
			<!-- start time field, for inputing what time will booking limitation occur -->
			<div class="invisible">
				
				<div class="col-6">
					<form:input class="form-control" type="time" value="00:00"
						id="startTime" path="startTime" />
				</div>
			</div>
			
			<!-- end time field, for inputing what time will booking limitation end -->
			<div class="invisible">
				
				<div class="col-6">
					<form:input class="form-control" type="time" value="23:59"
						id="endTime" path="endTime" />
				</div>
			</div>
			
			<div class="invisible">
				<div class="col-6">
					<form:input class="form-control" value="${userId}"  id="user_id"
						path="user_id" />
				</div>
			</div>
			
			<div class="invisible">
				<div class="col-6">
					<form:input class="form-control" value="${bookingId}" id="booking_id"
						path="booking_id" />
				</div>
			</div>

			<div class="form-group">
				<!-- Button for submitting booking limitation -->
				<div class="col-md-offset-3 col-md-9">
					<form:button class="btn btn-primary">Submit</form:button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>