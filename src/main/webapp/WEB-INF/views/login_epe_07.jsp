<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">


<title>Login</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.1/examples/sign-in/">
<!-- Bootstrap core CSS -->
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="<c:url value="/static/css/signin.css" />" rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>

</head>
<body class="text-center">



	<form:form method="POST" class="form-signin"
		action="${pageContext.request.contextPath}/success_epe_07"
		modelAttribute="login_epe_07">

		<h1 class="h3 mb-3 font-weight-normal">Login</h1>
		<c:if test="${ failureMessage !=null }">
			<div class="alert alert-danger" role="alert">${failureMessage}</div>
		</c:if>
		<c:if test="${ successMessage !=null }">
			<div class="alert alert-success" role="alert">${successMessage}</div>
		</c:if>
		<form:input type="text" path="email" id="email"
			placeholder="Email address" class="form-control" required="true" />
		<form:errors path="email" style="color:red" />


		<form:input type="password" path="password" placeholder="Password"
			class="form-control" id="password" required="true" />
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
		<c:if test="${ message != null }">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		<p class="mt-5 mb-3 text-muted">&copy; 2020</p>
	</form:form>

</body>
</html>
