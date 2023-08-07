<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/Login.css">
<title>Student Login</title>
</head>
<body>
	<div class="wrapper">
		<div class="logo">
			<img src="/img/logo.jpg" alt="">
		</div>
		<div class="text-center mt-4 name">Sloth Exam Client</div>
		<form method="post" action="/student/login" class="p-3 mt-3">
			<div class="form-field d-flex align-items-center">
				<span class="far fa-user"></span> <input type="number" name="id"
					id="userName" placeholder="Student Id" required maxlength="11">
			</div>
			<div class="form-field d-flex align-items-center">
				<span class="fas fa-key"></span> <input type="password"
					name="password" id="pwd" placeholder="Password">
			</div>
			<button class="btn mt-3">Login</button>
		</form>
		
		<div class="text-center fs-6">
			<a href="/users/chat">Forget password?</a>
			<h5 style="color:red;">${msg}</h5>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
		charset="utf-8"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"
		charset="utf-8"></script>
</body>
</html>