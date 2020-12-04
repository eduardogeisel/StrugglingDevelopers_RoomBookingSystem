<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Group Description</title>

</head>
<body>
	<h1>Room Photos</h1>
	<table>
		<tr>
			<td><img src="<c:url value='/resources/${roomPhotos.imgSrc}'/>"
				alt="Room photo" width="250" height="300" /></td>
			<td>
		</tr>
		<tr>
			<td>Room photo</td>
		</tr>
	</table>
	<label for="txtGroup">Description:</label>
	<p id="txtGroup" name="txtGroup">Hello world</p>

</body>
</html>