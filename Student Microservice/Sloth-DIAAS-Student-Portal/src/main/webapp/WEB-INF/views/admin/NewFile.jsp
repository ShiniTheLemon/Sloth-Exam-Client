<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- 	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css" /> -->
	<link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap4.min.css" />
<title>Insert title here</title>
</head>
<body>
		<table id="users" class="table table-bordered table-striped" style="width:100%">
        <thead>
            <tr>
			<th>Faculty Id:</th>
			<th>Department Id:</th>
			<th>First Name:</th>
			<th>Last Name:</th>
			<th>Email:</th>
            </tr>
        </thead>
        <tbody>
		<c:forEach items="${users}" var="users" >
		<tr>
		
			<td>${users.user_id}</td>
			<td>${users.dept_id}</td>
			<td>${users.first_name}</td>
			<td>${users.last_name}</td>
			<td>${users.email}</td>
		
		</tr>
			</c:forEach>
	
		</tbody>
    </table>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
	
<!-- 	<script type="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap4.min.js"></script> -->
	<script>
		$(document).ready(function () {
			$("#users").DataTable();
		})
	</script>
</body>
</html>