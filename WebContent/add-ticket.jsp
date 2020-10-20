<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Add A Ticket</title>
</head>
<h1>Add The Ticket Below</h1>
<h3>Please note that you are only able to add to a store that already exits!</h3>
<form action = "addTicketServlet" method="post">
<div class="form-group">
<label for="storeCode">Store Code:</label>
<select name ="storeCode">
<c:forEach items="${requestScope.allStores}" var="currentstore">
				<option>${currentstore.storeCode}</option>	
</c:forEach>
</select>
</div>

<div class="form-group">
<label for="description">Description:</label>
<input type = "text" name = "description"  value= "Please enter a description" size="100"><br />
</div>

<div class="form-group">
<label for="ticketDate">Date:</label>
<input type = "text" name = "description"  value= "YYYY-MM-DD" size="100"><br />
</div>

<div class="form-group">
<label for="isCompleted">Ticket Complete?:</label>
<select name="isCompleted">
<option value ="true" > Complete </option>
<option value = "false"> Not Complete </option>
</select>
</div>

<input type = "submit" value="NewTicket" class="btn btn-primary">

</form>
<body>

</body>
</html>