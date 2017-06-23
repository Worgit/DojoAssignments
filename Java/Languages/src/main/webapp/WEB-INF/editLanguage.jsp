<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><a href="/languages/delete/${id}">Delete</a></p>
	<p><a href="/languages">Dashboard</a></p>
	<form:form method="POST" action="/languages/edit/${id}" modelAttribute="language">
		<form:hidden path="id"/>
    	<form:label path="name">Name
    	<form:errors path="name"/>
    	<form:input path="name"/></form:label>
    	<form:label path="creator">Creator
    	<form:errors path="creator"/>
    	<form:textarea path="creator"/></form:label>
    	<form:label path="version">version
    	<form:errors path="version"/>
    	<form:input path="version"/></form:label>
    	<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>