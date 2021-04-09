<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="utils.database.*" %>
<%@ page import="utils.database.baseclass.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="shop/shop1" method="POST">
<table>
<tr>
	<th>Name</th>
	<th>Price</th>
	<th>Select</th>
</tr>
<%
	ArrayList<Item> shopItems = Item.findAll();
	
	for(Item item:shopItems){
		out.print("<tr>");
		out.print("<td>"+item.getName()+"</td>");
		out.print("<td>"+item.getPrice()+"</td>");
		out.print("<td>"+"<input type='checkbox' name='"+item.getName()+"'/>"+"</td>");
		out.print("</tr>");
	}
	
%>
</table>
<button type="submit">Add To Cart</button>	
</form>
</body>
</html>