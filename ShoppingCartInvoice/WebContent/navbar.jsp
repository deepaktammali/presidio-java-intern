<%@page import="utils.database.baseclass.UserModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="header.jsp">
	<jsp:param value='<%=request.getParameter("pageTitle")%>'
		name="pageTitle" />
</jsp:include>

<jsp:useBean id="homeauthbutton" class="utils.beans.HomeAuthButtonBean" scope="page"></jsp:useBean>

<% 
	homeauthbutton.setLoggedIn((Boolean)session.getAttribute("isLoggedIn"));
	homeauthbutton.setCurrUser((UserModel)session.getAttribute("currUser"));
%>

<div style="padding: 4px 14px" class="ui inverted segment">
	<div class="ui inverted secondary menu">
		<a class="item disabled"> Shoppers Stop </a> 
		<a class="item" href="shop/shop1?action=getShop1">Vegetables </a> 
		<a class="item" href="shop/shop2?action=getShop2"> Fruits </a> 
		<a class="item" href="shop/shop3?action=getShop3">Household Items</a>

		<div class="right menu">
<!-- 			<div class="ui inverted compact menu">
				<div class="ui simple dropdown item">
					Language <i class="dropdown icon"></i>
					<div class="menu">
						<div class="item">English</div>
						<div class="item">Telugu</div>
						<div class="item">Tamil</div>
					</div>
				</div>
			</div> -->
			<a class="item" href="shop/cart?action=getCart">Cart</a>
			<%
			UserModel currUser = homeauthbutton.getCurrUser();
			if(currUser!=null){
				String user = currUser.getUsername();
				out.print("<div class=\"item\">"
						+"Welcome "+user
						+"</div>");
			}
			%>
			<div class="item">
				<%= homeauthbutton.generateAuthButtonHTML()%>
			</div>
		</div>
	</div>
</div>

