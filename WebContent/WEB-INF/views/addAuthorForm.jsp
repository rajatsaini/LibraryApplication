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
	
	<form action="addNewAuthor" method="post">
		Add Author Name :
		<input type="text" name="authorName"/>
		<input type="submit" value="Add Author"/>
	</form>
	
</body>
</html>