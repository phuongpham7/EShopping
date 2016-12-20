<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin page</title>
<link rel='stylesheet' href='resources/css/bootstrap.min.css'>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="<spring:url value="/welcome" />">EShopping</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="<spring:url value="/admin" />">Home</a></li>
			<li><a href="<spring:url value="/admin/category" />">Category</a></li>
			<li><a href="#">Item</a></li>
			<li><a href="<spring:url value='/logout' />">Logout</a></li>
		</ul>
	</div>
	</nav>
</body>
</html>