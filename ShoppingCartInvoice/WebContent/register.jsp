<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="navbar.jsp">
	<jsp:param value="Register Page" name="pageTitle" />
</jsp:include>

<form class="ui form" style="width: max(60vw, 30rem); margin: auto"
	method="POST" action="register">
	<input type="hidden" name="action" value="postRegister"/>
	<div class="field">
		<label>Username</label> <input type="text" name="username" required
			placeholder="Username">
	</div>
	<div class="field">
		<label>Password</label> <input type="text" name="password" required
			placeholder="Password">
	</div>
	<button class="ui button" type="submit">Register</button>
</form>

</body>
</html>