<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="navbar.jsp">
	<jsp:param value="Login Page" name="pageTitle" />
</jsp:include>


<form class="ui form" style="width: max(60vw, 30rem); margin: auto"
	method="POST" action="login">
	<input type="hidden" name="action" value="postLogin" />
	<div class="field">
		<label>Username</label> <input type="text" name="username" required
			placeholder="Username">
	</div>
	<div class="field">
		<label>Password</label> <input type="text" name="password" required
			placeholder="Password">
	</div>
	<button class="ui button" type="submit">Login</button>
</form>

</body>
</html>