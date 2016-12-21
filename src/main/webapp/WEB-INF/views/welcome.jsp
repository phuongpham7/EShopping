<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<style type="text/css">@import url(resources/css/main.css);</style>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1> ${greeting} </h1>
  					
 
			</div>	 
 			<div class="container"> 
 			
 		Welcome  ${user.firstName} !	<img align="right" width="100%"  height="50%" src="<c:url value="${welcomeimage}"/>"/>
 			</div>
				  <div class="container">
					<c:choose>
					    <c:when test="${empty user}">
      					<a href="<spring:url value='/login' />" class="btn btn-default pull-right"> Login</a>
					    </c:when>
					    <c:otherwise>
					       <a href="<spring:url value="/users/email" />" class="btn btn-default pull-right">Send Email</a>	
		 					
		 					<a href="<spring:url value="/users/add" />" class="btn btn-default pull-right">Add User</a>	
		 					<a href="<spring:url value="/users" />" class="btn btn-default pull-right">Users List</a>	
		 					<br>
		 					<a href="<spring:url value="/items/add" />" class="btn btn-default pull-right">Add Item</a>	
		 					<a href="<spring:url value="/items/all" />" class="btn btn-default pull-right">Item List</a>	
		 					<br>
		 					<a href="<spring:url value='/logout' />" class="btn btn-default pull-right"> Logout</a>
		 
 					    </c:otherwise>
					</c:choose>	
 					 <a href="<spring:url value='/users' />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Go to Community
					</a>
				</div>	
	 			<div class="pull-left"> <h3>${SpecialBlurb}</h3> </div>
		</div>	
	</section>
	
</body>
</html>
