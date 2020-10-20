<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Stores</title>
</head>
<body>
	<form method="post" action="storeNavigationServlet">
		<table>
			<tr>
				<th>STORE SELECTION</th>
				<th>STORE CODE</th>
				<th>STORE NAME</th>
				<th>STORE ADDRESS</th>
				<th>PHONE NUMBER</th>
			</tr>
				<c:forEach items="${requestScope.allStores}" var="currentstore">
				<tr>
					<td><input type="radio" name="id"
						value="${currentstore.storeCode}" required></td>
					<td>${currentstore.storeCode}</td>
					<td>${currentstore.storeName}</td>
					<td>${currentstore.storeAddress}</td>
					<td>${currentstore.phoneNumber}</td>
			
			</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToStore"> <input
			type="submit" value="add" name="doThisToStore">
	</form>
</body>
</html>