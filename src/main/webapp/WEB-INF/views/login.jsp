<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form:form method="POST" action="${pageContext.request.contextPath}/success_epe_07/" modelAttribute="login">
		<table>
			<tr>
				<td><label>Email</label></td>
				<td><form:input type="text" path="email" id="email" />
					<form:errors path="email" style="color:red" /></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><form:input type="text" path="password" id="password" />
					<form:errors path="email" style="color:red" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Submit"></td>
			</tr>
				
		</table>
	</form:form>
	<c:if test="${ message != null }" >
				<div class="alert alert-success" role="alert">${message}</div>
			 </c:if>	
</body>
</html>
