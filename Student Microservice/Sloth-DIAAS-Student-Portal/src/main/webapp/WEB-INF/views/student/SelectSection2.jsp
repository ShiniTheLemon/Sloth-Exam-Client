<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@page isELIgnored="false" %>
<!doctype html>
<html lang="en">

<head>
<title>Student Section 2</title>
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
<!-- 		<nav id="sidebar"> -->
<!-- 			<div class="p-4 pt-5"> -->
<%-- 			<c:if test=""> --%>
<!-- 					<a href="#" class="img logo rounded-circle mb-5" -->
<!-- 					style="background-image: url(/img/logo.jpg);"></a> -->
<%-- 			</c:if> --%>
<%-- 			<c:if test=""> --%>
<!-- 					<a href="#" class="img logo rounded-circle mb-5" -->
<!-- 					style="background-image: url(/img/);"></a> -->
<%-- 			</c:if> --%>
					
<!-- 				<ul class="list-unstyled components mb-5"> -->
<!-- 					<li class="active"><a href="#homeSubmenu" -->
<!-- 						data-toggle="collapse" aria-expanded="false" -->
<!-- 						class="dropdown-toggle">Calendar</a> -->
<!-- 						<ul class="collapse list-unstyled" id="homeSubmenu"> -->
<!-- 							<li><a href="">Exam Schedule</a></li> -->
<!-- 							<li><a href="">Available Exams</a></li> -->
<!-- 						</ul></li> -->
<!-- 					<li><a href="">Transcripts</a></li> -->
<!-- 					<li><a href="#">Persona</a></li> -->
<!-- 				</ul> -->
<!-- 				<div class="footer"> -->
<!-- 					<p> -->
<!-- 						Copyright &copy; -->
<!-- 						<script>document.write(new Date().getFullYear());</script> -->
<!-- 						All rights reserved | <i class="icon-heart" aria-hidden="true"></i> -->
<!-- 						by <a href="#" target="_blank">slothstemp.edu</a> -->
<!-- 					</p> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</nav> -->

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
							<li class="nav-item active"><a class="nav-link" href="#">shinigami@gmail.com</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="#">Log
									Out</a></li>
						</ul>
					</div>
				</div>
			</nav>
			<div class="container">
				<div class="row">
					<div class="col-sm">

						<div class="card" style="width: 18rem;">
							<img class="card-img-top" src="/img/A.jpg" alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title">Section A</h5>
								<p class="card-text">This sections comprises of multiple
									choice questions.You are required to spend a maximum of 30
									minutes on this section,then it will get locked automatically.</p>
								<a href="/student/user/showSectionA?exam_code=${sections.section1}"
									class="disabled2">Select</a>
							</div>
						</div>
					</div>


					<div class="col-sm">

						<div class="card" style="width: 18rem;">
							<img class="card-img-top" src="/img/B.jpg" alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title">Section B</h5>
								<p class="card-text">This section is made up of short essay
									questions.You are allocated a maximum of 45 minutes before the
									sections gets locked automatically.</p>
								<a href="/student/user/showSectionB?exam_code=${sections.section2}"
									>Select</a>
							</div>
						</div>


					</div>


					<div class="col-sm">

						<div class="card" style="width: 18rem;">
							<img class="card-img-top" src="/img/C.jpg" alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title">Section C</h5>
								<p class="card-text">This is the last section,it has essay
									questions. You are allowed to spend 25 minutes, then the exam
									will end. GOOD LUCK!</p>
								<a href="/student/user/showSectionC?exam_code=${sections.section3}"
									class="disabled" class="btn btn-primary">Select</a>
							</div>
						</div>

					</div>
				</div>
			</div>
		
		</div>
	</div>
	<script src="/js/jquery.min.js"></script>
	<script src="/js/popper.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/main.js"></script>
	<script type="text/javascript">
		const disable = document.querySelector('.disabled');
		const disable2 = document.querySelector('.disabled2');
		disable2.href="javascript:alert('Sorry This section Is locked!')";
		disable.href="javascript:alert('Sorry This section Is locked!')";
	</script>
<!-- 	<script defer -->
<!-- 		src="https://static.cloudflareinsights.com/beacon.min.js/v2b4487d741ca48dcbadcaf954e159fc61680799950996" -->
<!-- 		integrity="sha512-D/jdE0CypeVxFadTejKGTzmwyV10c1pxZk/AqjJuZbaJwGMyNHY3q/mTPWqMUnFACfCTunhZUVcd4cV78dK1pQ==" -->
<!-- 		data-cf-beacon='{"rayId":"7b6acf5328f4cf9b","token":"cd0b4b3a733644fc843ef0b185f98241","version":"2023.3.0","si":100}' -->
<!-- 		crossorigin="anonymous"></script> -->
</body>

</html>
