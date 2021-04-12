<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="utils.database.*"%>
<%@ page import="utils.database.baseclass.*"%>
<%@ page import="java.util.*"%>
<%@ page import="utils.beans.ShopItemsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to shop1</title>
</head>
<body>

	<jsp:useBean id="shopItemsBean" class="utils.beans.ShopItemsBean"></jsp:useBean>
	<form action="shop/shop1" method="POST">
		<table>
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Select</th>
			</tr>
			<%=shopItemsBean.generateHTML()%>
		</table>
		<input type="hidden" name="action" value="postShop1" />
		<button type="submit">Add To Cart</button>
	</form>
</body>
</html>