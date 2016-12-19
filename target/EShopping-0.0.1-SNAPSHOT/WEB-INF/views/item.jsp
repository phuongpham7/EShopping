<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">@import url(resources/css/main.css);</style>
	<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
	<script src="<spring:url value="/resource/js/controllers.js"/>"></script>
<title>Items</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Items</h1>
			</div>
		</div>
	</section>
	<section class="container" >
 	
		<div class="row">
 		
			<div class="col-md-5">
				<h3>${item.name}</h3>
				<p>${item.description}</p>
				<p>
					<strong>Item Code : </strong><span class="label label-warning">${item.id}</span>
				</p>
 				<h4>${item.price} $ </h4>
				<p ng-controller="cartCtrl">
 
 <a href="<spring:url value="/items" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> back
					</a>

				</p>

			</div>
		</div>
<!--/div-->
	</section>
</body>
</html>
