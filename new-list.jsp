<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New List</title>
</head>
<body>
<form action = "createNewListServlet" method="post">
List Name: <input type ="text" name = "listName"><br />
Ticket date: <input type ="text" name = "month" placeholder="mm" size="4"> <input type ="text" name = "day" placeholder="dd" size="4">, <input type ="text" name = "year" placeholder="yyyy" size="4">
Store Name: <input type = "text" name = "storeName"><br />

Available Items:<br />

<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
   <option value = "${currentitem.id}">${currentitem.description} | ${currentitem.isCompleted}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create List and Add Items">
</form>
<a href = "index.html">Go add new items instead.</a>


</body>
</html>