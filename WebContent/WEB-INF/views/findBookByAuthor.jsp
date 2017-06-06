<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>
</head>
<body>
	
	<h2>Books matching your search Criteria:</h2>
	
	
	<table border="1">
		<tr>
			<td>Book ISBN</td>
			<td>Book Title</td>
			<td>Authors List</td>
		</tr>	
		<c:forEach var="book" items="${books}" varStatus="index">
			<tr> 
				<td>${book.isbn}</td>
				<td>${book.title}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>