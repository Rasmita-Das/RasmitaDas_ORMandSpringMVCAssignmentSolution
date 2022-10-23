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
<title>Save Customer</title>
</head>


<body>

	<div class="container">

		<h3>Customer Directory</h3>
		
		<hr>
		<p class="h4 mb-4">Customer</p>
		<form action="/CustomerManagement/customer/save" method="POST">
			<input type="hidden" name="id" value="${Customer.id}" />


			<div class="form-inline">
				<input type="text" name="fName" value="${Customer.fName}"
					class="form-control mb-4 col-4" placeholder="First Name">
			</div>

			
			<div class="form-inline">
				<input type="text" name="lName" value="${Customer.lName}"
					class="form-control mb-4 col-4" placeholder="Last Name">
			</div>
			
			
			<div class="form-inline">
				<input type="text" name="email" value="${Customer.email}"
					class="form-control mb-4 col-4" placeholder="Email">
			</div>


			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/CustomerManagement/customer/list">Back to Customers List</a>

	</div>
</body>

</html>