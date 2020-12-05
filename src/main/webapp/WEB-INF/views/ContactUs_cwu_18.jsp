<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Us</title>
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
					<h2>Contact Us</h2>
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a
							href="${pageContext.request.contextPath}/bookRoom/?id=${userId}">Home</a></li>
						<li class="breadcrumb-item active">Contact Us</li>
					</ol>
				</div>
			</div>
		</div>

	</section>

	<section>
		<div class="container">
			<div class="row">
				<div class="col-12">
					<p>We are willing to help you here. Leave your comments and your contact information. We will contact to you within 24 hours.</p>
					<hr />
				</div>
			</div>
		</div>
	</section>


	<section class="form-section">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<form action="${pageContext.request.contextPath}/comment/?id=${userId}" method="post">
						<div class="form-row">
							<div class="form-group col-md-6">
								<input type="text" class="form-control"
									placeholder="Full name *">

							</div>
							<div class="form-group col-md-6">
								<input type="email" class="form-control"
									placeholder="Email Address *">
							</div>
						</div>

						<div class="form-row">
							<div class="form-group col-md-6">
								<input type="number" class="form-control"
									placeholder="Contact Number *">

							</div>
							<div class="form-group col-md-6">
								<select class="form-control">
									<option selected>Country</option>
									<option>India</option>
									<option>America</option>
									<option>England</option>
									<option>China</option>
								</select>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-12">
								<input type="text" class="form-control" placeholder="Subject *">
							</div>
						</div>
						
						<div class="form-row">
							<div class="form-group col-md-12">
								<textarea class="form-control" rows="3" id="content" name="content" required></textarea>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-12 invisible">
								<input type="number" class="form-control" placeholder="user_id" id="${userId}" value="${userId}">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-12 text-center">
								<button type="submit" class="btn btn-primary">
									<i class="fas fa-paper-plane"></i> Send Message
								</button>
							</div>
						</div>

					</form>

				</div>

				<div class="col-md-6 container-fluid ">
				<div class="col-md-6 address">
					<h3>Visit Us</h3>
					<div class="embed-responsive embed-responsive-16by9">
						<iframe class="embed-responsive-item"
							src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d2606.9450694031175!2d-122.9138888!3d49.2016016!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x5485d93b3397eb9d%3A0xa9220611a8bbf0d1!2sAnvil%20Centre%20Office%20Tower!5e0!3m2!1sen!2sca!4v1607127667600!5m2!1sen!2sca"
							width="50%" height="300px" frameborder="0" style="border: 0"></iframe>
					</div>
					</div>
					<div class="col-md-6 address">
					<h5>Call Us</h5>
					<p>
						<a href="tel:+017781234567"><i class="fas fa-phone"></i> +(01)
							7781234567 </a><br>
					</p>
					</div>
					<div class="col-md-6 address">
					<h5>Email</h5>
					<p>
						<a href="mailto:sdroombooking@gmail.com"><i
							class="fas fa-envelope"></i> sdroombooking@gmail.com</a><br>

					</p>
					</div>
					
					<h5>Working hours</h5>
					<p>Mon - Fri : 8:30am - 5:30pm(GMT-8)</p>
					<h5>Address</h5>
					<p>700 Royal Avenue New Westminster, BC V3M 5Z5</p>
				</div>
			</div>
		</div>
	</section>


	<footer class="full-footer">
		<div class="container top-footer p-md-3 p-1">
			<div class="row">

				<div class="col-md-3  pl-4 pr-4">
					<h3>Important Links</h3>
					<a href="#">Privacy Policy</a><br> <a href="#">Youtube
						Link </a><br> 
						<a href="#">GitHub </a><br> 
						<a href="#">Project Board</a>
				</div>

				<div class="col-md-3  pl-4 pr-4">
					<h3>Our Services</h3>
					<a href="${pageContext.request.contextPath}/bookRoom/?id=${userId}">Room Booking </a><br> 
				</div>

				<div class="col-md-3  pl-4 pr-4">
					<h3>Contact Us</h3>
					<a href="tel:+017781234567"><i class="fas fa-phone"></i> +(01)
						7781234567 </a><br> <a href="mailto:sdroombooking@gmail.com  "><i
						class="fas fa-envelope"></i> sdroombooking@gmail.com </a><br>

					<div class="embed-responsive embed-responsive-16by9">
						<iframe class="embed-responsive-item"
							src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d2606.9450694031175!2d-122.9138888!3d49.2016016!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x5485d93b3397eb9d%3A0xa9220611a8bbf0d1!2sAnvil%20Centre%20Office%20Tower!5e0!3m2!1sen!2sca!4v1607127667600!5m2!1sen!2sca"
							width="100%" height="300px" frameborder="0" style="border: 0"></iframe>
					</div>
				</div>
			</div>
</div>>

			<div class="container-fluid bottom-footer pt-2">
				<div class="row">
					<div class="col-12 text-center">
					
						<p>Copyrights&copy;2020 - All rights reserved</p>
					</div>
				</div>
			</div>
	</footer>
</body>
</html>