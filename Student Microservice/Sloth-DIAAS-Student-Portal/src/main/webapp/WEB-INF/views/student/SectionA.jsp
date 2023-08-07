<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@page isELIgnored="false" %>
<!doctype html>
<html lang="en">

<head>
<title>Student Section A</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/styles2.css">
<meta name="robots" content="noindex, follow">
<body onbeforeunload="return myFunction()">
	<div class="wrapper d-flex align-items-stretch">
<!-- 		<nav id="sidebar"> -->
<!-- 			<div class="p-4 pt-5"> -->
<%-- 			<c:if test="${info.avatar==null}"> --%>
<!-- 					<a href="#" class="img logo rounded-circle mb-5" -->
<!-- 					style="background-image: url(/img/logo.jpg);"></a> -->
<%-- 			</c:if> --%>
<%-- 			<c:if test="${info.avatar!=null}"> --%>
<!-- 					<a href="#" class="img logo rounded-circle mb-5" -->
<%-- 					style="background-image: url(/img/${info.avatar });"></a> --%>
<%-- 			</c:if> --%>
					
<!-- 				<ul class="list-unstyled components mb-5"> -->
<!-- 					<li class="active"><a href="#homeSubmenu" -->
<!-- 						data-toggle="collapse" aria-expanded="false" -->
<!-- 						class="dropdown-toggle">Question Banks</a> -->
<!-- 						<ul class="collapse list-unstyled" id="homeSubmenu"> -->
<!-- 							<li><a href="/faculty/MultipleChoice">Create Special Question Bank</a></li> -->
<!-- 							<li><a href="/faculty">Create Ordinary Question Bank</a></li> -->
<!-- 							<li><a href="/faculty/showExamCodes">Manage Question Bank</a></li> -->
<!-- 						</ul></li> -->
<!-- 					<li><a href="#">Persona</a></li> -->
<!-- 					<li><a href="#pageSubmenu" data-toggle="collapse" -->
<!-- 						aria-expanded="false" class="dropdown-toggle">Grade Papers</a> -->
<!-- 						<ul class="collapse list-unstyled" id="pageSubmenu"> -->
<!-- 							<li><a href="/faculty/showSections">Completed Exams</a></li> -->
<!-- 						</ul></li> -->
<!-- 					<li><a href="/faculty/showCourses">Student Transcripts</a></li> -->
<!-- 					<li><a href="#">Contact</a></li> -->
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



	  <p id="timer" style="  text-align: center; font-size: 60px;margin-top: 0px;"></p>

  

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
			<div  id="answers">
	<form action="/student/user/submitAnswersA" method="post">
	

	
				
	<table class="table" class="form-control">
		<tr>
<!-- 			<th>No:</th> -->
<!-- 			<th>Questions:</th> -->
<!-- 			<th>A:</th> -->
<!-- 			<th>B:</th> -->
<!-- 			<th>C:</th> -->
<!-- 			<th>answer:</th> -->
<!-- 			<th>Points:</th> -->
<!-- 			<th>Exam_code:</th> -->
<!-- 			<th>Teacher Id:</th> -->
	
		</tr>
		
<%-- 		<c:forEach items="${questions}" var="questionBank" > --%>
		<c:forEach var="counter" begin="0" end="${questions.size()-1}"> 
		<tr >
			
			<th><c:out value="${counter+1})"/></th>
			
			<th>${questions.get(counter).questions}</th>
		</tr>
				<tr >
					<td>
<!-- 					<select name=answers> -->
<%-- 							<option value="${questionBank.choice1}">${questionBank.choice1}</option> --%>
<%-- 							<option value="${questionBank.choice2}">${questionBank.choice2}</option> --%>
<%-- 							<option value="${questionBank.choice3}">${questionBank.choice3}</option> --%>
<!-- 					</select>  -->
						
						<td><input  type="checkbox" name="answers" value="${questions.get(counter).choice1}">${questions.get(counter).choice1}</td>
						<td><input  type="checkbox" name="answers" value="${questions.get(counter).choice2}">${questions.get(counter).choice2}</td>
						<td><input  type="checkbox" name="answers" value="${questions.get(counter).choice3}">${questions.get(counter).choice3}</td>
						<td><input  type="checkbox" name="answers" value="${questions.get(counter).choice4}">${questions.get(counter).choice4}</td>	
					

					<input type="hidden" name="exam_code"
						value="${questions.get(counter).exam_code}"></td>
					<%-- 			<td>${questionBank.answer}</td> --%>
<%-- 			<td>${questionBank.points}</td> --%>

<%-- 			<td>${questionBank.user_id}</td> --%>
		</tr>
			</c:forEach>
<%-- 		</c:forEach> --%>
		
		
	</table>
	
		
			<input type="submit" class="btn btn-primary">
	
	</form>
			</div>
		
				<h3>${msg}</h3>
		</div>
	</div>
	<script src="/js/jquery.min.js"></script>
	<script src="/js/popper.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/main.js"></script>
	<script src="/js/section1.js"></script>
	<script type="text/javascript">
// 	    window.onload = function () {
// 	        var div = document.getElementById("answers");
// 	        var chks = div.getElementsByTagName("INPUT");
// 	        for (var i = 0; i < chks.length; i++) {
// 	            chks[i].onclick = function () {
//  	                for (var i = 0; i < chks.length; i++) {
// 	                    if (chks[i] != this && this.checked) {
// 	                        chks[i].checked = false;
// 	                    }
//  	                }
// 	            };
// 	        }
// 	    };
	</script>
<!-- 	<script defer -->
<!-- 		src="https://static.cloudflareinsights.com/beacon.min.js/v2b4487d741ca48dcbadcaf954e159fc61680799950996" -->
<!-- 		integrity="sha512-D/jdE0CypeVxFadTejKGTzmwyV10c1pxZk/AqjJuZbaJwGMyNHY3q/mTPWqMUnFACfCTunhZUVcd4cV78dK1pQ==" -->
<!-- 		data-cf-beacon='{"rayId":"7b6acf5328f4cf9b","token":"cd0b4b3a733644fc843ef0b185f98241","version":"2023.3.0","si":100}' -->
<!-- 		crossorigin="anonymous"></script> -->
</body>

</html>
