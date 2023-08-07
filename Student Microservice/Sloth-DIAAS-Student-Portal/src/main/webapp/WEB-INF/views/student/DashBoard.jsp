<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@page isELIgnored="false" %>
<!doctype html>
<html lang="en">

<head>
<title>Student DashBoard</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/styles2.css">
<meta name="robots" content="noindex, follow">
<body>
	<div class="wrapper d-flex align-items-stretch">
		<nav id="sidebar">
			<div class="p-4 pt-5">
			<c:if test="${avatar==null}">
					<a href="#" class="img logo rounded-circle mb-5"
					style="background-image: url(/img/logo.jpg);"></a>
			</c:if>
			<c:if test="${avatar!=null}">
					<a href="#" class="img logo rounded-circle mb-5"
					style="background-image: url(/img/${avatar});"></a>
			</c:if>
					
				<ul class="list-unstyled components mb-5">
					<li class="active"><a href="#homeSubmenu"
						data-toggle="collapse" aria-expanded="false"
						class="dropdown-toggle">Calendar</a>
						<ul class="collapse list-unstyled" id="homeSubmenu">
							<li><a href="/student/user/dashboard">Exam Schedule</a></li>
							<li><a href="/student/user/showAllSections">Available Exams</a></li>
						</ul></li>
					<li><a href="/student/user/transcripts">Transcripts</a></li>
					<li><a href="/student/user/info">Persona</a></li>
				</ul>
				<div class="footer">
					<p>
						Copyright &copy;
						<script>document.write(new Date().getFullYear());</script>
						All rights reserved | <i class="icon-heart" aria-hidden="true"></i>
						by <a href="#" target="_blank">slothstemp.edu</a>
					</p>
				</div>
			</div>
		</nav>

		<div id="content" class="p-4 p-md-5">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">
					<button type="button" id="sidebarCollapse" class="btn btn-primary">
						<i class="fa fa-bars"></i> <span class="sr-only">Toggle
							Menu</span>
					</button>
					<button class="btn btn-dark d-inline-block d-lg-none ml-auto"
						type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<i class="fa fa-bars"></i>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="nav navbar-nav ml-auto">
							<li class="nav-item active">
								<c:if test="${email==null}">
								 <a class="nav-link" href="#">@slothstempInstisute.edu.com</a>
								</c:if> 
								<c:if test="${email!=null}">
								 <a class="nav-link" href="#">${email}</a>
								</c:if>
							</li>
							<li class="nav-item"><a class="nav-link" href="/logout">Log
									Out</a></li>
						</ul>
					</div>
				</div>
			</nav>
			<div class="table-responsive">
				<table class="table">
					<tr>
						<th>#:</th>
						<th>course name:</th>
						<th>Date:</th>

					</tr>

					<c:forEach items="${sections}" var="section">
						<tr>
							<td>1</td>
							<td>${section.course_name}</td>
							<td>${section.time}</td>
							
							</td>
						</tr>

					</c:forEach>


				</table>
			</div>
		</div>
	</div>
	<script src="/js/jquery.min.js"></script>
	<script src="/js/popper.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/main.js"></script>
<!-- 	<script defer -->
<!-- 		src="https://static.cloudflareinsights.com/beacon.min.js/v2b4487d741ca48dcbadcaf954e159fc61680799950996" -->
<!-- 		integrity="sha512-D/jdE0CypeVxFadTejKGTzmwyV10c1pxZk/AqjJuZbaJwGMyNHY3q/mTPWqMUnFACfCTunhZUVcd4cV78dK1pQ==" -->
<!-- 		data-cf-beacon='{"rayId":"7b6acf5328f4cf9b","token":"cd0b4b3a733644fc843ef0b185f98241","version":"2023.3.0","si":100}' -->
<!-- 		crossorigin="anonymous"></script> -->
</body>

</html>
</html>