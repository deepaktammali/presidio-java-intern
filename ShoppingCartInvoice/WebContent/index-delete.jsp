<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="utils.database.baseclass.*" %>

	<jsp:include page="navbar.jsp">
		<jsp:param value="HomePage" name="pageTitle"/>
	</jsp:include>
	<%
		UserModel currUser = (UserModel)session.getAttribute("currUser");
		if(currUser!=null){
			out.print("<h2>Welcome "+currUser.getUsername()+"</h1>");
		}
	%>
	<a href="shop/shop1?action=getShop1">Shop1</a>
	<a href="shop/shop2?action=getShop2">Shop2</a>
	<a href="shop/shop3?action=getShop3">Shop3</a>
	<a href="shop/cart?action=getCart">Cart</a>
	
	<%
		Boolean isLoggedIn = (Boolean)session.getAttribute("isLoggedIn");

		if(isLoggedIn==null){
			out.print("<form action='login' method='GET'>"
					+"<input type=\"hidden\" name=\"action\" value=\"getLogin\"/>"
					+"<button type='submit'>Login</button>"
					+"</form>");
		}
		else{
			UserModel user = (UserModel)session.getAttribute("currUser");
			
			if(user==null){
				out.print("<form action='login' method='GET'>"
						+"<input type=\"hidden\" name=\"action\" value=\"getLogin\"/>"
						+"<button type='submit'>Login</button>"
						+"</form>");
			}
			else{
				System.out.println(user.getUsername());
				
				out.print("<form action='logout' method='POST'>"
						+"<input type='hidden' name='username' value='"+user.getUsername()+"' />"
						+"<input type=\"hidden\" name=\"action\" value=\"postLogout\"/>"
						+"<button type='submit'>Logout</button>"
						+"</form>");
			}
		}
		
	%>
	
</body>
</html>