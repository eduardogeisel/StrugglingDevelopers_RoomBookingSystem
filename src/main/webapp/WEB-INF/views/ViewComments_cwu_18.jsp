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
				<td>Comment ID</td>
				<td>Comments</td>
				<td>User ID</td>

				
			</tr>
			<c:forEach var="comment" items="${comments}">
				<tr>
					<td>${comment.comment_id}</td>
					<td>${comment.content}</td>
					<td>${comment.user_id}</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>