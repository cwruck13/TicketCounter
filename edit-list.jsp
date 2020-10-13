<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Existing List</title>
</head>
<body>
<form action = "editListDetailsServlet" method="post">
<input type ="hidden" name = "id" value= "${listToEdit.id}">
List Name: <input type ="text" name = "listName" value= "${listToEdit.listName}"><br />
Ticket date: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}"> <input type ="text" name = "day" placeholder="dd" size="4" value= "${date}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}">
Store Name: <input type = "text" name = "storeName" value= "${listToEdit.store.storeName}"><br />

Available Tickets:<br />

<select name="allTicketsToAdd" multiple size="6">
<c:forEach items="${requestScope.allTickets}" var="currentitem">
   <option value = "${currentitem.id}">${currentitem.description} | ${currentitem.isCompleted}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Edit List and Add Items">
</form>
<a href = "index.html">Go add new tickets instead</a>

</body>
</html>