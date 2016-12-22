<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Promotion</title>
</head>
<body>
	<section>
		<div class="jumbotron" style="background-color: #8801FE">
			<div class="container">
				<h1>Promotions</h1>
				<p>Add New Item to promote</p>
			</div>
 		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="newItem" class="form-horizontal" >
			<fieldset>
				<legend>Publish New Item on Items Topic </legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="itemId"><spring:message code="addItem.form.itemId.label"/></label>
					<div class="col-lg-10">
						<form:input id="itemId" path="itemId" type="text" class="form:input-large"/>
						<form:errors path="itemId" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="name"><spring:message code="addItem.form.name.label"/></label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="form:input-large"/>
						<form:errors path="name" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="price"><spring:message code="addItem.form.price.label"/></label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="price" path="price" type="text" class="form:input-large"/>
							<form:errors path="price" cssClass="text-danger"/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="description"><spring:message code="addItem.form.description.label"/></label>
					<div class="col-lg-10">
						<form:textarea id="description" path="description" rows = "2"/>
					</div>
				</div>


				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Publish"/>
					</div>
				</div>
				 <p><button type=button onclick=window.location.href="<spring:url value="/welcome" />">Home</button></p>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
