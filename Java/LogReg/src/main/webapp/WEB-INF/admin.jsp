<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome ${admin.firstName}</h1>
	<form id="logoutForm" method="POST" action="/logout">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="Logout!" />
	</form>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Admin</th>
			</tr>
		</thead>
		<c:forEach items="${users}" var="user" varStatus="loop">
			<tr>      
    			<td><c:out value="${user.firstName} ${user.lastName}"/></td>
    			<td><c:out value="${user.email}"/></td>
    			<td>
    			<c:if test="${!user.roles.contains(role)}">
    				<a href="/user/${user.id}/delete">Delete</a> <a href="/user/${user.id}/promote">Make Admin</a>
    			</c:if>
    			<c:if test="${user.roles.contains(role)}">
    				<p>admin</p>
    			</c:if>
    			</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>