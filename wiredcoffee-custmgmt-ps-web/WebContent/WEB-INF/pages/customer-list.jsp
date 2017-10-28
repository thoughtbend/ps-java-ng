<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Wired Coffee Customer Management</title>
	<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/site.css" rel="stylesheet">
</head>
<body>
Wired Coffee Customers!<br/>
<table>
<tr>
<th>ID</th>
<th>First Name</th>
<th>Last Name</th>
</tr>
<c:forEach items="${ customerList }" var="currentCustomer">
<tr>
	<td><c:out value="${ currentCustomer.id }" /></td>
	<td><c:out value="${ currentCustomer.firstName }" /></td>
	<td><c:out value="${ currentCustomer.lastName }" /></td>
</tr>
</c:forEach>
</table>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</body>
</html>