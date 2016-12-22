<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
<link rel='stylesheet' href='../resources/css/bootstrap.min.css'>
</head>
<body>     
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="<spring:url value="/welcome" />">EShopping</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="<spring:url value="/user" />">Home</a></li>
			<li class="active"><a
				href="<spring:url value="/user/category" />">Category</a></li>
			<li><a href="<spring:url value="/shoppingcart/cart" />">Cart</a></li>
			<li><a href="<spring:url value='/logout' />">Logout</a></li>
		</ul>
	</div>
	<br />
	<%-- <div>
		<a href="<spring:url value="/admin/crudCategory/${category.id}" />">
			<span class="btn btn-info">Choose category</span>
		</a>
	</div> --%>
	<br />
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Description</th>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categories}" var="category">
				<tr>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><a
						href="<spring:url value="/product/getProduct/${category.id}" />">
							<span class="btn btn-info">Choose</span>
					</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</nav>
</body>
</html>
