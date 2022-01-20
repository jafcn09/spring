<%@ include file="header.jsp" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
	<!-- jQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	 <!-- Bootstrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>

<section th:fragment="lista de aulas" id="aula">
<div class="container">
<div class="row">
<div class="col-md-9">
<div class="card">
<div class="card-header">
<h4>LISTADO DEL AULA</h4>

</div>
<div th:if="${aulas != null and !aulas.empty }">
<table class="table table-strped">
<thead class="thead-dark">
<tr>
<th>
<c:forEach items="${numaula}" var="aula"> 

</c:forEach>
</th>
<th th:text="#{aulas.capacidad }">Capacidad de la ula</th>
<th th:text="#{aulas.numaula }">Nombre de la aula</th>
<th th:text="#{aulas.descripcion }">Descripcion del aula</th>

</tr>
<tr>


</thead>

</table>
</div>
</div>
</div>
</div>
</div>

</section>
</body>
</html>