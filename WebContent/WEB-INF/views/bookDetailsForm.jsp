<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	.error{
		color:red;
	}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Details Form</title>
</head>
<body>
	<h3>${msg}</h3>
	<form action="addAuthorsDetail" method="post">
	<table>
	
		<tr><td>Book ISBN:       </td><td><input type="text" name="isbn"/></td></tr>
		<tr><td>Title    :       </td><td><input type="text" name="title"/></td></tr>
		<tr><td>Category :       </td><td><select id="category" name="category">
												<option value="fiction">Fiction</option>
												<option value="satire">Satire</option>
												<option value="drama">Drama</option>
												<option value="romance">Romance</option>
												<option value="mystery">Mystery</option>
												<option value="horror">Horror</option>
												<option value="technical">Technical</option>
												<option value="biography">Biography</option>
												<option value="literature">Literature</option>
												<option value="science">Science</option>
										</select></td></tr>
										
		<tr><td>Publishing Year: </td><td><select id="publishingYear" name="publishingYear">
												<option value="2017">2017</option>
												<option value="2016">2016</option>
												<option value="2015">2015</option>
												<option value="2014">2014</option>
												<option value="2013">2013</option>
												<option value="2012">2012</option>
												<option value="2011">2011</option>
												<option value="2010">2010</option>
												<option value="2009">2009</option>
												<option value="2008">2008</option>
												<option value="2007">2007</option>
												<option value="2006">2006</option>
												<option value="2005">2005</option>
												<option value="2004">2004</option>
												<option value="2003">2003</option>
												<option value="2002">2002</option>
												<option value="2001">2001</option>
												<option value="2000">2000</option>
												<option value="1999">1999</option>
												<option value="1998">1998</option>
												<option value="1997">1997</option>
												<option value="1996">1996</option>
												<option value="1995">1995</option>
												<option value="1994">1994</option>
												<option value="1993">1993</option>
												<option value="1992">1992</option>
												<option value="1991">1991</option>
												<option value="1990">1990</option>
										</select></td></tr>
		<tr><td>Edition:         </td><td><select id="edition" name="edition">
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
												<option value="7">7</option>
												<option value="8">8</option>
												<option value="9">9</option>
												<option value="10">10</option>
												<option value="11">11</option>
												<option value="12">12</option>
												<option value="13">13</option>
												<option value="14">14</option>
												<option value="15">15</option>
												<option value="16">16</option>
												<option value="17">17</option>
												<option value="18">18</option>
												<option value="19">19</option>
												<option value="20">20</option>
												<option value="21">21</option>
												<option value="22">22</option>
												<option value="23">23</option>
												<option value="24">24</option>
												<option value="25">25</option>
										</select></td></tr>
		<tr><td>No of Copies:    </td><td><select id="noOfCopies" name="noOfCopies">
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
												<option value="7">7</option>
												<option value="8">8</option>
												<option value="9">9</option>
												<option value="10">10</option>
										</select></td></tr>
		<tr><td>				<input type="submit" value="Add Book Details"/></td></tr>
		
	</table>
	</form>
	
</body>
</html>