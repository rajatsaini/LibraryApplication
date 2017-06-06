<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Author Details</title>
</head>
<body>
	
	<h2>Please add Author of the Book</h2>
	
	<!-- <select name="cars" multiple>
	  <option value="volvo">Volvo</option>
	  <option value="saab">Saab</option>
	  <option value="opel">Opel</option>
	  <option value="audi">Audi</option>
	</select> -->
	
	<!-- <form action="addBook" method="post">
		
		<input type="checkbox" name="authors" value=""/>"Ram"
		<input type="checkbox" name="authors" value=""/>"Ram"
		<input type="checkbox" name="authors" value=""/>"Ram"
		<input type="checkbox" name="authors" value=""/>"Ram"
		<input type="checkbox" name="authors" value=""/>"Ram"
		
	</form> -->
	
	<form action="addBook" method="post">
		<c:forEach var="author" items="${authors}">
			<tr> 
				<td><input type="checkbox" name="author" value="${author.authorId}"/></td>
				<td>${author.authorName}</td>
				<br>
			</tr>
		</c:forEach>
		<input type="submit" value="Create Book"/>
	</form>
	
	<h4>${msg}</h4>
	
</body>
</html>