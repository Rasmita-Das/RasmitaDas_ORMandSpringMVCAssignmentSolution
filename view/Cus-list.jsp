<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Customer Directory</title>
</head>

<body>

	<div class="container">

		<h3>Customer Directory</h3>
		<hr>


		<form class="form-inline">
			<a href="/CustomerManagement/customer/showFormForAdd"
				class="btn btn-primary btn-sm mb-3"> Add Customer </a> 
		</form>


		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>


			<tbody>
				<c:forEach items="${Customer}" var="cus1">
					<tr>
						<td><c:out value="${cus1.fName}" /></td>
						<td><c:out value="${cus1.lName}" /></td>
						<td><c:out value="${cus1.email}" /></td>
						<td>
							<a
							href="/CustomerManagement/customer/showFormForUpdate?customerId=${cus1.id}"
							class="btn btn-info btn-sm"> Update </a>
							
							<a href="/CustomerManagement/customer/delete?customerId=${cus1.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this Customer Details?'))) return false"> Delete </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>

</html>