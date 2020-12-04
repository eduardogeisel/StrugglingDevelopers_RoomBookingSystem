<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
      <a class="navbar-brand" href="#">JA</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
         aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
         <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
         <ul class="navbar-nav mr-auto">
            <li class="nav-item ml-5 active"><a class="nav-link" href="#">Home <span class="sr-only"></span></a></li>
            <li class="nav-item ml-5"><a class="nav-link " href="#">About Us<span class="sr-only"></span></a></li>
             <li class="nav-item ml-5"><a class="nav-link" href="#">Contact<span class="sr-only"></span></a></li>
         </ul> 
        </div>
   </nav>
<div class="container border" style="border:2px solid gray;">
<h2 id="head"> You Are Welcome User </h2>
 <img alt="logo" class="img-responsive mt-5" src="<spring:url value="/images/regular_classroom.jpg"/>" width="200">

</div>
</body>
</html>