<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	
	<%@include file="languagedropdown.jsp" %>
	<jsp:useBean id="loginLocale" class="utils.beans.LocalBean" scope="session"></jsp:useBean>
	
	<%
		String localeString = request.getParameter("locale");
		request.setAttribute("localeString", localeString);
		System.out.println(localeString);
		if(localeString==null){
			loginLocale.setCurrentLocale(Locale.getDefault());
			request.setAttribute("localeString", "en");
		}
		else{
			loginLocale.setCurrentLocale(new Locale(localeString));
			request.setAttribute("localeString", localeString);
		}
	%>

	<form method="POST" action="login">
			<label id="username_label"><%=loginLocale.getString("Username")%></label> : <input type="text" name="username" required><br />
			<label id="passsword_label"><%=loginLocale.getString("Password")%></label> : <input type="password" name="password" required><br />
			<input type="hidden" name="action" value="postLogin"/>
			<button style="margin-top:0.5rem;border:none;padding:0.5rem 1rem" type="submit">Login</button>
	</form>
	
	
	
	<script>
	var localeString = "<%=request.getAttribute("localeString")%>";
	document.querySelector("#locale").value=localeString;
	document.querySelector("#locale").addEventListener("change",function (e){
		var params = [
        "locale="+e.target.value,
        "action=getLogin"
    	];
		window.location.href = "http://" + window.location.host + window.location.pathname + '?' + params.join('&');
	});
	</script>
</body>
</html>