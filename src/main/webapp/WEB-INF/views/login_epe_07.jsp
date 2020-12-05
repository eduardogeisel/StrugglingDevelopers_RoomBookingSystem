<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/static/css/signin.css" />" rel="stylesheet">
<script
	src="chrome-extension://mooikfkahbdckldjjndioackbalphokd/assets/prompt.js"></script>
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>

</head>
<body class="text-center">



	<hr />
	<c:if test="${ failureMessage !=null }">
		<div class="alert alert-danger" role="alert">${failureMessage}</div>
	</c:if>
	<c:if test="${ successMessage !=null }">
		<div class="alert alert-success" role="alert">${successMessage}</div>
	</c:if>
	<form:form method="POST" class="form-signin"
		action="${pageContext.request.contextPath}/success_epe_07"
		modelAttribute="login_epe_07">

		<h1 class="h3 mb-3 font-weight-normal">Login</h1>
		<form:input type="text" path="email" id="email"
			placeholder="Email address" class="form-control" required="" />
		<form:errors path="email" style="color:red" />


		<form:input type="password" path="password" placeholder="Password"
			class="form-control" id="password" required="" />
		<form:errors path="email" style="color:red" />
		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me">
				Remember me
			</label>
		</div>


		<button class="btn btn-lg btn-primary btn-block" type="submit">
			Sign in</button>


		<a href="${pageContext.request.contextPath}/register_sho_38/">Don't
			have an account?</a>
		<p class="mt-5 mb-3 text-muted">&copy; 2020</p>
	</form:form>
	<c:if test="${ message != null }">
		<div class="alert alert-success" role="alert">${message}</div>
	</c:if>
</body>
</html>
