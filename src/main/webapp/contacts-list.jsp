<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Contacts</title>
</head>
<body>	
	<form method = "post" action = "navigationServlet">
		
		<table>
			<c:forEach items="${requestScope.allContacts}" var="currentContact">
				<tr>
					 <td><input type="radio" name="id" value="${currentContact.id}"></td>
					 <td>${currentContact.name}</td>
					 <td>${currentContact.address}</td>
					 <td>${currentContact.phoneNumber}</td>							 						
					 <c:forEach var="listVal" items = "${currentContact.pets}">
					 	<tr><td></td><td colspan="3">${listVal.petName}</td></tr>
					 </c:forEach>
			 	</tr>
			</c:forEach>
		</table>
		<input type = "submit" value = "edit contact" name="doThisToContact">
		<input type = "submit" value = "edit contact pets" name="doThisToContact">		
		<input type = "submit" value = "delete" name="doThisToContact">
		<input type="submit" value = "add" name = "doThisToContact">
	</form>
</body>
</html>