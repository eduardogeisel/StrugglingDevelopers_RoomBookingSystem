<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Rooms</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>

	<div class="container">
		<h1>Rooms</h1>
		<hr />
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
						href="${pageContext.request.contextPath}/bookRoom/?id=${user.user_id}">Book
							Room</a></li>
				</ul>
			</div>
		</nav>
		<h4>Choose an equipment to check which rooms have the equipment
			available.</h4>
		<div class="form-group">
			<form:form action="${pageContext.request.contextPath}/filterRooms/"
				cssClass="form-horizontal" method="post" modelAttribute="rooms">

				<!-- Select equipment to filter -->
				<label for="equipment" class="col-md-3 control-label">Filter
					with equipment</label>
				<select id="equipment" name="equipment">
					<!-- <option value="all">No Selection</option> -->
					<option value="camera" selected>Camera</option>
					<option value="projector">Projector</option>
					<option value="laptop">Laptop</option>
					<option value="scanner">Scanner</option>
					<option value="printer">Printer</option>
				</select>
				<input type="submit" value="Submit">
			</form:form>
		</div>
		<table class="table table-striped table-bordered">
			<tr>
				<td>Room Id</td>
				<td>Room Type</td>
				<td>Capacity</td>
				<td>Equipment</td>
			</tr>
			<c:forEach var="rooms" items="${rooms}">
				<tr>
					<td>${rooms.room_id}</td>
					<td>${rooms.room_type}</td>
					<td>${rooms.capacity}</td>
					<td>${rooms.equipment}</td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>