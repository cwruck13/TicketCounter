<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Tickets</title>
</head>
<body>
<form method = "post" action = "ticketNavigationServlet">
	<table>
	 <tr>
	 <th>TICKET SELECTION </th>
	 <th>STORE CODE</th>
	 <th>TICKET DESCRIPTION</th>
	 <th>TICKET DATE</th>
	 <th>IS COMPLETED</th>
  	</tr>
		<c:forEach items="${requestScope.allTickets}" var="currentticket">
			<tr>
				<td><input type="radio" name="id" value="${currentticket.id}"></td>
				<td>${currentticket.storeCode}</td>
				<td>${currentticket.description}</td>
				<td>${currentticket.ticketDate}</td>
				<td>${currentticket.isCompleted}</td>
			</tr>
		</c:forEach>
	</table>
	<input type ="submit" value = "edit" name="doThisToTicket">
	<input type = "submit" value = "delete" name="doThisToTicket">
	<input type = "submit" value = "add" name = "doThisToTicket">
</form>
</body>
</html>