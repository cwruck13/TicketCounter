<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Add A Store</title>
</head>
<h1>Create A Store</h1>
<h3>Please note that you are unable to a create a store with the
	following store codes:</h3>
<table>
	<tr>
		<th>Store Name</th>
		<th>Store Code</th>
	</tr>
	<c:forEach items="${requestScope.allStores}" var="currentstore">
		<tr>
			<td>${currentstore.storeName}</td>
			<td>${currentstore.storeCode}</td>
		</tr>
	</c:forEach>

</table>


<form action="addStoreServlet" method="post">
	<div class="form-group">
		<label for="storeCode">Store Code:</label> <input type="text"
			name="storeCode" value="XXXX" size="4"
			maxlength="4"><br />
	</div>

	<div class="form-group">
		<label for="storeName">Store Name:</label> <input type="text"
			name="storeName" value="Please enter a Store Name" size="100"><br />
	</div>

	<div class="form-group">
		<label for="storeAddress">Store Address:</label> <input type="text"
			name="storeAddress" value="Please enter a Store Address" size="100"><br />
	</div>

	<div class="form-group">
		<label for="phoneNumber">Store Phone Number</label> <input type="text"
			name="phoneNumber" value="XXX-XXX-XXXX" size="12"><br />
	</div>


	<input type="submit" value="NewStore" class="btn btn-primary">

</form>
<body>

</body>
</html>