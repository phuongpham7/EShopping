<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">@import url(resources/css/main.css);</style>
<title>Items</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Items</h1>
				<p>All the available items in our store</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${items}" var="item">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
					<!-- img src="<c:url value="/resource/images/${item.itemId}.png"></c:url>" alt="image"  style = "width:100%"/-->
						<div class="caption">
							<h3>${item.name}</h3>
							<p>${item.description}</p>
							<p>${item.price}USD</p>
 							<p>
								<a
									href=" <spring:url value="/items/item?id=${item.id}" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Details
								</a>
							</p>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
