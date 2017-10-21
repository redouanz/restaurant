<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; UTF-8">
	<c:import url="../fragments/css.jsp"/>
	<title>Ajouter compte</title>
</head>
<body>
	<c:import url="../fragments/header.jsp"/>
	<div class="container">
		<h2>Ajouter une fili�re</h2>
		<br><br><br><br>
		<spring:url value="/filiere/add" var="formUrl"/>
		<form:form action="${formUrl}" method="POST" modelAttribute="filiere" cssClass="form-horizontal">
		<div class="form-group">
		  <label class="control-label col-sm-2" for="email">Fili�re:</label>
		  <div class="col-sm-10">
		    <form:input path="libelle" cssClass="form-control" placeholder="Nom de la fili�re"/>
		  </div>
		</div>
		<div class="form-group">        
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">Envoyer</button>
		    </div>
		</div>
		</form:form>
	</div>
	<c:import url="../fragments/js.jsp"/>
</body>
