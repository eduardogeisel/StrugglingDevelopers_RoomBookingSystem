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



	<section class="breadcrumbs-section">
		<div class="container pl-3 p-sm-3">
			<div class="row">
				<div class="col-12">
					<h2>Rooms</h2>
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a
							href="${pageContext.request.contextPath}/bookRoom/?id=${userId}">Home</a></li>
						<li class="breadcrumb-item active">Calendar</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	<div class="container">
		<h4>Choose an equipment to check which rooms have the equipment
			available.</h4>
		<div class="form-group">
			<form:form
				action="${pageContext.request.contextPath}/filterRooms/?id=${userId}"
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