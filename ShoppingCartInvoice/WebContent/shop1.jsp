<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="utils.database.*"%>
<%@ page import="utils.database.baseclass.*"%>
<%@ page import="java.util.*"%>
<%@ page import="utils.beans.ShopItemsBean"%>

	<jsp:useBean id="shopItemsBean" class="utils.beans.ShopItemsBean"></jsp:useBean>

	<jsp:include page="navbar.jsp">
		<jsp:param value="Vegetables Shop" name="pageTitle"/>
		<jsp:param value="shop1" name="shopName"/>
	</jsp:include>
<h1 class="ui center aligned header">Vegetables</h1>
	<div class="ui cards" style="display:flex;justify-content:center;align-items:stretch;width:100%;">
		<%=shopItemsBean.generateShopHTML("vegetable", "shop1") %>
	</div>
</body>
</html>