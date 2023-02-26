<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit The Contact Here</title>
</head>
<body>
	<form action = "editContactServlet" method="post">
		Name: <input type ="text" name = "name" value= "${contactToEdit.name}">
		Address: <input type = "text" name = "address" value= "${contactToEdit.address}">
		Phone Number: <input type = "text" name = "phoneNumber" value= "${contactToEdit.phoneNumber}">		
		<input type = "hidden" name = "id" value="${contactToEdit.id}">
		<input type = "submit" value="Save Edited Contact">
	</form>
</body>
</html>