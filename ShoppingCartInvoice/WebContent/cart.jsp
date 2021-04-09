<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="utils.database.*" %>
<%@ page import="utils.database.baseclass.*" %>
<%@ taglib prefix="customtag" uri="customtags" %>
<%@ page import="utils.beans.CartItemsBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>
	<jsp:useBean id="cartItemsBean" class="utils.beans.CartItemsBean" scope="application" />
	
	<%
		Vector<String> cartItems = (Vector<String>)session.getAttribute("cart");
		cartItemsBean.setCartItems(cartItems);
		out.print(cartItemsBean.generateHTML());
	%>
	<br />
	<a href="shop/invoice?action=getInvoice"><button>Generate Invoice</button></a>
</body>
</html>