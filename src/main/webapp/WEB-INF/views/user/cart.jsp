<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
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
			<li><a href="<spring:url value="/user/category" />">Category</a></li>
			<li class="active"><a
				href="<spring:url value="/shoppingcart/cart" />">Cart</a></li>
			<li><a href="<spring:url value='/logout' />">Logout</a></li>
		</ul>
	</div>
	</nav>

	<table class="table table-bordered">
		<thead>
			<tr>
				<th></th>
				<th>Name</th>
				<th>Item ID</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${items}" var="item">
				<tr>
					<td><img
						src="<c:url value="../resources/images/items/${item.itemId}.png"/>"
						alt="test" /></td>
					<td>${item.name}</td>
					<td>${item.itemId}</td>
					<td>${item.price}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a href="<spring:url value="/admin/editItem/${item.id}" />">
			<span class="btn btn-info">Edit / Delete</span>
	</a>
</body>
</html>
