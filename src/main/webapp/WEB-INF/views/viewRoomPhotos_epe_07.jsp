<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Room Photos</title>

</head>
<body>
	<h1>Room Photos</h1><BR>
	<h3>There are four types of rooms offered for students and faculty to book. They are regular classrooms, conference rooms, labs and study rooms.</h3>
	<table>
		<tr>
			<td><img src="<c:url value='/resources/${roomPhotos.regularClassroom}'/>"
				alt="Regular classroom photo" width="800" height="600" /></td>
			<td>
		</tr>
		<tr>
			<td>Classroom photo</td>
		</tr>
	</table>
	
	<p id="txtGroup" name="txtGroup">The regular classrooms are the most common rooms that can be booked. Each classroom has a difference in equipments that they offer, but the layout looks pretty much like the picture above.</p>
	
	<table>
		<tr>
			<td><img src="<c:url value='/resources/${roomPhotos.conference}'/>"
				alt="Conference room photo" width="800" height="600" /></td>
			<td>
		</tr>
		<tr>
			<td>Conference room photo</td>
		</tr>
	</table>
	
	<table>
		<tr>
			<td><img src="<c:url value='/resources/${roomPhotos.lab}'/>"
				alt="Lab room photo" width="800" height="600" /></td>
			<td>
		</tr>
		<tr>
			<td>Lab room photo</td>
		</tr>
	</table>
	
	<table>
		<tr>
			<td><img src="<c:url value='/resources/${roomPhotos.studyRoom}'/>"
				alt="Study room photo" width="800" height="500" /></td>
			<td>
		</tr>
		<tr>
			<td>Study room photo</td>
		</tr>
	</table>

</body>
</html>