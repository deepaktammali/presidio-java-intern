<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="utils.database.*"%>
<%@ page import="utils.database.baseclass.*"%>
<%@ page import="java.util.*"%>
<%@ page import="utils.beans.ShopItemsBean"%>

	<jsp:useBean id="cartItemsBean" class="utils.beans.CartItemsBean"></jsp:useBean>

	<jsp:include page="navbar.jsp">
		<jsp:param value="Vegetables Shop" name="pageTitle"/>
	</jsp:include>
	
	<%
	Vector<ItemDataModel> cartItems = (Vector<ItemDataModel>)session.getAttribute("cart");
	cartItemsBean.setCartItems(cartItems);
	%>
	<h1 class="ui center aligned header">Your Cart</h1>
	<div class="ui celled list" style="width:80vw;margin:auto;">
		<%=cartItemsBean.generateCartHTML()%>
	</div>

	<%-- <div class="ui cards" style="display:flex;justify-content:center;align-items:stretch;width:100%;">
		<%=cartItemsBean.generateCartHTML()%>
	</div> --%>
	<br />
	<button style="width:50vw;margin:auto;" class="fluid center aligned ui button"><a href="shop/invoice?action=getInvoice">Generate Invoice</a></button>
</body>
</html>