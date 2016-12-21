<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Item</title>
<link rel='stylesheet' href='../../resources/css/bootstrap.min.css'>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="<spring:url value="/welcome" />">EShopping</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="<spring:url value="/admin" />">Home</a></li>
			<li><a href="<spring:url value='/admin/category' />">Category</a></li>
			<li class="active"><a href="<spring:url value='/admin/item' />">Item</a></li>
			<li><a href="<spring:url value='/logout' />">Logout</a></li>
		</ul>
	</div>
	</nav>

	<input id="itemId" name="id" type="hidden" value="${item.id}" />
	<div class="container">
		<div class="form-group">
			&nbsp;&nbsp;<label>Edit Item</label>
			<form action="<spring:url value="/admin/deleteItem/${item.id}"></spring:url>"
				method="post">
				<input id="delete" name="delete" type="submit" class="btn btn-info"
					value='Delete' />
			</form>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="name">Name</label> <input
				id="name" name="name" value="${item.name}" class="form-control" />
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="itemId">Item Id</label> <input
				id="itemId" name="itemId" value="${item.itemId}" class="form-control" />
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="description">Description</label>
			<textarea rows="10" cols="20" id="description" name="description"
				class="form-control">${item.description}</textarea>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="description">Category</label>
			<c:forEach items="${categories}" var="category">
				<label class="checkbox-inline"><input type="radio"
					name="category" value="${category.id}" id="category" />${category.name}
				</label>
			</c:forEach>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="price">Price</label> <input
				id="price" name="price" value="${item.price}" class="form-control" />
		</div>
		<div class="form-group">
			<div class="fileinput fileinput-new" data-provides="fileinput">
				<span class="btn btn-default btn-file"><span>Choose
						file</span><input type="file" name="itemImagee" /></span> <span
					class="fileinput-filename"></span> <img
					src="<c:url value="../resources/images/items/${item.itemId}.png"/>"
					alt="test" />
			</div>
		</div>
		<form action="<spring:url value="/admin/editItem"></spring:url>"
			method="post">
			<div class="form-group">

				<input id="update" name="save" type="submit" class="btn btn-info"
					value='Update' /> <a href="<spring:url value="/admin/item" />">
					<span class="btn btn-info">Cancel</span>
				</a>
			</div>
		</form>
	</div>

</body>
</html>