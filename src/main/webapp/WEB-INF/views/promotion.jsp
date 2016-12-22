 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Users</title>
</head>
<body>
	<section>
		<div class="jumbotron"  style="background-color: #6A93F4">
			<div class="container">
				<h1>Your promotion <span text="${publishedItem.name}"></span> is successfully published.</h1>
				
				<p><spring:url value='/welcome' /><a class="btn btn-default pull-right"> Home</a> </p>
			</div>
   			
 	
			
		</div>
	</section>

</body>
</html>
