<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Student Admin Register</title>
  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'><link rel="stylesheet" href="/css/adminStyle.css">

</head>
<body>
<!-- partial:index.partial.html -->
<nav class="mnb navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <i class="ic fa fa-bars"></i>
      </button>
      <div style="padding: 15px 0;">
         <a href="#" id="msbo"><i class="ic fa fa-bars"></i></a>
      </div>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">En</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">stemadmin@sloth.edu.cn<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Upgrade</a></li>
            <li><a href="#">Help</a></li>
            <li role="separator" class="divider"></li>
          </ul>
        </li>
        <li><a href="#"><i class="fa fa-bell-o"></i></a></li>
        <li><a href="#"><i class="fa fa-comment-o"></i></a></li>
      </ul>
<!--       <form class="navbar-form navbar-right"> -->
<!--         <input type="text" class="form-control" placeholder="Search..."> -->
<!--       </form> -->
    </div>
  </div>
</nav>
<!--msb: main sidebar-->
<div class="msb" id="msb">
		<nav class="navbar navbar-default" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<div class="brand-wrapper">
					<!-- Brand -->
					<div class="brand-name-wrapper">
						<a class="navbar-brand" href="#">
							<span class="glyphicon glyphicon-user"></span>Student Admin
						</a>
					</div>

				</div>

			</div>

			<!-- Main Menu -->
			<div class="side-menu-container">
				<ul class="nav navbar-nav">

					<li><a href="/student/admin/index"><i class="fa fa-dashboard"></i> Dashboard</a></li>
					<!-- Dropdown-->
					<li class="panel panel-default" id="dropdown">
						<a data-toggle="collapse" href="#dropdown-lvl1">
							<i class="fa fa-diamond"></i> Apps
						  <span class="caret"></span>
            </a>
						<!-- Dropdown level 1 -->
						<div id="dropdown-lvl1" class="panel-collapse collapse">
							<div class="panel-body">
								<ul class="nav navbar-nav">
									<li><a href="/users/chat">Mail</a></li>
									<li><a href="/student/admin/showAllUsers">Users</a></li>
									<li><a href="/student/admin/trascripts">Transcripts</a></li>

									<!-- Dropdown level 2 -->
									<li class="panel panel-default" id="dropdown">
										<a data-toggle="collapse" href="#dropdown-lvl2">
											<i class="glyphicon glyphicon-signal"></i>Admin <span class="caret"></span>
										</a>
										<div id="dropdown-lvl2" class="panel-collapse collapse">
											<div class="panel-body">
												<ul class="nav navbar-nav">
												<li><a href="/student/admin/grade/page">Credit Assignment</a></li>
                           						<li><a href="/student/admin/register/page">New User</a></li>
												</ul>
											</div>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</li>
					<li><a href="/logout"><span class="glyphicon glyphicon-off"></span> Log Out</a></li>
				</ul>
			</div><!-- /.navbar-collapse -->
		</nav>
</div>
<!--main content wrapper-->
<div class="mcw">
  <!--navigation here-->
  <!--main content view-->
  <div class="cv">
    <div>
     <div class="inbox">
       <div class="inbox-sb">

       </div>
       <div class="inbox-bx container-fluid">
         <div class="row">
           <div class="col-md-2">
             <ul>
               <li><a href="#">Inbox</a></li>
               <li><a href="#">Sent</a></li>
               <li><a href="#">Trash</a></li>
             </ul>
           </div>
           <div class="col-md-10">
		<form method="post" action="/student/admin/registered">
	
		 Student Number:<input name="id" type="number" class="form-control">
		Role:<select name="role" class="form-control">
			<option value="1">Student</option>
			<option value="2">Student Administrator</option>
		</select>
	
		
	
	
		Default Password:<input name="password" type="password" class="form-control">
		First Name:<input name="first_name" type="text" class="form-control">

	
		Last Name:<input name="last_name" type="text" class="form-control">
		
	   Department Id:<select name="dept_id" class="form-control">
			<c:forEach items="${dept}" var="dept">
				<option value="${dept.id}">${dept.dept_name}</option>
			</c:forEach>	
			</select>
		
		Year:<select name="year" class="form-control">
			<option value="Senior">Senior</option>
			<option value="junior">junior</option>
			<option value="Sophomore">Sophomore</option>
			<option value="Freshman">Freshman</option>
		</select>
		
	

		
		<input type="submit" value="Register" class="btn btn-primary" onclick="addUser()">
		</pre>
	</form>
		
           </div>
         </div>
       </div>
     </div>
    </div>
  </div>
</div>
<!-- partial -->
  <script src='https://code.jquery.com/jquery-3.1.1.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script><script  src="/js/adminScript.js"></script>
	<script>		
		function addUser(){
			alert("The User has been registered successfully!!");
		}
</script>
</body>
</html>
