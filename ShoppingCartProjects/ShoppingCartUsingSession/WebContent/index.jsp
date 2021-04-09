<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="utils.database.baseclass.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to shop market</title>
</head>
<body>
	<%
		UserModel currUser = (UserModel)session.getAttribute("currUser");
		if(currUser!=null){
			out.print("<h2>Welcome "+currUser.getUsername()+"</h1>");
		}
	%>
	<a href="shop/shop1">Shop1</a>
	<a href="shop/shop2">Shop2</a>
	<a href="shop/shop3">Shop3</a>
	<a href="shop/cart">Cart</a>
	
	<%
		Boolean isLoggedIn = (Boolean)session.getAttribute("isLoggedIn");

		if(isLoggedIn==null){
			out.print("<form action='login' method='GET'>"
					+"<button type='submit'>Login</button>"
					+"</form>");
		}
		else{
			UserModel user = (UserModel)session.getAttribute("currUser");
			System.out.println(user.getUsername());
			
			out.print("<form action='logout' method='POST'>"
					+"<input type='hidden' name='username' value='"+user.getUsername()+"' />"
					+"<button type='submit'>Logout</button>"
					+"</form>");
		}
		
	%>
	
</body>
</html>