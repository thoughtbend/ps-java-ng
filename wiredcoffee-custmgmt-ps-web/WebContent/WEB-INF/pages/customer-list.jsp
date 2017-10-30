<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="html-header.jsp" />
</head>
<body>
	<jsp:include page="site-header.jsp" />
	<div class="container">
		<h1>Wired Coffee Customers!</h1>
		<c:if test="${ not empty successMessage }">
			<div class="alert alert-success" role="alert"><c:out value="${ successMessage }" /></div>
		</c:if>
		<table>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${ customerList }" var="currentCustomer">
				<tr id="customer-${ currentCustomer.id }" data-customer-id="${ currentCustomer.id }" >
					<td><c:out value="${ currentCustomer.id }" /></td>
					<td><c:out value="${ currentCustomer.firstName }" /></td>
					<td><c:out value="${ currentCustomer.lastName }" /></td>
					<td><c:out value="${ currentCustomer.email }" /></td>
					<td><a href="${pageContext.request.contextPath}/app/customer/${ currentCustomer.id }"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>&nbsp;<span class="glyphicon glyphicon-trash delete-customer" aria-hidden="true"></span></td>
				</tr>
			</c:forEach>
		</table>
		<form id="deleteCustomerForm" method=POST action="">
		</form>
	</div>
	<jsp:include page="js-files.jsp" />
	<script type="text/javascript">
	/*
		function deleteCustomer(id) {
			$('#id').val(id);
			$('#deleteCustomerForm').submit();
		}
	*/	
	$(document).ready(function() {
		$('.delete-customer').each(function() {
			let rowIdValue = $(this).parents('tr').data('customer-id');
			$(this).click(function() {
				$('#deleteCustomerForm').prop('action', '${pageContext.request.contextPath}/app/customer/' + rowIdValue + '/delete').submit();
			});
		})
	});
	</script>
</body>
</html>