<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Exams</title>
</head>
<body>
		<form method="post" action="AddExam">
		<pre>
		faculty id:<input name="user_id" type="text">
		exam code:<input name="exam_code" type="text">
	
		
		</pre>
		<pre>
		question 1:<input name="questions" type="text">
		points:<input name="points" type="text">
		</pre>
				<pre>
		question 2:<input name="questions" type="text">
		points:<input name="points" type="text">
		</pre>
			<pre>
		question 3:<input name="questions" type="text">
		points:<input name="points" type="text">
		</pre>
			<pre>
		question 4:<input name="questions" type="text">
		points:<input name="points" type="text">
		</pre>
			<pre>
		question 5:<input name="questions" type="text">
		points:<input name="points" type="text">
		</pre>
		

		
		<input type="submit" >
		</pre>
	</form>
	 <a href="/student/showAllSections">Check exam Schedule</a> 
		
</body>
</html>