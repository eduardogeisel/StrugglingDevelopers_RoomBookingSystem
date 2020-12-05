<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin View Comments</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="container">
		<h1>View Comments:</h1>
		<hr />
		<table class="table table-striped table-bordered">
			<tr>
				<td>Title</td>
				<td>Room ID</td>
				<td>Date</td>
				<td>Start Time</td>
				<td>End Time</td>
				
			</tr>
			<c:forEach var="comment" items="${comments}">
				<tr>
					<td>${comment.title}</td>
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