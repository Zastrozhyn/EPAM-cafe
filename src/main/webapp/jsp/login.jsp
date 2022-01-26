<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AUTHORIZATION</title>
</head>
<body>
	<form method="POST" action="<c:url value="/controller"/>">
		<input type="hidden" name="command" value="login">
		login:<input name="login" required>
		<br/>
		<br/>
		password:<input name="password" type="password" required>
		<br/>
		<p><input type="submit"></p>
	</form>
	<a href="${pageContext.request.contextPath}/jsp/registration.jsp">REGISTRATION</a>
</body>
</html>