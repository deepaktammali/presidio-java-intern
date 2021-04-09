<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="utils.database.*" %>
<%@ page import="utils.database.baseclass.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>

	
	<%
	Vector<String> cartItems = (Vector<String>)session.getAttribute("cart");
	if(cartItems==null) {
		out.print("<h2>Cart Is Empty</h2>");
	}
	else {
		double totalCartPrice = 0.0;
		out.print("<table>"+
				"<tr>"+
				"<th>Product Name</th>"+
				"<th>Product Price</th>"+
				"<th>Product Description</th>"+
			"</tr>");
		for(String item:cartItems) {
			ItemDataModel cartItem = Item.findByName(item);
			totalCartPrice+=cartItem.getPrice();
			out.print("<tr>");
			out.print("<td>"+cartItem.getName()+"</td>");
			out.print("<td>"+cartItem.getPrice()+"</td>");
			out.print("<td>"+cartItem.getDescription() +"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("Total Cart Price is : "+totalCartPrice);
	}
	%>
	
</body>
</html>