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
<title>Edit A Store</title>
</head>
<h1>Edit The Store Below</h1>

<form action = "editStoreServlet" method="post">
<div class="form-group">
<label for="storeName">Store Name:</label>
<input type = "text" name = "storeName"  value= "${storeToEdit.storeName}" size="100" required><br />
</div>

<div class="form-group">
<label for="storeAddress">Store Address:</label>
<input type = "text" name = "storeAddress"  value= "${storeToEdit.storeAddress}" size="100" required><br />
</div>

<div class="form-group">
<label for="phoneNumber">Store Phone Number:</label>
<input type = "text" name = "phoneNumber"  value= "${storeToEdit.phoneNumber}" size="7" required><br />
</div>


<input type = "hidden" name ="id" value= "${storeToEdit.storeCode}">
<input type = "submit" value="Save Edited Store" class="btn btn-primary">

</form>
<body>

</body>
</html>