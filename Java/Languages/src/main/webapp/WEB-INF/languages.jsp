<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<c:forEach items="${languages}" var="element" varStatus="loop">
		<tr>      
    		<td><c:out value="${element.name}"/></td>
    		<td><c:out value="${element.creator}"/></td>
    		<td><c:out value="${element.version}"/></td>
    		<td><a href="/languages/delete/${element.id}">Delete</a> <a href="/languages/edit/${element.id}">Edit</a></td>
		</tr>
	</c:forEach>
	</table>
	<form:form method="POST" action="/languages/new" modelAttribute="language">
		<form:hidden path="id"/>
    	<form:label path="name">Name
    	<form:errors path="name"/>
    	<form:input path="name"/></form:label>
    	<form:label path="creator">Creator
    	<form:errors path="creator"/>
    	<form:input path="creator"/></form:label>
    	<form:label path="version">Version
    	<form:errors path="version"/>
    	<form:input path="version"/></form:label>
    	<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>